package com.df.gwt.style.annotation;

import java.io.PrintWriter;
import java.util.Map;

import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.typeinfo.JClassType;

public class WidgetSubclassGenerator {

	public Map<String, JavaClassStyleData> stylesMap;
	final GeneratorContext context;
	final TreeLogger logger;
	final String cssResourceClass;

	public String getSubclassTemplate() {
		return (
				"package @package;\r\n" +
				"\r\n" +
				"public class @class extends @extends {\r\n" +
				"	\r\n" +
				"	{\r\n" +
				"@initialization" +
				"	}\r\n" +
				"@methodOverride" +
				"}"
		);
	}

	public WidgetSubclassGenerator(final Map<String, JavaClassStyleData> stylesMap, final String cssResourceClass,
			final TreeLogger logger, final GeneratorContext context) {
		super();
		this.stylesMap = stylesMap;
		this.cssResourceClass = cssResourceClass;
		this.logger = logger;
		this.context = context;
	}

	public void writeSubClass(final JClassType requestedClass, final String genClassName) {
		final PrintWriter writer = context.tryCreate(logger, requestedClass.getPackage().getName(), genClassName);
		if (writer != null) {
			try {
				writer.write(generateSource(requestedClass, genClassName));
				context.commit(logger, writer);
			} finally {
				writer.close();
			}
		}
	}

	String generateSource(final JClassType requestedClass, final String genClassName) {
		final JavaClassStyleData styleData = stylesMap.get(requestedClass.getQualifiedSourceName());
		final AddStylesStatementsGenerator addStylesStatementsGenerator = new AddStylesStatementsGenerator(styleData, cssResourceClass);
		final String source = getSubclassTemplate().
		replace("@package", requestedClass.getPackage().getName()).
		replace("@class", genClassName).
		replace("@extends", requestedClass.getName()).
		replace("@initialization", addStylesStatementsGenerator.generateInitialization(null)).
		replace("@methodOverride", addStylesStatementsGenerator.generateMethodOverrides());

		return source;
	}
}