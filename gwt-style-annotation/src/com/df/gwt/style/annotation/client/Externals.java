package com.df.gwt.style.annotation.client;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * A list of annotated external rule or general HTML type rules.
 * example :
 * <pre>
 * &#064;Externals({
 * 	&#064;External(className="gwt-Button", value="\\-webkit-border-radius:3px"),
 * 	&#064;External(typeName="body", value="margin:2px")
 * })
 * </pre>
 */
@StyleDef @Retention(RetentionPolicy.RUNTIME)
public @interface Externals {
	External[] value();

	/**
	 * An &#064;external rule in your css file.
	 * <b>className</b> is a class selector like <code>gwt-Button</code> and <b>typeName</b> is an html type like <code>body</code>.
	 * Only one of these two methods must be set. If none of them is set then the </b>value</b> will be printed directly
	 * into css file.
	 * This can be used to write special selectors in .css file which can not be achieved by provided annotations.
	 *
	 */
	@StyleDef @Retention(RetentionPolicy.RUNTIME)
	public @interface External {
		String value();
		String className() default "";
		String typeName() default "";
	}
}
