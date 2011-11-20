package com.df.gwt.style.annotation;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.df.gwt.style.annotation.client.Style.Dir;
import com.df.gwt.style.annotation.client.UserAgent;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JField;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JParameter;


public class JavaClassStyleData {

	public List<RuleData<JClassType>> initStyleData = new ArrayList<RuleData<JClassType>>();
	public List<RuleData<JField>> fieldStyleData = new ArrayList<RuleData<JField>>();
	public List<MethodData> methodStyleData = new ArrayList<MethodData>();
	public boolean isUserDefinedAnnotation = false;

	public static class MethodData {
		RuleData<JMethod> methodData;
		List<RuleData<JParameter>> paramsData;

		public MethodData(final RuleData<JMethod> methodData, final List<RuleData<JParameter>> paramsData) {
			super();
			this.methodData = methodData;
			this.paramsData = paramsData;
		}
	}

	public boolean isEmpty() {
		return initStyleData.isEmpty() && fieldStyleData.isEmpty() && methodStyleData.isEmpty();
	}

	public ArrayList<RuleData<?>> getAllStyles() {
		final ArrayList<RuleData<?>> all = new ArrayList<RuleData<?>>();
		all.addAll(initStyleData);
		all.addAll(fieldStyleData);
		for (final MethodData data : methodStyleData) {
			if (data.methodData != null) {
				all.add(data.methodData);
			}
			all.addAll(data.paramsData);
		}
		return all;
	}

	public List<Annotation> getAllUserDefinedAnnotations() {
		final ArrayList<Annotation> all = new ArrayList<Annotation>();
		for (final RuleData<?> ruleData : getAllStyles()) {
			all.addAll(ruleData.userDefinedStyles);
		}
		return all;
	}

	public Set<Class<? extends UserAgent>> getAllUserAgents() {
		final Set<Class<? extends UserAgent>> userAgents = new LinkedHashSet<Class<? extends UserAgent>>();
		for (final RuleData<?> ruleData : getAllStyles()) {
			for (final Entry<ConditionData, String> entry : ruleData.conditionalStyles.entrySet()) {
				if (entry.getKey().userAgents != null) {
					userAgents.addAll(Arrays.asList(entry.getKey().userAgents));
				}
			}
		}
		return userAgents;
	}

	public Set<String> getAllLocales() {
		final Set<String> locales = new LinkedHashSet<String>();
		for (final RuleData<?> ruleData : getAllStyles()) {
			for (final Entry<ConditionData, String> entry : ruleData.conditionalStyles.entrySet()) {
				if (entry.getKey().locale != null) {
					locales.addAll(Arrays.asList(entry.getKey().locale));
				}
			}
		}
		return locales;
	}

	public boolean hasDir() {
		for (final RuleData<?> ruleData : getAllStyles()) {
			for (final Entry<ConditionData, String> entry : ruleData.conditionalStyles.entrySet()) {
				if (!entry.getKey().dir.equals(Dir.ALL)) {
					return true;
				}
			}
		}
		return false;
	}
}