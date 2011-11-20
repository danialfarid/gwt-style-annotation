package com.df.gwt.style.annotation.client;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * CSS property annotations class holder.
 * It can also be used as a style property definition but you need to specify both name and value.
 * <p>This is reserved for the CSS properties that have no corresponding annotation defined in here.
 * For example:
 * <pre>
 * &#064;StyleProperty("border-bottom-left-radius:0px 0px !important; border-top-left-radius: 0px 0px !important;")
 * </pre>
 * or
 * <pre>
 * &#064;StyleProperty(name="border-bottom-left-radius" value="0px 0px" important=true)
 * </pre>
 * <p> Note that you can define you own annotations for the browser specific properties or other extensions.
 * You just need to annotate your annotation with &#064;StyleDef so that the parser would know this annotation
 * has style information in it.
 * 
 * @see StyleDef
 *
 */

@StyleDef @Retention(RetentionPolicy.RUNTIME)
public @interface Style {
	String value() default "";
	String name() default "";
	boolean important() default false;
	Condition[] condition() default {};
	
	public static enum Dir {RTL, LTR, ALL}
	
	public @interface Condition {
		String value() default "";
		String[] selector() default {};
		Class<? extends com.df.gwt.style.annotation.client.UserAgent>[] userAgent() default {};
		boolean important() default false;
		String[] locale() default {};
		Dir dir() default Dir.ALL;
		boolean not() default false;
		String expression() default "";
	}
	

	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Azimuth {
		String name = "azimuth";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface AzimuthLeftSide {
		String name = "azimuth";
		String value = "left-side";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface AzimuthBeginSide {
		String name = "azimuth";
		String value = "left-side";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface AzimuthFarLeft {
		String name = "azimuth";
		String value = "far-left";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface AzimuthFarBegin {
		String name = "azimuth";
		String value = "far-left";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface AzimuthLeft {
		String name = "azimuth";
		String value = "left";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface AzimuthBegin {
		String name = "azimuth";
		String value = "left";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface AzimuthCenterLeft {
		String name = "azimuth";
		String value = "center-left";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface AzimuthCenterBegin {
		String name = "azimuth";
		String value = "center-left";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface AzimuthCenter {
		String name = "azimuth";
		String value = "center";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface AzimuthCenterRight {
		String name = "azimuth";
		String value = "center-right";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface AzimuthCenterEnd {
		String name = "azimuth";
		String value = "center-right";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface AzimuthRight {
		String name = "azimuth";
		String value = "right";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface AzimuthEnd {
		String name = "azimuth";
		String value = "right";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface AzimuthFarRight {
		String name = "azimuth";
		String value = "far-right";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface AzimuthFarEnd {
		String name = "azimuth";
		String value = "far-right";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface AzimuthRightSide {
		String name = "azimuth";
		String value = "right-side";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface AzimuthEndSide {
		String name = "azimuth";
		String value = "right-side";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface AzimuthBehind {
		String name = "azimuth";
		String value = "behind";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface AzimuthLeftwards {
		String name = "azimuth";
		String value = "leftwards";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface AzimuthBeginwards {
		String name = "azimuth";
		String value = "leftwards";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface AzimuthRightwards {
		String name = "azimuth";
		String value = "rightwards";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface AzimuthEndwards {
		String name = "azimuth";
		String value = "rightwards";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface AzimuthInherit {
		String name = "azimuth";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundAttachmentScroll {
		String name = "background-attachment";
		String value = "scroll";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundAttachmentFixed {
		String name = "background-attachment";
		String value = "fixed";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundAttachmentInherit {
		String name = "background-attachment";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundColor {
		String name = "background-color";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundColorTransparent {
		String name = "background-color";
		String value = "transparent";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundColorInherit {
		String name = "background-color";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundImage {
		String name = "background-image";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundImageNone {
		String name = "background-image";
		String value = "none";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundImageInherit {
		String name = "background-image";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundPosition {
		String name = "background-position";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundPositionLeft {
		String name = "background-position";
		String value = "left";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundPositionBegin {
		String name = "background-position";
		String value = "left";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundPositionCenter {
		String name = "background-position";
		String value = "center";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundPositionRight {
		String name = "background-position";
		String value = "right";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundPositionEnd {
		String name = "background-position";
		String value = "right";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundPositionTop {
		String name = "background-position";
		String value = "top";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundPositionBottom {
		String name = "background-position";
		String value = "bottom";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundPositionInherit {
		String name = "background-position";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundRepeatRepeat {
		String name = "background-repeat";
		String value = "repeat";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundRepeatRepeatX {
		String name = "background-repeat";
		String value = "repeat-x";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundRepeatRepeatY {
		String name = "background-repeat";
		String value = "repeat-y";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundRepeatNoRepeat {
		String name = "background-repeat";
		String value = "no-repeat";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundRepeatInherit {
		String name = "background-repeat";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Background {
		String name = "background";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BackgroundInherit {
		String name = "background";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderCollapseCollapse {
		String name = "border-collapse";
		String value = "collapse";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderCollapseSeparate {
		String name = "border-collapse";
		String value = "separate";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderCollapseInherit {
		String name = "border-collapse";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderColor {
		String name = "border-color";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderColorTransparent {
		String name = "border-color";
		String value = "transparent";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderColorInherit {
		String name = "border-color";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderSpacing {
		String name = "border-spacing";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderSpacingInherit {
		String name = "border-spacing";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderStyle {
		String name = "border-style";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderStyleInherit {
		String name = "border-style";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderTop {
		String name = "border-top";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderTopInherit {
		String name = "border-top";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderRight {
		String name = "border-right";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderEnd {
		String name = "border-right";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderRightInherit {
		String name = "border-right";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderEndInherit {
		String name = "border-right";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderBottom {
		String name = "border-bottom";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderBottomInherit {
		String name = "border-bottom";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderLeft {
		String name = "border-left";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderBegin {
		String name = "border-left";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderLeftInherit {
		String name = "border-left";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderBeginInherit {
		String name = "border-left";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderTopColor {
		String name = "border-top-color";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderTopColorTransparent {
		String name = "border-top-color";
		String value = "transparent";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderTopColorInherit {
		String name = "border-top-color";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderRightColor {
		String name = "border-right-color";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderEndColor {
		String name = "border-right-color";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderRightColorTransparent {
		String name = "border-right-color";
		String value = "transparent";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderEndColorTransparent {
		String name = "border-right-color";
		String value = "transparent";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderRightColorInherit {
		String name = "border-right-color";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderEndColorInherit {
		String name = "border-right-color";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderBottomColor {
		String name = "border-bottom-color";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderBottomColorTransparent {
		String name = "border-bottom-color";
		String value = "transparent";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderBottomColorInherit {
		String name = "border-bottom-color";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderLeftColor {
		String name = "border-left-color";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderBeginColor {
		String name = "border-left-color";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderLeftColorTransparent {
		String name = "border-left-color";
		String value = "transparent";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderBeginColorTransparent {
		String name = "border-left-color";
		String value = "transparent";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderLeftColorInherit {
		String name = "border-left-color";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderBeginColorInherit {
		String name = "border-left-color";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderTopStyle {
		String name = "border-top-style";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderTopStyleInherit {
		String name = "border-top-style";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderRightStyle {
		String name = "border-right-style";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderEndStyle {
		String name = "border-right-style";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderRightStyleInherit {
		String name = "border-right-style";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderEndStyleInherit {
		String name = "border-right-style";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderBottomStyle {
		String name = "border-bottom-style";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderBottomStyleInherit {
		String name = "border-bottom-style";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderLeftStyle {
		String name = "border-left-style";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderBeginStyle {
		String name = "border-left-style";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderLeftStyleInherit {
		String name = "border-left-style";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderBeginStyleInherit {
		String name = "border-left-style";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderTopWidth {
		String name = "border-top-width";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderTopWidthInherit {
		String name = "border-top-width";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderRightWidth {
		String name = "border-right-width";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderEndWidth {
		String name = "border-right-width";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderRightWidthInherit {
		String name = "border-right-width";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderEndWidthInherit {
		String name = "border-right-width";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderBottomWidth {
		String name = "border-bottom-width";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderBottomWidthInherit {
		String name = "border-bottom-width";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderLeftWidth {
		String name = "border-left-width";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderBeginWidth {
		String name = "border-left-width";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderLeftWidthInherit {
		String name = "border-left-width";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderBeginWidthInherit {
		String name = "border-left-width";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderWidth {
		String name = "border-width";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderWidthInherit {
		String name = "border-width";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Border {
		String name = "border";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BorderInherit {
		String name = "border";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Bottom {
		String name = "bottom";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BottomAuto {
		String name = "bottom";
		String value = "auto";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BottomInherit {
		String name = "bottom";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CaptionSideTop {
		String name = "caption-side";
		String value = "top";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CaptionSideBottom {
		String name = "caption-side";
		String value = "bottom";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CaptionSideInherit {
		String name = "caption-side";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ClearNone {
		String name = "clear";
		String value = "none";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ClearLeft {
		String name = "clear";
		String value = "left";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ClearBegin {
		String name = "clear";
		String value = "left";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ClearRight {
		String name = "clear";
		String value = "right";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ClearEnd {
		String name = "clear";
		String value = "right";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ClearBoth {
		String name = "clear";
		String value = "both";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ClearInherit {
		String name = "clear";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Clip {
		String name = "clip";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ClipAuto {
		String name = "clip";
		String value = "auto";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ClipInherit {
		String name = "clip";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Color {
		String name = "color";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ColorInherit {
		String name = "color";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Content {
		String name = "content";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ContentNormal {
		String name = "content";
		String value = "normal";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ContentNone {
		String name = "content";
		String value = "none";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ContentAttr {
		String name = "content";
		String value = "attr";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ContentOpenQuote {
		String name = "content";
		String value = "open-quote";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ContentCloseQuote {
		String name = "content";
		String value = "close-quote";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ContentNoOpenQuote {
		String name = "content";
		String value = "no-open-quote";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ContentNoCloseQuote {
		String name = "content";
		String value = "no-close-quote";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ContentInherit {
		String name = "content";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CounterIncrement {
		String name = "counter-increment";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CounterIncrementNone {
		String name = "counter-increment";
		String value = "none";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CounterIncrementInherit {
		String name = "counter-increment";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CounterReset {
		String name = "counter-reset";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CounterResetNone {
		String name = "counter-reset";
		String value = "none";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CounterResetInherit {
		String name = "counter-reset";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CueAfter {
		String name = "cue-after";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CueAfterNone {
		String name = "cue-after";
		String value = "none";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CueAfterInherit {
		String name = "cue-after";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CueBefore {
		String name = "cue-before";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CueBeforeNone {
		String name = "cue-before";
		String value = "none";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CueBeforeInherit {
		String name = "cue-before";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Cue {
		String name = "cue";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CueInherit {
		String name = "cue";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Cursor {
		String name = "cursor";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CursorAuto {
		String name = "cursor";
		String value = "auto";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CursorCrosshair {
		String name = "cursor";
		String value = "crosshair";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CursorDefault {
		String name = "cursor";
		String value = "default";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CursorPointer {
		String name = "cursor";
		String value = "pointer";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CursorMove {
		String name = "cursor";
		String value = "move";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CursorEResize {
		String name = "cursor";
		String value = "e-resize";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CursorNeResize {
		String name = "cursor";
		String value = "ne-resize";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CursorNwResize {
		String name = "cursor";
		String value = "nw-resize";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CursorNResize {
		String name = "cursor";
		String value = "n-resize";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CursorSeResize {
		String name = "cursor";
		String value = "se-resize";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CursorSwResize {
		String name = "cursor";
		String value = "sw-resize";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CursorSResize {
		String name = "cursor";
		String value = "s-resize";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CursorWResize {
		String name = "cursor";
		String value = "w-resize";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CursorText {
		String name = "cursor";
		String value = "text";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CursorWait {
		String name = "cursor";
		String value = "wait";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CursorHelp {
		String name = "cursor";
		String value = "help";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CursorProgress {
		String name = "cursor";
		String value = "progress";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface CursorInherit {
		String name = "cursor";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface DirectionLtr {
		String name = "direction";
		String value = "ltr";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface DirectionRtl {
		String name = "direction";
		String value = "rtl";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface DirectionInherit {
		String name = "direction";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface DisplayInline {
		String name = "display";
		String value = "inline";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface DisplayBlock {
		String name = "display";
		String value = "block";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface DisplayListItem {
		String name = "display";
		String value = "list-item";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface DisplayRunIn {
		String name = "display";
		String value = "run-in";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface DisplayInlineBlock {
		String name = "display";
		String value = "inline-block";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface DisplayTable {
		String name = "display";
		String value = "table";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface DisplayInlineTable {
		String name = "display";
		String value = "inline-table";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface DisplayTableRowGroup {
		String name = "display";
		String value = "table-row-group";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface DisplayTableHeaderGroup {
		String name = "display";
		String value = "table-header-group";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface DisplayTableFooterGroup {
		String name = "display";
		String value = "table-footer-group";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface DisplayTableRow {
		String name = "display";
		String value = "table-row";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface DisplayTableColumnGroup {
		String name = "display";
		String value = "table-column-group";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface DisplayTableColumn {
		String name = "display";
		String value = "table-column";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface DisplayTableCell {
		String name = "display";
		String value = "table-cell";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface DisplayTableCaption {
		String name = "display";
		String value = "table-caption";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface DisplayNone {
		String name = "display";
		String value = "none";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface DisplayInherit {
		String name = "display";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Elevation {
		String name = "elevation";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ElevationBelow {
		String name = "elevation";
		String value = "below";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ElevationLevel {
		String name = "elevation";
		String value = "level";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ElevationAbove {
		String name = "elevation";
		String value = "above";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ElevationHigher {
		String name = "elevation";
		String value = "higher";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ElevationLower {
		String name = "elevation";
		String value = "lower";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ElevationInherit {
		String name = "elevation";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface EmptyCellsShow {
		String name = "empty-cells";
		String value = "show";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface EmptyCellsHide {
		String name = "empty-cells";
		String value = "hide";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface EmptyCellsInherit {
		String name = "empty-cells";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FloatLeft {
		String name = "float";
		String value = "left";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FloatBegin {
		String name = "float";
		String value = "left";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FloatRight {
		String name = "float";
		String value = "right";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FloatEnd {
		String name = "float";
		String value = "right";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FloatNone {
		String name = "float";
		String value = "none";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FloatInherit {
		String name = "float";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FontFamily {
		String name = "font-family";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FontFamilyInherit {
		String name = "font-family";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FontSize {
		String name = "font-size";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FontSizeInherit {
		String name = "font-size";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FontStyleNormal {
		String name = "font-style";
		String value = "normal";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FontStyleItalic {
		String name = "font-style";
		String value = "italic";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FontStyleOblique {
		String name = "font-style";
		String value = "oblique";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FontStyleInherit {
		String name = "font-style";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FontVariantNormal {
		String name = "font-variant";
		String value = "normal";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FontVariantSmallCaps {
		String name = "font-variant";
		String value = "small-caps";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FontVariantInherit {
		String name = "font-variant";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FontWeightNormal {
		String name = "font-weight";
		String value = "normal";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FontWeightBold {
		String name = "font-weight";
		String value = "bold";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FontWeightBolder {
		String name = "font-weight";
		String value = "bolder";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FontWeightLighter {
		String name = "font-weight";
		String value = "lighter";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FontWeightInherit {
		String name = "font-weight";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Font {
		String name = "font";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FontCaption {
		String name = "font";
		String value = "caption";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FontIcon {
		String name = "font";
		String value = "icon";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FontMenu {
		String name = "font";
		String value = "menu";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FontMessageBox {
		String name = "font";
		String value = "message-box";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FontSmallCaption {
		String name = "font";
		String value = "small-caption";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FontStatusBar {
		String name = "font";
		String value = "status-bar";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface FontInherit {
		String name = "font";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Height {
		String name = "height";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface HeightAuto {
		String name = "height";
		String value = "auto";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface HeightInherit {
		String name = "height";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Left {
		String name = "left";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Begin {
		String name = "left";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface LeftAuto {
		String name = "left";
		String value = "auto";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BeginAuto {
		String name = "left";
		String value = "auto";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface LeftInherit {
		String name = "left";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface BeginInherit {
		String name = "left";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface LetterSpacing {
		String name = "letter-spacing";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface LetterSpacingNormal {
		String name = "letter-spacing";
		String value = "normal";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface LetterSpacingInherit {
		String name = "letter-spacing";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface LineHeight {
		String name = "line-height";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface LineHeightNormal {
		String name = "line-height";
		String value = "normal";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface LineHeightInherit {
		String name = "line-height";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStyleImage {
		String name = "list-style-image";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStyleImageNone {
		String name = "list-style-image";
		String value = "none";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStyleImageInherit {
		String name = "list-style-image";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStylePositionInside {
		String name = "list-style-position";
		String value = "inside";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStylePositionOutside {
		String name = "list-style-position";
		String value = "outside";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStylePositionInherit {
		String name = "list-style-position";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStyleTypeDisc {
		String name = "list-style-type";
		String value = "disc";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStyleTypeCircle {
		String name = "list-style-type";
		String value = "circle";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStyleTypeSquare {
		String name = "list-style-type";
		String value = "square";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStyleTypeDecimal {
		String name = "list-style-type";
		String value = "decimal";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStyleTypeDecimalLeadingZero {
		String name = "list-style-type";
		String value = "decimal-leading-zero";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStyleTypeLowerRoman {
		String name = "list-style-type";
		String value = "lower-roman";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStyleTypeUpperRoman {
		String name = "list-style-type";
		String value = "upper-roman";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStyleTypeLowerGreek {
		String name = "list-style-type";
		String value = "lower-greek";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStyleTypeLowerLatin {
		String name = "list-style-type";
		String value = "lower-latin";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStyleTypeUpperLatin {
		String name = "list-style-type";
		String value = "upper-latin";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStyleTypeArmenian {
		String name = "list-style-type";
		String value = "armenian";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStyleTypeGeorgian {
		String name = "list-style-type";
		String value = "georgian";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStyleTypeLowerAlpha {
		String name = "list-style-type";
		String value = "lower-alpha";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStyleTypeUpperAlpha {
		String name = "list-style-type";
		String value = "upper-alpha";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStyleTypeNone {
		String name = "list-style-type";
		String value = "none";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStyleTypeInherit {
		String name = "list-style-type";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStyle {
		String name = "list-style";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ListStyleInherit {
		String name = "list-style";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface MarginRight {
		String name = "margin-right";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface MarginEnd {
		String name = "margin-right";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface MarginRightInherit {
		String name = "margin-right";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface MarginEndInherit {
		String name = "margin-right";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface MarginLeft {
		String name = "margin-left";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface MarginBegin {
		String name = "margin-left";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface MarginLeftInherit {
		String name = "margin-left";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface MarginBeginInherit {
		String name = "margin-left";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface MarginTop {
		String name = "margin-top";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface MarginTopInherit {
		String name = "margin-top";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface MarginBottom {
		String name = "margin-bottom";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface MarginBottomInherit {
		String name = "margin-bottom";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Margin {
		String name = "margin";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface MarginInherit {
		String name = "margin";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface MaxHeight {
		String name = "max-height";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface MaxHeightNone {
		String name = "max-height";
		String value = "none";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface MaxHeightInherit {
		String name = "max-height";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface MaxWidth {
		String name = "max-width";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface MaxWidthNone {
		String name = "max-width";
		String value = "none";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface MaxWidthInherit {
		String name = "max-width";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface MinHeight {
		String name = "min-height";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface MinHeightInherit {
		String name = "min-height";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface MinWidth {
		String name = "min-width";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface MinWidthInherit {
		String name = "min-width";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Orphans {
		String name = "orphans";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface OrphansInherit {
		String name = "orphans";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface OutlineColor {
		String name = "outline-color";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface OutlineColorInvert {
		String name = "outline-color";
		String value = "invert";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface OutlineColorInherit {
		String name = "outline-color";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface OutlineStyle {
		String name = "outline-style";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface OutlineStyleInherit {
		String name = "outline-style";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface OutlineWidth {
		String name = "outline-width";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface OutlineWidthInherit {
		String name = "outline-width";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Outline {
		String name = "outline";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface OutlineInherit {
		String name = "outline";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface OverflowVisible {
		String name = "overflow";
		String value = "visible";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface OverflowHidden {
		String name = "overflow";
		String value = "hidden";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface OverflowScroll {
		String name = "overflow";
		String value = "scroll";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface OverflowAuto {
		String name = "overflow";
		String value = "auto";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface OverflowInherit {
		String name = "overflow";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PaddingTop {
		String name = "padding-top";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PaddingTopInherit {
		String name = "padding-top";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PaddingRight {
		String name = "padding-right";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PaddingEnd {
		String name = "padding-right";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PaddingRightInherit {
		String name = "padding-right";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PaddingEndInherit {
		String name = "padding-right";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PaddingBottom {
		String name = "padding-bottom";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PaddingBottomInherit {
		String name = "padding-bottom";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PaddingLeft {
		String name = "padding-left";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PaddingBegin {
		String name = "padding-left";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PaddingLeftInherit {
		String name = "padding-left";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PaddingBeginInherit {
		String name = "padding-left";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Padding {
		String name = "padding";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PaddingInherit {
		String name = "padding";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PageBreakAfterAuto {
		String name = "page-break-after";
		String value = "auto";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PageBreakAfterAlways {
		String name = "page-break-after";
		String value = "always";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PageBreakAfterAvoid {
		String name = "page-break-after";
		String value = "avoid";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PageBreakAfterLeft {
		String name = "page-break-after";
		String value = "left";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PageBreakAfterBegin {
		String name = "page-break-after";
		String value = "left";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PageBreakAfterRight {
		String name = "page-break-after";
		String value = "right";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PageBreakAfterEnd {
		String name = "page-break-after";
		String value = "right";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PageBreakAfterInherit {
		String name = "page-break-after";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PageBreakBeforeAuto {
		String name = "page-break-before";
		String value = "auto";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PageBreakBeforeAlways {
		String name = "page-break-before";
		String value = "always";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PageBreakBeforeAvoid {
		String name = "page-break-before";
		String value = "avoid";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PageBreakBeforeLeft {
		String name = "page-break-before";
		String value = "left";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PageBreakBeforeBegin {
		String name = "page-break-before";
		String value = "left";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PageBreakBeforeRight {
		String name = "page-break-before";
		String value = "right";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PageBreakBeforeEnd {
		String name = "page-break-before";
		String value = "right";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PageBreakBeforeInherit {
		String name = "page-break-before";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PageBreakInsideAvoid {
		String name = "page-break-inside";
		String value = "avoid";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PageBreakInsideAuto {
		String name = "page-break-inside";
		String value = "auto";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PageBreakInsideInherit {
		String name = "page-break-inside";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PauseAfter {
		String name = "pause-after";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PauseAfterInherit {
		String name = "pause-after";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PauseBefore {
		String name = "pause-before";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PauseBeforeInherit {
		String name = "pause-before";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Pause {
		String name = "pause";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PauseInherit {
		String name = "pause";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PitchRange {
		String name = "pitch-range";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PitchRangeInherit {
		String name = "pitch-range";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Pitch {
		String name = "pitch";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PitchXLow {
		String name = "pitch";
		String value = "x-low";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PitchLow {
		String name = "pitch";
		String value = "low";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PitchMedium {
		String name = "pitch";
		String value = "medium";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PitchHigh {
		String name = "pitch";
		String value = "high";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PitchXHigh {
		String name = "pitch";
		String value = "x-high";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PitchInherit {
		String name = "pitch";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PlayDuring {
		String name = "play-during";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PlayDuringMix {
		String name = "play-during";
		String value = "mix";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PlayDuringRepeat {
		String name = "play-during";
		String value = "repeat";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PlayDuringAuto {
		String name = "play-during";
		String value = "auto";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PlayDuringNone {
		String name = "play-during";
		String value = "none";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PlayDuringInherit {
		String name = "play-during";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PositionStatic {
		String name = "position";
		String value = "static";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PositionRelative {
		String name = "position";
		String value = "relative";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PositionAbsolute {
		String name = "position";
		String value = "absolute";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PositionFixed {
		String name = "position";
		String value = "fixed";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface PositionInherit {
		String name = "position";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Quotes {
		String name = "quotes";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface QuotesNone {
		String name = "quotes";
		String value = "none";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface QuotesInherit {
		String name = "quotes";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Richness {
		String name = "richness";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface RichnessInherit {
		String name = "richness";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Right {
		String name = "right";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface End {
		String name = "right";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface RightAuto {
		String name = "right";
		String value = "auto";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface EndAuto {
		String name = "right";
		String value = "auto";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface RightInherit {
		String name = "right";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface EndInherit {
		String name = "right";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface SpeakHeaderOnce {
		String name = "speak-header";
		String value = "once";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface SpeakHeaderAlways {
		String name = "speak-header";
		String value = "always";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface SpeakHeaderInherit {
		String name = "speak-header";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface SpeakNumeralDigits {
		String name = "speak-numeral";
		String value = "digits";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface SpeakNumeralContinuous {
		String name = "speak-numeral";
		String value = "continuous";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface SpeakNumeralInherit {
		String name = "speak-numeral";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface SpeakPunctuationCode {
		String name = "speak-punctuation";
		String value = "code";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface SpeakPunctuationNone {
		String name = "speak-punctuation";
		String value = "none";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface SpeakPunctuationInherit {
		String name = "speak-punctuation";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface SpeakNormal {
		String name = "speak";
		String value = "normal";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface SpeakNone {
		String name = "speak";
		String value = "none";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface SpeakSpellOut {
		String name = "speak";
		String value = "spell-out";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface SpeakInherit {
		String name = "speak";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface SpeechRate {
		String name = "speech-rate";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface SpeechRateXSlow {
		String name = "speech-rate";
		String value = "x-slow";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface SpeechRateSlow {
		String name = "speech-rate";
		String value = "slow";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface SpeechRateMedium {
		String name = "speech-rate";
		String value = "medium";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface SpeechRateFast {
		String name = "speech-rate";
		String value = "fast";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface SpeechRateXFast {
		String name = "speech-rate";
		String value = "x-fast";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface SpeechRateFaster {
		String name = "speech-rate";
		String value = "faster";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface SpeechRateSlower {
		String name = "speech-rate";
		String value = "slower";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface SpeechRateInherit {
		String name = "speech-rate";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Stress {
		String name = "stress";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface StressInherit {
		String name = "stress";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TableLayoutAuto {
		String name = "table-layout";
		String value = "auto";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TableLayoutFixed {
		String name = "table-layout";
		String value = "fixed";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TableLayoutInherit {
		String name = "table-layout";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TextAlignLeft {
		String name = "text-align";
		String value = "left";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TextAlignBegin {
		String name = "text-align";
		String value = "left";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TextAlignRight {
		String name = "text-align";
		String value = "right";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TextAlignEnd {
		String name = "text-align";
		String value = "right";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TextAlignCenter {
		String name = "text-align";
		String value = "center";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TextAlignJustify {
		String name = "text-align";
		String value = "justify";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TextAlignInherit {
		String name = "text-align";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TextDecorationNone {
		String name = "text-decoration";
		String value = "none";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TextDecorationUnderline {
		String name = "text-decoration";
		String value = "underline";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TextDecorationOverline {
		String name = "text-decoration";
		String value = "overline";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TextDecorationLineThrough {
		String name = "text-decoration";
		String value = "line-through";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TextDecorationBlink {
		String name = "text-decoration";
		String value = "blink";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TextDecorationInherit {
		String name = "text-decoration";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TextIndent {
		String name = "text-indent";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TextIndentInherit {
		String name = "text-indent";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TextTransformCapitalize {
		String name = "text-transform";
		String value = "capitalize";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TextTransformUppercase {
		String name = "text-transform";
		String value = "uppercase";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TextTransformLowercase {
		String name = "text-transform";
		String value = "lowercase";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TextTransformNone {
		String name = "text-transform";
		String value = "none";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TextTransformInherit {
		String name = "text-transform";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Top {
		String name = "top";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TopAuto {
		String name = "top";
		String value = "auto";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface TopInherit {
		String name = "top";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface UnicodeBidiNormal {
		String name = "unicode-bidi";
		String value = "normal";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface UnicodeBidiEmbed {
		String name = "unicode-bidi";
		String value = "embed";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface UnicodeBidiBidiOverride {
		String name = "unicode-bidi";
		String value = "bidi-override";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface UnicodeBidiInherit {
		String name = "unicode-bidi";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface VerticalAlign {
		String name = "vertical-align";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface VerticalAlignBaseline {
		String name = "vertical-align";
		String value = "baseline";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface VerticalAlignSub {
		String name = "vertical-align";
		String value = "sub";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface VerticalAlignSuper {
		String name = "vertical-align";
		String value = "super";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface VerticalAlignTop {
		String name = "vertical-align";
		String value = "top";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface VerticalAlignTextTop {
		String name = "vertical-align";
		String value = "text-top";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface VerticalAlignMiddle {
		String name = "vertical-align";
		String value = "middle";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface VerticalAlignBottom {
		String name = "vertical-align";
		String value = "bottom";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface VerticalAlignTextBottom {
		String name = "vertical-align";
		String value = "text-bottom";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface VerticalAlignInherit {
		String name = "vertical-align";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface VisibilityVisible {
		String name = "visibility";
		String value = "visible";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface VisibilityHidden {
		String name = "visibility";
		String value = "hidden";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface VisibilityCollapse {
		String name = "visibility";
		String value = "collapse";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface VisibilityInherit {
		String name = "visibility";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface VoiceFamily {
		String name = "voice-family";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface VoiceFamilyInherit {
		String name = "voice-family";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Volume {
		String name = "volume";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface VolumeSilent {
		String name = "volume";
		String value = "silent";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface VolumeXSoft {
		String name = "volume";
		String value = "x-soft";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface VolumeSoft {
		String name = "volume";
		String value = "soft";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface VolumeMedium {
		String name = "volume";
		String value = "medium";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface VolumeLoud {
		String name = "volume";
		String value = "loud";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface VolumeXLoud {
		String name = "volume";
		String value = "x-loud";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface VolumeInherit {
		String name = "volume";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface WhiteSpaceNormal {
		String name = "white-space";
		String value = "normal";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface WhiteSpacePre {
		String name = "white-space";
		String value = "pre";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface WhiteSpaceNowrap {
		String name = "white-space";
		String value = "nowrap";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface WhiteSpacePreWrap {
		String name = "white-space";
		String value = "pre-wrap";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface WhiteSpacePreLine {
		String name = "white-space";
		String value = "pre-line";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface WhiteSpaceInherit {
		String name = "white-space";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Widows {
		String name = "widows";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface WidowsInherit {
		String name = "widows";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Width {
		String name = "width";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface WidthAuto {
		String name = "width";
		String value = "auto";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface WidthInherit {
		String name = "width";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface WordSpacing {
		String name = "word-spacing";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface WordSpacingNormal {
		String name = "word-spacing";
		String value = "normal";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface WordSpacingInherit {
		String name = "word-spacing";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ZIndex {
		String name = "z-index";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ZIndexAuto {
		String name = "z-index";
		String value = "auto";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface ZIndexInherit {
		String name = "z-index";
		String value = "inherit";
		boolean important() default false;
		Condition[] condition() default {};
	}
	@StyleDef @Retention(RetentionPolicy.RUNTIME) 
	public @interface Zoom {
		String name = "zoom";
		String value() default "";
		boolean important() default false;
		Condition[] condition() default {};
	}}