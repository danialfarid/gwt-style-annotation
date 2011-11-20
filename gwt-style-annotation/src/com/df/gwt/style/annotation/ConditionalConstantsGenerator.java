package com.df.gwt.style.annotation;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import com.df.gwt.style.annotation.client.UserAgent;

public class ConditionalConstantsGenerator {

	public String generate(final Collection<JavaClassStyleData> collection) {
		final Set<Class<? extends UserAgent>> userAgents = new LinkedHashSet<Class<? extends UserAgent>>();
		final Set<String> localeSet = new LinkedHashSet<String>();
		boolean hasDir = false;
		for (final JavaClassStyleData styleData : collection) {
			for (final Class<? extends UserAgent> ua : styleData.getAllUserAgents()) {
				userAgents.add(ua);
			}
			for (final String locale : styleData.getAllLocales()) {
				localeSet.add(locale);
			}
			if (styleData.hasDir()) {
				hasDir = true;
			}
		}
		final StringBuilder string = new StringBuilder();
		for (final Class<? extends UserAgent> ua : userAgents) {
			string.append("\tpublic static boolean " + Util.toVariableName(ua.getCanonicalName()) +
					" = new " + ua.getCanonicalName() + "().accept(com.google.gwt.user.client.Window.Navigator.getUserAgent());\r\n");
		}
		for (final String locale : localeSet) {
			string.append("\tpublic static boolean " + locale +
					" = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().getLocaleName().equals(\"" + locale + "\");\r\n");
		}
		if (hasDir) {
			string.append("\tpublic static boolean RTL = com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL();\r\n");
		}
		return string.toString();
	}
}
