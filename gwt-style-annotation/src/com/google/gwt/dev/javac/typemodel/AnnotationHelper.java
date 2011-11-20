package com.google.gwt.dev.javac.typemodel;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.df.gwt.style.annotation.client.StyleDef;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.core.ext.typeinfo.NotFoundException;

/**
 * Retrieves all annotations from a class or field annotated with StyleDef.
 * Since getAnnotations() method is friendly in JClassType the package is the same as JClassType
 *
 */
public class AnnotationHelper {

	public List<Annotation> getStyleAnnotations(final com.google.gwt.core.ext.typeinfo.JClassType clazz) {
		return getStyleAnnotations(((com.google.gwt.dev.javac.typemodel.JClassType)clazz).getAnnotations());
	}

	public List<Annotation> getStyleAnnotations(final com.google.gwt.core.ext.typeinfo.JField field) {
		return getStyleAnnotations(((JField)field).getAnnotations());
	}

	public List<Annotation> getStyleAnnotations(com.google.gwt.core.ext.typeinfo.JMethod method) {
		final List<Annotation> annotations = new ArrayList<Annotation>(Arrays.asList(((JMethod)method).getAnnotations()));
		final JParameter[] parameters = ((JMethod)method).getParameters();
		final JType[] paramTypes = new JType[parameters.length];
		for (int j = 0; j < paramTypes.length; j++) {
			paramTypes[j] = parameters[j].getType();
		}
		JClassType superclass = method.getEnclosingType();
		do {
			superclass = superclass.getSuperclass();
			if (superclass != null) {
				try {
					method = superclass.getMethod(method.getName(), paramTypes);
					annotations.addAll(Arrays.asList(((JMethod)method).getAnnotations()));
				} catch (final NotFoundException e) {}
			}
		} while (superclass != null);
		return getStyleAnnotations(annotations.toArray(new Annotation[0]));
	}

	public List<Annotation> getStyleAnnotations(final com.google.gwt.core.ext.typeinfo.JParameter parameter) {
		final List<Annotation> annotations = new ArrayList<Annotation>(Arrays.asList(((JParameter)parameter).getAnnotations()));
		final JParameter[] parameters = ((JParameter)parameter).getEnclosingMethod().getParameters();
		final JType[] paramTypes = new JType[parameters.length];
		int index = -1;
		for (int j = 0; j < paramTypes.length; j++) {
			paramTypes[j] = parameters[j].getType();
			if (parameters[j].getName().equals(parameter.getName())) {
				index = j;
			}
		}
		com.google.gwt.core.ext.typeinfo.JAbstractMethod method = ((JParameter)parameter).getEnclosingMethod();
		com.google.gwt.core.ext.typeinfo.JClassType superclass = method.getEnclosingType();
		do {
			superclass = superclass.getSuperclass();
			if (superclass != null) {
				try {
					method = superclass.getMethod(method.getName(), paramTypes);
					annotations.addAll(Arrays.asList(((JParameter)method.getParameters()[index]).getAnnotations()));
				} catch (final NotFoundException e) {}
			}
		} while (superclass != null);
		return getStyleAnnotations(annotations.toArray(new Annotation[0]));
	}

	public List<Annotation> getStyleAnnotations(final Annotation[] annotations) {
		final List<Annotation> list = new ArrayList<Annotation>();
		for (final Annotation annotation : annotations) {
			if (annotation.annotationType().isAnnotationPresent(StyleDef.class)) {
				list.add(annotation);
			}
		}
		return list;
	}

	public boolean hasAnnotatedParams(final com.google.gwt.core.ext.typeinfo.JMethod method) {
		final JParameter[] parameters = ((JMethod)method).getParameters();
		for (final JParameter jParameter : parameters) {
			if (!getStyleAnnotations(jParameter).isEmpty()) {
				return true;
			}
		}
		return false;
	}
}
