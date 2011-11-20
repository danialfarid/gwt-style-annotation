package com.df.gwt.style.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.df.gwt.style.annotation.client.Externals;
import com.df.gwt.style.annotation.client.Externals.External;
import com.df.gwt.style.annotation.client.GlobalCondition;
import com.df.gwt.style.annotation.client.Style.Condition;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JField;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JParameter;

public class RuleData<T> {
	T element;
	Set<String> externalRules = new HashSet<String>();
	Map<ConditionData, String> conditionalStyles = new HashMap<ConditionData, String>();
	Set<Annotation> userDefinedStyles = new HashSet<Annotation>();
	GlobalCondition globalCondition = null;

	String cssClassName;
	Map<String, ConditionData> cssClassNameToConditionMap;

	public RuleData(final T element, final List<Annotation> annotations) throws StyleRuleSemanticException {
		this.element = element;
		if (annotations != null) {
			final Iterator<Annotation> iterator = annotations.iterator();
			while (iterator.hasNext()) {
				final Annotation annotation = iterator.next();
				if (annotation.annotationType().isAssignableFrom(GlobalCondition.class)) {globalCondition = (GlobalCondition) annotation; iterator.remove();}
			}

			for (final Annotation annotation : annotations) {
				if (annotation.annotationType().isAssignableFrom(Externals.class)) {
					for (final External t : ((Externals) annotation).value()) {
						addExternalRule(t.typeName(), t.className(), t.value());
					}
				} else if (annotation.annotationType().isAssignableFrom(Externals.class)) {
					final External t = (External) annotation;
					addExternalRule(t.typeName(), t.className(), t.value());
				} else {
					addRule(annotation, globalCondition);
				}
			}
		}
	}

	public void addRule(final Annotation annotation, final GlobalCondition globalCondition) {
		String name = getFieldValue(annotation, "name");
		name = name == null ? (String)getMethodValue(annotation, "name") : name;
		final String valueField = getFieldValue(annotation, "value");
		final String valueMethod = (String)getMethodValue(annotation, "value");
		final Boolean important = (Boolean)getMethodValue(annotation, "important");
		Condition[] conditions = (Condition[]) getMethodValue(annotation, "condition");

		if (Util.isEmpty(conditions) && globalCondition != null) {
			conditions = globalCondition.condition();
		}

		final String value = Util.isEmpty(valueField) ? valueMethod : valueField;
		if (value == null) {
			userDefinedStyles.add(annotation);
			return;
		}

		ConditionData conditionData = new ConditionData((Condition)null);
		String string = conditionalStyles.get(conditionData);
		String propValue = "";
		if (!Util.isEmpty(valueMethod) || (!Util.isEmpty(valueField) && Util.isEmpty(conditions))) {
			propValue = getPropDefString(name, value, important);
		}
		conditionalStyles.put(conditionData, (string == null ? "" : string) + propValue);

		if (conditions != null) {
			for (final Condition condition : conditions) {
				conditionData = new ConditionData(condition);
				string = conditionalStyles.get(conditionData);
				conditionalStyles.put(conditionData, (string == null ? "" : string) +
						getPropDefString(name, Util.isEmpty(condition.value()) ? value : condition.value(), condition.important()));
			}
		}
	}

	public void addExternalRule(final String typeName, final String className, final String value) throws StyleRuleSemanticException {
		if (!Util.isEmpty(typeName) && !Util.isEmpty(className)) {
			throw new StyleRuleSemanticException("Only one of typeName or className can have value for external annotation.");
		}
		externalRules.add((Util.isEmpty(typeName) ? ((className.startsWith(".") ? "" : ".") + className) : typeName) +
				" {\r\n\t" + value + "\r\n}");
	}

	public String getCssClassName() {
		if (Util.isEmpty(cssClassName)) {
			if (element instanceof JClassType) {
				cssClassName = ((JClassType)element).getQualifiedSourceName();
			} else if (element instanceof JField) {
				final JField field = (JField) element;
				cssClassName = field.getEnclosingType().getQualifiedSourceName() + "." + field.getName();
			} else if (element instanceof JParameter) {
				final JParameter parameter = (JParameter) element;
				cssClassName = parameter.getEnclosingMethod().getEnclosingType().getQualifiedSourceName() + "." +
				parameter.getEnclosingMethod().getName() + "." + parameter.getName();
			} else if (element instanceof JMethod) {
				final JMethod method = (JMethod) element;
				cssClassName = method.getEnclosingType().getQualifiedSourceName() + "." + method.getName() + "(";
			}
			cssClassName = Util.toVariableName(cssClassName);
		}
		return cssClassName;
	}

	public Map<String, ConditionData> getCssClassNameToConditionMap() {
		if (cssClassNameToConditionMap == null) {
			cssClassNameToConditionMap = new HashMap<String, ConditionData>();
			for (final ConditionData conditionData : conditionalStyles.keySet()) {
				cssClassNameToConditionMap.put(getCssClassName() + conditionData.getSuffix(), conditionData);
			}
		}
		return cssClassNameToConditionMap;
	}

	public Set<String> getAllCssClassNames() {
		return getCssClassNameToConditionMap().keySet();
	}
	String getPropDefString(final String property, final String value, final boolean important) {
		return new StringBuilder().append("\t").append(property == null ? "" : property).append(Util.isEmpty(property) ? "" : ": ").
		append(value).append(value.trim().endsWith(";") ? "" :
			(important ? " !important;" : ";")).append("\r\n").toString();
	}

	public Set<Entry<ConditionData, String>> getConditionalStyles() {
		return conditionalStyles.entrySet();
	}

	public Set<String> getExternalRules() {
		return externalRules;
	}

	@SuppressWarnings("unchecked")
	<E> E getMethodValue(final Annotation annotation, final String methodName) {
		try {
			final Method method = annotation.getClass().getMethod(methodName);
			return (E) method.invoke(annotation);
		} catch (final SecurityException e) {
		} catch (final IllegalArgumentException e) {
		} catch (final IllegalAccessException e) {
		} catch (final InvocationTargetException e) {
		} catch (final NoSuchMethodException e) {}
		return null;
	}

	String getFieldValue(final Annotation annotation, final String fieldName) {
		try {
			return (String) annotation.getClass().getField(fieldName).get(annotation);
		} catch (final SecurityException e) {
		} catch (final IllegalArgumentException e) {
		} catch (final IllegalAccessException e) {
		} catch (final NoSuchFieldException e) {}
		return null;
	}

}