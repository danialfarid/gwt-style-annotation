package com.df.gwt.style.annotation;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;

public class StyleAnnCssResourceWriter {

	public static final String CSS_FILE_NAME = "GENERATED_ANN_STYLE_DO_NOT_EDIT.css";
	public static final String CSS_RESOURCE_CLASS_NAME = "GENERATED_AnnotationStyleCssResouceContainer_DO_NOT_EDIT";

	LinkedHashMap<String, JavaClassStyleData> stylesMap;
	TreeLogger logger;
	GeneratorContext context;
	LinkedHashSet<String> userDefinedStyles;

	public String write(final TreeLogger logger, final GeneratorContext context,
			final LinkedHashMap<String, JavaClassStyleData> stylesMap, final LinkedHashSet<String> userDefinedStyles,
			final String fullClassName) throws UnableToCompleteException {
		this.logger = logger;
		this.context = context;
		this.stylesMap = stylesMap;
		this.userDefinedStyles = userDefinedStyles;

		final URL resource = findClassResource(fullClassName);
		final String packageName = context.getTypeOracle().findType(fullClassName).getPackage().getName();

		final String cssFolder = new File(resource.getPath()).getParent();

		generateCSSFile(cssFolder);

		generateCssResourceClass(packageName);

		return packageName + "." + CSS_RESOURCE_CLASS_NAME;
	}

	void generateCssResourceClass(final String packageName) {
		final PrintWriter writer = context.tryCreate(logger, packageName, CSS_RESOURCE_CLASS_NAME);
		if (writer != null) {
			try {
				writer.write(cssResourceClassSource(packageName));
				context.commit(logger, writer);
			} finally {
				writer.close();
			}
		}
	}

	void generateCSSFile(String filePath) throws UnableToCompleteException {
		filePath = filePath + File.separator + CSS_FILE_NAME;
		try {
			PrintWriter resourceWriter;
			// ResourceGeneratorUtil.addNamedFile(CSS_FILE_NAME, file);
			resourceWriter = new PrintWriter(filePath);
			try {
				resourceWriter.write(cssFileContents());
				resourceWriter.flush();
			} finally {
				resourceWriter.close();
			}
		} catch (final IOException e) {
			logger.log(TreeLogger.ERROR, "Can not create resource '" + filePath + "'", e);
			throw new UnableToCompleteException();
		}
	}

	String cssResourceClassSource(final String packageName) {
		return (
				"package "+packageName+";\r\n" +
				"\r\n" +
				"import com.google.gwt.resources.client.CssResource;\r\n" +
				"import com.google.gwt.resources.client.ClientBundle;\r\n" +
				"import com.google.gwt.core.client.GWT;\r\n" +
				"\r\n" +
				"public class "+CSS_RESOURCE_CLASS_NAME+" {\r\n" +
				new ConditionalConstantsGenerator().generate(stylesMap.values()) +
				"	public interface AnnotationStyleGeneratedResourceBundle extends ClientBundle {\r\n" +
				"		@Source(\"" + CSS_FILE_NAME + "\")\r\n" +
				"		public AnnotationStyleGeneratedCssResource css();\r\n" +
				"	}\r\n" +
				"	public static class AnnotationStyleGeneratedCssResourceHolder  {\r\n" +
				"		public static AnnotationStyleGeneratedCssResource css;\r\n" +
				"		static {\r\n" +
				"			AnnotationStyleGeneratedResourceBundle bundle = GWT.create(AnnotationStyleGeneratedResourceBundle.class);\r\n" +
				"			css = bundle.css();\r\n" +
				"			css.ensureInjected();\r\n" +
				"		}\r\n" +
				"	}\r\n" +
				"	public interface AnnotationStyleGeneratedCssResource extends CssResource {\r\n" +
				new StyleClassAccessorGenerator().generate(stylesMap) +
				"	}\r\n" +
				"	public static AnnotationStyleGeneratedCssResource css_UNIQUE_METHOD_NAME() {\r\n" +
				"		return AnnotationStyleGeneratedCssResourceHolder.css;\r\n" +
				"	}\r\n" +
				generateUserDefinedStylesMethods(stylesMap, userDefinedStyles, packageName) +
				"}"
		);
	}

	public String generateUserDefinedStylesMethods(final Map<String, JavaClassStyleData> stylesMap, final LinkedHashSet<String> userDefinedStyles, final String packageName) {
		final StringBuilder str = new StringBuilder();
		for (final String string : userDefinedStyles) {
			str.append("	public static void apply_").
			append(Util.toVariableName(string)).append("(com.google.gwt.user.client.ui.Widget widget) {\r\n").
			append(new AddStylesStatementsGenerator(stylesMap.get(string),
					packageName + "." + CSS_RESOURCE_CLASS_NAME).generateInitialization("widget")).
					append("	}\r\n");
		}
		return str.toString();
	}

	String cssFileContents() {
		final StringBuilder content = new StringBuilder();
		content.append("/* DO NOT EDIT. AUTO GENERATED */\r\n");
		final Collection<JavaClassStyleData> styles = stylesMap.values();

		final Set<String> externalRules = new HashSet<String>();
		for (final JavaClassStyleData styleData : styles) {
			for (final RuleData<?> ruleData : styleData.getAllStyles()) {
				for (final Entry<ConditionData, String> condStyle : ruleData.getConditionalStyles()) {
					final String propValue = condStyle.getValue();
					final ConditionData conditionData = condStyle.getKey();
					if (Util.isEmpty(conditionData.selectors)) {
						content.append(".").append(ruleData.getCssClassName()).append(conditionData.getSuffix()).
						append(" {\r\n").append(propValue).append("}\r\n\r\n");
					} else {
						for (final String selector : conditionData.selectors) {
							final char ch = selector.length() > 0 ? selector.charAt(0) : ' ';
							content.append(".").append(ruleData.getCssClassName()).append(conditionData.getSuffix()).
							append((ch == ':' || ch == '[' || ch == '.' || ch == '#') ? "" : " ").
							append(selector).
							append(" {\r\n").append(propValue).append("}\r\n\r\n");
						}
					}
				}
				externalRules.addAll(ruleData.getExternalRules());
			}
		}

		for (final String rule : externalRules) {
			if (rule.startsWith(".")) {
				content.append("@external " + rule.substring(0, rule.indexOf(' ')) + ";\r\n");
			}
			content.append(rule + "\r\n\r\n");
		}
		return content.toString();
	}

	public URL findClassResource(final String sourceTypeName) {
		final String toTry = sourceTypeName.replace('.', '/') + ".class";
		final URL foundResource = Thread.currentThread().getContextClassLoader().getResource(toTry);
		if (foundResource != null) {
			return foundResource;
		}
		final int i = sourceTypeName.lastIndexOf('.');
		if (i != -1) {
			return findClassResource(sourceTypeName.substring(0, i));
		} else {
			return null;
		}
	}

	//	String findSourceFilePath(final String fullClassName) throws UnableToCompleteException {
	//		final URL location = com.google.gwt.dev.util.Util.findSourceInClassPath(
	//				Thread.currentThread().getContextClassLoader(), fullClassName);
	//		if (location == null) {
	//			logger.log(TreeLogger.ERROR, "Could not find class source file for '" + fullClassName + "'.\n" +
	//			".css file needs to be created beside this class, but this class can not be found in the class path");
	//			throw new UnableToCompleteException();
	//		}
	//		return new File(location.getPath()).getParent();
	//	}
}
