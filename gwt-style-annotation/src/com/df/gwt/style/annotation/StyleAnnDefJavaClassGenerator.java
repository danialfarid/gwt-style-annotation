package com.df.gwt.style.annotation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import com.df.gwt.style.annotation.client.StyleDef;
import com.df.gwt.style.annotation.client.UserAgent;

public class StyleAnnDefJavaClassGenerator {

	public static String EOL = "\r\n";
	public static String PACKAGE = StyleDef.class.getPackage().getName();
	public static String PACKAGE_DIR = "src" + File.separator + PACKAGE.replace(".", File.separator);

	public static void main(final String[] args) throws IOException {
		new StyleAnnDefJavaClassGenerator().generate();
		System.out.println("DONE !!!");
	}

	public void generate() throws IOException {
		final PrintWriter writer = new PrintWriter(PACKAGE_DIR + File.separator + "Style.java") ;
		try {
			writer.write(
					"package " + PACKAGE + ";" + EOL +
					"" + EOL +
					"import java.lang.annotation.Retention;" + EOL +
					"import java.lang.annotation.RetentionPolicy;" + EOL +
					"" + EOL +
					"/**" + EOL +
					" * CSS property annotations class holder." + EOL +
					" * It can also be used as a style property definition but you need to specify both name and value." + EOL +
					" * <p>This is reserved for the CSS properties that have no corresponding annotation defined in here." + EOL +
					" * For example:" + EOL +
					" * <pre>" + EOL +
					" * &#064;StyleProperty(\"border-bottom-left-radius:0px 0px !important; border-top-left-radius: 0px 0px !important;\")" + EOL +
					" * </pre>" + EOL +
					" * or" + EOL +
					" * <pre>" + EOL +
					" * &#064;StyleProperty(name=\"border-bottom-left-radius\" value=\"0px 0px\" important=true)" + EOL +
					" * </pre>" + EOL +
					" * <p> Note that you can define you own annotations for the browser specific properties or other extensions." + EOL +
					" * You just need to annotate your annotation with &#064;StyleDef so that the parser would know this annotation" + EOL +
					" * has style information in it." + EOL +
					" * " + EOL +
					" * @see StyleDef" + EOL +
					" *" + EOL +
					" */" + EOL +
					"" + EOL +
					"@StyleDef @Retention(RetentionPolicy.RUNTIME)" + EOL +
					"public @interface Style {" + EOL +
					"	String value() default \"\";" + EOL +
					"	String name() default \"\";" + EOL +
					"	boolean important() default false;" + EOL +
					"	Condition[] condition() default {};" + EOL +
					"	" + EOL +
					"	public static enum Dir {RTL, LTR, ALL}" + EOL +
					"	" + EOL +
					"	public @interface Condition {" + EOL +
					"		String value() default \"\";" + EOL +
					"		String[] selector() default {};" + EOL +
					"		Class<? extends " + UserAgent.class.getName() + ">[] userAgent() default {};" + EOL +
					"		boolean important() default false;" + EOL +
					"		String[] locale() default {};" + EOL +
					"		Dir dir() default Dir.ALL;" + EOL +
					"		boolean not() default false;" + EOL +
					"		String expression() default \"\";" + EOL +
					"	}" + EOL +
					"	" + EOL
			);
			final BufferedReader fileReader = new BufferedReader(new FileReader(
					new File(PACKAGE_DIR + "/style-list")));
			try {
				String line;
				while ((line = fileReader.readLine()) != null) {
					if (line.length() > 0) {
						final String[] names = line.split("[ ']+");;
						line = fileReader.readLine();
						final String[] values = line.split(
						"(([ \\|\\{\\}\\(\\)\\[\\]\\?\\*\\+\\/,0-9])|('[\\w-]+')|(<[\\w-]+>))+");
						final boolean hasRegularValue = Pattern.compile("('[\\w-]+')|<").matcher(line).find();

						for (final String name : names) {
							if (name != null && name.length() > 0) {
								if (hasRegularValue) {
									writer.write(constructAnnotationClasses(name, null));
								}
								final Set<String> visitedValues = new HashSet<String>();
								for (String value : values) {
									if (!visitedValues.contains(value)) {
										value = value.trim();
										if (value != null && value.length() > 0) {
											writer.write(constructAnnotationClasses(name, value));
										}
										visitedValues.add(value);
									}
								}
							}
						}
					}
				}
				writer.write("}");
			} finally {
				fileReader.close();
			}
		} finally {
			writer.flush();
			writer.close();
		}
	}

	String constructAnnotationClasses(final String name, final String value) {
		final String className = Util.toCamelCase(name + (value == null ? "" : "-" + value));
		final String template =
			"" + EOL +
			"	@StyleDef @Retention(RetentionPolicy.RUNTIME) " + EOL +
			"	public @interface @CLASSNAME {" + EOL +
			"		String name = \"" + name + "\";" + EOL +
			"		String value" + (value == null ? "() default \"\";" : " = \"" + value + "\";") + EOL +
			"		boolean important() default false;" + EOL +
			"		Condition[] condition() default {};" + EOL +
			"	}";
		final List<String> classNames = new ArrayList<String>();
		classNames.add(className);
		if (className.equals("left")) classNames.add("begin");
		else if (className.contains("Left")) classNames.add(className.replace("Left", "Begin"));
		else if (className.equals("right")) classNames.add("end");
		else if (className.contains("Right")) classNames.add(className.replace("Right", "End"));

		return appendClasses(template, classNames);
	}

	String appendClasses(final String template, final List<String> classNames) {
		final StringBuilder  string = new StringBuilder();
		for (final String name : classNames) {
			string.append(template.replace("@CLASSNAME", name));
		}
		return string.toString();
	}
}