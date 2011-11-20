package com.df.gwt.style.annotation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

	public static final Pattern CAMELCASE_PATTERN = Pattern.compile("([A-Z])");

	public static String replaceCamelCase(final String str) {
		return CAMELCASE_PATTERN.matcher(str).replaceAll("-$0").toLowerCase();
	}

	public static boolean isEmpty(final String str) {
		return str == null || str.length() == 0;
	}

	public static String toCamelCase(final String string) {
		final Matcher matcher = Pattern.compile("([\\-]\\w)").matcher(string);
		final StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, matcher.group(0).substring(1).toUpperCase());
		}
		matcher.appendTail(sb);
		sb.replace(0, 1, sb.substring(0, 1).toUpperCase());
		return sb.toString();
	}

	public static String toVariableName(final String string) {
		return string.replaceAll("\\.", "_").replaceAll("\\W", "_");
	}

	public static <T> boolean isEmpty(final T[] array) {
		return array == null || array.length == 0;
	}

	//	public static <T> T[] merge(final T[] array1, final T[] array2) {
	//		final int length = (array1 != null ? array1.length : 0) + (array2 != null ? array2.length : 0);
	//		@SuppressWarnings("unchecked")
	//		final T[] result = (T[]) new Object[length];
	//		if (array1 != null) {
	//			for (int i = 0; i < array1.length; i++) {
	//				result[i] = array1[i];
	//			}
	//		}
	//		final int index = array1 == null ? 0 : array1.length;
	//		if (array2 != null) {
	//			for (int i = 0; i < array2.length; i++) {
	//				result[index + i] = array1[i];
	//			}
	//		}
	//		return result;
	//	}

}
