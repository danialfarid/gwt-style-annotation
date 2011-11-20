package com.df.gwt.style.annotation.client;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.df.gwt.style.annotation.client.Style.Condition;

/**
 * A global condition for this element.
 * All annotations present on the same element will have this condition applied to them unless they have their own conditions.
 */
@StyleDef @Retention(RetentionPolicy.RUNTIME)
public @interface GlobalCondition {
	Condition[] condition();
}
