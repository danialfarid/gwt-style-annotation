package com.df.gwt.style.annotation;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.df.gwt.style.annotation.JavaClassStyleData.MethodData;
import com.df.gwt.style.annotation.client.Style.Dir;
import com.df.gwt.style.annotation.client.UserAgent;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JField;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JParameter;
import com.google.gwt.core.ext.typeinfo.JPrimitiveType;

public class AddStylesStatementsGenerator {

	public static final String NEGATE_STR = "NOT_";
	public static final String WIDGET_LOCAL_VAR_UNIQUE = "ANNOTATION_STYLE_WIDGET_LOCAL_VAR_UNIQUE_NAME__";

	private final String cssResourceClass;
	private final JavaClassStyleData styleData;

	public AddStylesStatementsGenerator(final JavaClassStyleData styleData, final String cssResourceClass) {
		this.styleData = styleData;
		this.cssResourceClass = cssResourceClass;
	}

	public String generateInitialization(final String var) {
		final StringBuilder string = new StringBuilder();
		for (final RuleData<JClassType> ruleData : styleData.initStyleData) {
			string.append(syleAddStatements(var == null ? "this" : var, ruleData.getCssClassNameToConditionMap().entrySet()));
			string.append(userDefinedSyleAddStatements(var == null ? "this" : var, ruleData.userDefinedStyles));
		}

		for (final RuleData<JField> ruleData : styleData.fieldStyleData) {
			string.append(syleAddStatements(ruleData.element.getName(), ruleData.getCssClassNameToConditionMap().entrySet()));
			string.append(userDefinedSyleAddStatements(ruleData.element.getName(), ruleData.userDefinedStyles));
		}
		return string.toString();
	}

	public String generateMethodOverrides() {
		final StringBuilder string = new StringBuilder();

		for (final MethodData methodData : styleData.methodStyleData) {
			final boolean isVoid = JPrimitiveType.VOID.equals(methodData.methodData.element.getReturnType().isPrimitive());
			final String methodReturnType = methodData.methodData.element.getReturnType().getParameterizedQualifiedSourceName();
			final String methodName = methodData.methodData.element.getName();
			final String argsList = getMethodArgsList(methodData.methodData.element);
			string.append(
					"\r\n" +
					"	@Override\r\n" +
					//transient is removed because gwt get confused when you have varargs method like method(A... as) and think it is transient
					"	" + methodData.methodData.element.getReadableDeclaration().replace("transient ", "") + " {\r\n" +
					"		" + (!isVoid ? methodReturnType + " " + WIDGET_LOCAL_VAR_UNIQUE + " = " : "") +
					"super." + methodName + "(" + argsList + ");\r\n" +
					syleAddStatements(isVoid ? "this" : WIDGET_LOCAL_VAR_UNIQUE, methodData.methodData.getCssClassNameToConditionMap().entrySet()) +
					userDefinedSyleAddStatements(isVoid ? "this" : WIDGET_LOCAL_VAR_UNIQUE, methodData.methodData.userDefinedStyles) +
					paramsAddStyleStatements(methodData.paramsData) +
					paramsUserDefinedSyleAddStatements(methodData.paramsData) +
					(isVoid ? "" : "		return " + WIDGET_LOCAL_VAR_UNIQUE + ";\r\n") +
					"	}\r\n"
			);
		}
		return string.toString();
	}

	String getMethodArgsList(final JMethod method) {
		final StringBuilder string = new StringBuilder();
		final JParameter[] parameters = method.getParameters();
		for (final JParameter parameter : parameters) {
			string.append(parameter.getName()).append(", ");
		}
		if (parameters.length > 0) string.delete(string.length() - 2, string.length());
		return string.toString();
	}

	String paramsAddStyleStatements(final List<RuleData<JParameter>> paramsData) {
		final StringBuilder string = new StringBuilder();
		for (final RuleData<JParameter> paramRule : paramsData) {
			string.append(syleAddStatements(paramRule.element.getName(), paramRule.getCssClassNameToConditionMap().entrySet()));
		}
		return string.toString();
	}

	String paramsUserDefinedSyleAddStatements(final List<RuleData<JParameter>> paramsData) {
		final StringBuilder string = new StringBuilder();
		for (final RuleData<JParameter> paramRule : paramsData) {
			string.append(userDefinedSyleAddStatements(paramRule.element.getName(), paramRule.userDefinedStyles));
		}
		return string.toString();
	}

	String syleAddStatements(final String var, final Set<Entry<String, ConditionData>> set) {
		final StringBuilder str = new StringBuilder();
		for (final Entry<String, ConditionData> entry : set) {
			final String cssClassName = entry.getKey();
			final ConditionData condition = entry.getValue();
			str.append(cssClassName == null ? "" :
				(
						"		" + (condition.isEmpty() ? "if (" + var + " != null)" : "if ((" + var + " != null) && (" + getConditionStatement(condition) + ")) ") +
						var+".addStyleName(" + cssResourceClass + ".css_UNIQUE_METHOD_NAME()." + cssClassName + "());\r\n"
				));
		}
		return str.toString();
	}

	String userDefinedSyleAddStatements(final String var, final Set<Annotation> userDefinedStyles) {
		final StringBuilder str = new StringBuilder();
		for (final Annotation annotation : userDefinedStyles) {
			final String cssClassName = Util.toVariableName(annotation.annotationType().getCanonicalName());
			str.append(
					"		" + cssResourceClass + "." + "apply_" + cssClassName + "(" + var + ");\r\n"
			);
		}
		return str.toString();
	}

	String getConditionStatement(final ConditionData condition) {
		if (condition.isEmpty()) return "false";
		final StringBuilder string = new StringBuilder();
		if (condition.userAgents != null) {
			string.append("(");
			for (final Class<? extends UserAgent> ua : condition.userAgents) {
				string.append(cssResourceClass + "." + Util.toVariableName(ua.getCanonicalName())).append(" || ");
			}
			string.delete(string.length() - 4, string.length());
			string.append(") && ");
		}
		if (condition.locale != null && condition.locale.length > 0) {
			string.append("(");
			for (final String l : condition.locale) {
				string.append(cssResourceClass + "." + l).append(" || ");
			}
			string.delete(string.length() - 4, string.length());
			string.append(") && ");
		}
		if (condition.dir != Dir.ALL) {
			string.append((condition.dir == Dir.RTL ? "" : "!") + cssResourceClass + "." + Dir.RTL.name()).append(" && ");
		}
		if (!Util.isEmpty(condition.expression)) string.append(condition.expression).append(" && ");
		if (string.length() > 4) string.delete(string.length() - 4, string.length());
		if (condition.not) string.insert(0, "!(").append(")");
		return string.toString();
	}

	String getUAVarName(final String ua) {
		return "is" + ua.replaceFirst("!", NEGATE_STR).replaceAll("\\W", "_");
	}
}
