package com.df.gwt.style.annotation.sample.client;

import com.df.gwt.style.annotation.client.Style.Condition;
import com.df.gwt.style.annotation.client.Style.DisplayBlock;
import com.df.gwt.style.annotation.client.Style.DisplayInline;
import com.df.gwt.style.annotation.client.Style.DisplayInlineBlock;
import com.df.gwt.style.annotation.client.Style.Zoom;
import com.df.gwt.style.annotation.client.StyleDef;
import com.df.gwt.style.annotation.client.UserAgent.IE7OrLess;

@StyleDef
@DisplayInlineBlock(condition = @Condition(userAgent = IE7OrLess.class, not = true))
@DisplayInline(condition = @Condition(userAgent = IE7OrLess.class))
@Zoom(condition = @Condition(value = "1", userAgent = IE7OrLess.class))
@DisplayBlock(condition = @Condition(userAgent = CustomUserAgent.class))
public @interface DisplayInlineBlockFix {
}
