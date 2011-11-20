package com.df.gwt.style.annotation;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.df.gwt.style.annotation.JavaClassStyleData.MethodData;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.TreeLogger.Type;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JField;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JParameter;
import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.google.gwt.dev.javac.typemodel.AnnotationHelper;

public class StyleAnnParser {

	AnnotationHelper annotationHelper = new AnnotationHelper();
	final TreeLogger logger;

	public StyleAnnParser(final TreeLogger logger) {
		this.logger = logger;
	}

	public JavaClassStyleData parse(final List<JClassType> classes) throws UnableToCompleteException {

		final JavaClassStyleData styleData = new JavaClassStyleData();
		try {
			styleData.isUserDefinedAnnotation = (classes.get(0).isAnnotation() != null);
			for (final JClassType clazz : classes) {
				final List<Annotation> styleAnnotations = annotationHelper.getStyleAnnotations(clazz);
				if (!styleAnnotations.isEmpty()) {
					styleData.initStyleData.add(new RuleData<JClassType>(clazz, styleAnnotations));
				}
			}

			if (styleData.isUserDefinedAnnotation) {
				return styleData;
			}

			final List<JField> fields = new ArrayList<JField>();
			for (final JClassType clazz : classes) {
				fields.addAll(Arrays.asList(clazz.getFields()));
			}

			for (final JField field : fields) {
				final List<Annotation> fieldAnnotations = annotationHelper.getStyleAnnotations(field);
				if (!fieldAnnotations.isEmpty()) {
					if (field.isPrivate() || field.isStatic()) {
						logger.log(TreeLogger.ERROR,
								"CSS Style Annotation is not allowed on 'private' or 'static' field: " + field.getEnclosingType().getName() + " " + field.getName());
						throw new UnableToCompleteException();
					} else {
						styleData.fieldStyleData.add(new RuleData<JField>(field, fieldAnnotations));
					}
				}
			}

			final List<JMethod> methods = new ArrayList<JMethod>();
			final List<JClassType> seenClasses = new ArrayList<JClassType>();
			for (final JClassType clazz : classes) {
				methods.addAll(getNotOverriddenMethod(seenClasses, Arrays.asList(clazz.getMethods())));
				seenClasses.add(clazz);
			}

			for (final JMethod method : methods) {
				final List<Annotation> methodAnnotations = annotationHelper.getStyleAnnotations(method);
				if (!methodAnnotations.isEmpty() || annotationHelper.hasAnnotatedParams(method)) {
					if (method.isPrivate() || method.isFinal() || method.isStatic()) {
						logger.log(TreeLogger.ERROR,
								"CSS Style Annotation is not allowed on 'private', 'final' or 'static' method: " + method.getEnclosingType().getName() + " " + method.getName());
						throw new UnableToCompleteException();
					} else {
						final JParameter[] parameters = method.getParameters();
						final List<RuleData<JParameter>> methodParamsStyleData = new ArrayList<RuleData<JParameter>>();
						for (final JParameter parameter : parameters) {
							final List<Annotation> paramAnnotations = annotationHelper.getStyleAnnotations(parameter);
							if (!paramAnnotations.isEmpty()) {
								methodParamsStyleData.add(new RuleData<JParameter>(parameter, paramAnnotations));
							}
						}
						if (!methodParamsStyleData.isEmpty() || !methodAnnotations.isEmpty()) {
							styleData.methodStyleData.add(new MethodData(
									new RuleData<JMethod>(method, methodAnnotations), methodParamsStyleData));
						}
					}
				}
			}
		} catch (final StyleRuleSemanticException e) {
			logger.log(Type.ERROR, "Style Annotation need to be corrected for class '" + classes.get(0).getQualifiedSourceName() + "' or its super classes.", e);
			throw new UnableToCompleteException();
		}

		final JClassType clazz = classes.get(0);
		if (!styleData.isUserDefinedAnnotation && styleData.initStyleData.size() > 0 &&
				(clazz.isFinal() || (clazz.getConstructors().length > 0 && clazz.findConstructor(new JType[0]) == null)) ||
				(clazz.isMemberType() && !clazz.isStatic())) {
			logger.log(TreeLogger.ERROR, "Fix annotation style for class '" + clazz + "'",
					new StyleRuleSemanticException("CSS Style Annotation is not allowed on " +
					"'final' class, class with no 'default (zero argument) constructors' or 'non-static inner class'. "));
			throw new UnableToCompleteException();
		}
		return styleData;
	}

	List<JMethod> getNotOverriddenMethod(final List<JClassType> classes, final List<JMethod> additionMethods) {
		final List<JMethod> result = new ArrayList<JMethod>();
		for (final JMethod method : additionMethods) {
			final JParameter[] parameters = method.getParameters();
			final JType[] paramTypes = new JType[parameters.length];
			for (int j = 0; j < paramTypes.length; j++) {
				paramTypes[j] = parameters[j].getType();
			}
			boolean hasOverride = false;
			for (final JClassType clazz : classes) {
				JMethod overridingMethod = null;
				try {
					overridingMethod = clazz.getMethod(method.getName(), paramTypes);
				} catch (final NotFoundException e) {}
				if (overridingMethod != null) {
					hasOverride = true;
					break;
				}
			}
			if (!hasOverride) {
				result.add(method);
			}
		}
		return result;
	}
}