package com.df.gwt.style.annotation.client;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Identifies css style information exists for an annotation type.
 * You can just annotate your annotation type with other existing
 * styles like &#064;Height() &#064;DisplayInline (which themselves are annotated with &#064;StyleDef).
 * All these annotations (which the target annotation is annotated with) will be included in the
 * css rule whenever you use the target annotation.
 * For example we define Header annotation like this:
 * 
 * <pre>
 * &#064;StyleDef
 * &#064;BackgroundColor("#EEEEEE") &#064;FontSize("110%")
 * public &#064;interface Header{}
 * 
 * &#064;Header
 * Label label = GWT.create(Label.class)
 * </pre>
 * 
 * Both background color and font size will be applied to label.
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE})
public @interface StyleDef {}
