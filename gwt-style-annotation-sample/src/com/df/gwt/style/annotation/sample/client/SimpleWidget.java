package com.df.gwt.style.annotation.sample.client;

import com.df.gwt.style.annotation.client.Style.Background;
import com.df.gwt.style.annotation.client.Style.Border;
import com.df.gwt.style.annotation.client.Style.Color;
import com.df.gwt.style.annotation.client.Style.FontStyleItalic;
import com.df.gwt.style.annotation.client.Style.FontWeightBold;
import com.df.gwt.style.annotation.client.Style.Padding;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

@Border("solid 1px black")
@Padding("5px !important")
public class SimpleWidget extends FlowPanel {

	@Border("outset 3px")
	@Padding("5px")
	Label label = new Label("I am styled");

	{
		this.add(getLabel());
		addStyleToArgument(label);

		this.add(GWT.<DoMoreWidget> create(DoMoreWidget.class));
	}

	@FontWeightBold(important = true)
	@FontStyleItalic
	@Background("lavendar")
	protected Widget getLabel() {
		return label;
	}

	void addStyleToArgument(@Color("red") final Label label) {
		// dadadadada
	}

}