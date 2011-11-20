package com.df.gwt.style.annotation.sample.client;

import com.df.gwt.style.annotation.client.GlobalCondition;
import com.df.gwt.style.annotation.client.Style.BackgroundColor;
import com.df.gwt.style.annotation.client.Style.Condition;
import com.df.gwt.style.annotation.client.Style.FontWeightBold;
import com.df.gwt.style.annotation.client.Style.TextDecorationNone;
import com.df.gwt.style.annotation.client.StyleDef;

@StyleDef
@BackgroundColor(condition = @Condition(selector = "a:hover", value = "#E0EDFE"))
@FontWeightBold
@TextDecorationNone
@GlobalCondition(condition = @Condition(selector = "a"))
// @GlobalCondition(condition = @Condition(selector = "*"))
public @interface LinkStyle {
}