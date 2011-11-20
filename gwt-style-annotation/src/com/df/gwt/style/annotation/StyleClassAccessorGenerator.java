package com.df.gwt.style.annotation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StyleClassAccessorGenerator {

	public String generate(final Map<String, JavaClassStyleData> stylesMap) {
		final StringBuilder accessors = new StringBuilder();
		final Collection<JavaClassStyleData> values = stylesMap.values();
		final Set<String> allClassNames = new HashSet<String>();
		for (final JavaClassStyleData styleData : values) {
			for (final RuleData<?> ruleData : styleData.getAllStyles()) {
				for (final String cssClassName : ruleData.getAllCssClassNames()) {
					if (!allClassNames.contains(cssClassName)) {
						accessors.append("		String ").append(cssClassName).append("();\r\n");
						allClassNames.add(cssClassName);
					}
				}
			}
		}
		return accessors.toString();
	}
}
