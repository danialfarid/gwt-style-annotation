package com.df.gwt.style.annotation;

import java.util.List;
import java.util.regex.Pattern;

import com.google.gwt.core.ext.BadPropertyValueException;
import com.google.gwt.core.ext.ConfigurationProperty;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;

public class ConfigReader {

	public Pattern getIncludePattern(final GeneratorContext context, final TreeLogger logger) throws UnableToCompleteException {
		try {
			final ConfigurationProperty include = context.getPropertyOracle().getConfigurationProperty("StyleAnnotation.includePrefix");
			return constructPattern(include.getValues());
		} catch (final BadPropertyValueException e) {
			logger.log(TreeLogger.ERROR, "Unknown configuration property: 'StyleAnnotation.includePrefix'", e);
			throw new UnableToCompleteException();
		}
	}

	public Pattern getExcludePattern(final GeneratorContext context, final TreeLogger logger) throws UnableToCompleteException {
		try {
			final ConfigurationProperty exclude = context.getPropertyOracle().getConfigurationProperty("StyleAnnotation.excludePrefix");
			return constructPattern(exclude.getValues());
		} catch (final BadPropertyValueException e) {
			logger.log(TreeLogger.ERROR, "Unknown configuration property: 'StyleAnnotation.excludePrefix'", e);
			throw new UnableToCompleteException();
		}
	}

	Pattern constructPattern(final List<String> list) {
		final StringBuilder regex = new StringBuilder();
		for (final String str : list) {
			regex.append("(").append(str.replace(".", "\\.").replace("*", ".*")).append(")|");
		}
		if (regex.length() > 0) regex.delete(regex.length() - 1, regex.length());
		return Pattern.compile(regex.toString());
	}
}
