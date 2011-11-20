package com.df.gwt.style.annotation.sample.client;

import com.df.gwt.style.annotation.client.Externals;
import com.df.gwt.style.annotation.client.Externals.External;
import com.df.gwt.style.annotation.client.Style;
import com.df.gwt.style.annotation.client.Style.Background;
import com.df.gwt.style.annotation.client.Style.Border;
import com.df.gwt.style.annotation.client.Style.CursorPointer;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

//These external rules will not be encoded and will be put with the exact rule name in your html
@Externals({
	@External(className = "gwt-Hyperlink", value = "background:yellow"),
	@External(typeName = "body", value = "margin:10px")
})
public class DoMoreWidget extends SimplePanel {

	// Group a bunch of rules into a new style annotation name
	@CommonStyle
	@DisplayInlineBlockFix
	@LinkStyle
	@Background(value="lightGoldenrodYellow", important=true)
	Hyperlink link = new Hyperlink("CSS made easy in GWT", "");

	{
		add(getLink());
	}

	// Any other style you cannot find the equivalent annotation for
	@Style("\\-webkit-border-radius:10px")
	@Border("solid 2px black")
	@CursorPointer
	protected Widget getLink() {
		return link;
	}
}