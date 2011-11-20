package com.df.gwt.style.annotation;

import java.util.Arrays;

import com.df.gwt.style.annotation.client.Style.Condition;
import com.df.gwt.style.annotation.client.Style.Dir;
import com.df.gwt.style.annotation.client.UserAgent;

public class ConditionData {
	Class<? extends UserAgent>[] userAgents;
	String[] selectors;
	String[] locale;
	Dir dir = Dir.ALL;
	boolean not = false;
	String expression;

	public ConditionData(final Condition condition) {
		if (condition != null) {
			userAgents = condition.userAgent();
			selectors = condition.selector();
			locale = condition.locale();
			dir = condition.dir();
			not = condition.not();
			expression = condition.expression();
		}
	}

	public String getSuffix() {
		final StringBuilder suffix = new StringBuilder();
		if (userAgents != null) for (final Class<? extends UserAgent> ua : userAgents) {
			suffix.append("_").append(Util.toVariableName(ua.getName()));
		}
		if (locale != null) for (final String l : locale) { suffix.append("_").append(l); }
		if (dir != Dir.ALL) suffix.append("_" + dir.name());
		if (not) suffix.append("_not");
		if (!Util.isEmpty(expression)) suffix.append(Util.toVariableName(expression));
		if (suffix.length() > 0) suffix.insert(0, "_");
		return suffix.toString();
	}

	public boolean isEmpty() {
		return Util.isEmpty(getSuffix());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dir == null) ? 0 : dir.hashCode());
		result = prime * result + ((expression == null) ? 0 : expression.hashCode());
		result = prime * result + Arrays.hashCode(locale);
		result = prime * result + (not ? 1231 : 1237);
		result = prime * result + Arrays.hashCode(selectors);
		result = prime * result + Arrays.hashCode(userAgents);
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final ConditionData other = (ConditionData) obj;
		if (dir != other.dir) return false;
		if (expression == null) {
			if (other.expression != null) return false;
		} else if (!expression.equals(other.expression)) return false;
		if (!Arrays.equals(locale, other.locale)) return false;
		if (not != other.not) return false;
		if (!Arrays.equals(selectors, other.selectors)) return false;
		if (!Arrays.equals(userAgents, other.userAgents)) return false;
		return true;
	}

}