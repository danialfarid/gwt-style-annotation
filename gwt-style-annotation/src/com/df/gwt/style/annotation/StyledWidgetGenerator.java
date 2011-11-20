package com.df.gwt.style.annotation;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.TypeOracle;

public class StyledWidgetGenerator extends Generator {

	public static final String IMPLE_CLASS_SUFFIX = "_StyleAnnotationImpl";

	Pattern includePattern;
	Pattern excludePattern;

	public String cssResourceInstanceContainerClass;

	public LinkedHashMap<String, JavaClassStyleData> stylesMap;
	public LinkedHashSet<String> userDefinedStyles = new LinkedHashSet<String>();

	public Map<String, String> generatedClasses = new HashMap<String, String>();

	public ConfigReader configReader = new ConfigReader();
	WidgetSubclassGenerator subclassGenerator;

	@Override
	public String generate(final TreeLogger logger, final GeneratorContext context, final String fullClassName) throws UnableToCompleteException {
		if (stylesMap == null) {
			stylesMap = new LinkedHashMap<String, JavaClassStyleData>();
			processAllClassesForAnnotationStyles(logger, context);
			cssResourceInstanceContainerClass = new StyleAnnCssResourceWriter().write(
					logger, context, stylesMap, userDefinedStyles, fullClassName);
		}

		if (stylesMap.containsKey(fullClassName)) {
			if (generatedClasses.containsKey(fullClassName)) {
				return generatedClasses.get(fullClassName);
			} else {
				final JClassType requestedClass = context.getTypeOracle().findType(fullClassName);
				final String genClassName = getGenClassName(requestedClass);
				final String resultClass = requestedClass.getPackage().getName() + "." + genClassName;

				if (subclassGenerator == null) {
					subclassGenerator = new WidgetSubclassGenerator(stylesMap, cssResourceInstanceContainerClass, logger, context);
				}

				subclassGenerator.writeSubClass(requestedClass, genClassName);
				generatedClasses.put(fullClassName, resultClass);
				return resultClass;
			}
		} else {
			return fullClassName;
		}
	}

	String getGenClassName(final JClassType requestedClass) {
		final String packageName = requestedClass.getPackage().getName();
		final String className = requestedClass.getName();
		String genClassName = Util.toVariableName(className) + IMPLE_CLASS_SUFFIX;
		int i = 0;
		while (requestedClass.getOracle().findType(packageName, genClassName) != null) {
			genClassName += i++;
		}
		return genClassName;
	}

	List<String> getExternalClassNames(final String rule) {
		final List<String> externalClassNames = new ArrayList<String>();
		final Matcher matcher = Pattern.compile("(\\.[\\w-]+) ([\\.^'^\"]+){").matcher(rule);
		while (matcher.find()) {
			externalClassNames.add(matcher.group(0));
		}
		return externalClassNames;
	}

	synchronized void processAllClassesForAnnotationStyles(final TreeLogger logger,
			final GeneratorContext context) throws UnableToCompleteException {
		if (includePattern == null) {
			includePattern = configReader.getIncludePattern(context, logger);
			excludePattern = configReader.getExcludePattern(context, logger);
		}
		JClassType[] subtypes;
		final JClassType widgetType = context.getTypeOracle().findType("com.google.gwt.user.client.ui.Widget");
		subtypes = widgetType.getSubtypes();

		final StyleAnnParser parser = new StyleAnnParser(logger);
		for (final JClassType clazz : subtypes) {

			JClassType superclass = clazz;
			final List<JClassType> classes = new ArrayList<JClassType>();
			do {
				if ((Util.isEmpty(includePattern.pattern()) || includePattern.matcher(superclass.getQualifiedSourceName()).matches()) &&
						(Util.isEmpty(excludePattern.pattern()) || !excludePattern.matcher(superclass.getQualifiedSourceName()).matches())) {
					classes.add(superclass);
				} else {
					break;
				}
				superclass = superclass.getSuperclass();
			} while (superclass != null);

			if (!classes.isEmpty()) {
				final JavaClassStyleData styleData = parser.parse(classes);
				if (!styleData.isEmpty()) {
					stylesMap.put(clazz.getQualifiedSourceName(), styleData);
				}
			}
		}

		final JavaClassStyleData[] values = stylesMap.values().toArray(new JavaClassStyleData[0]);
		for (final JavaClassStyleData styleData : values) {
			processUserDefinedAnnotations(parser, styleData.getAllUserDefinedAnnotations(), context.getTypeOracle());
		}
	}

	void processUserDefinedAnnotations(final StyleAnnParser parser, final List<Annotation> annotations,
			final TypeOracle typeOracle) throws UnableToCompleteException {
		for (final Annotation annotation : annotations) {
			if (!userDefinedStyles.contains(annotation.annotationType().getCanonicalName())) {
				final JavaClassStyleData classStyleData = parser.parse(Arrays.asList(
						typeOracle.findType(annotation.annotationType().getCanonicalName())));
				stylesMap.put(annotation.annotationType().getCanonicalName(), classStyleData);
				userDefinedStyles.add(annotation.annotationType().getCanonicalName());
				processUserDefinedAnnotations(parser, classStyleData.getAllUserDefinedAnnotations(), typeOracle);
			}
		}
	}
}
