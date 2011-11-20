package com.df.gwt.style.annotation.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

public class StyleAnnotationSample implements EntryPoint {

	@Override
	public void onModuleLoad() {

		//Widgets need to be instantiated using GWT.create method
		final SimpleWidget widget = GWT.create(SimpleWidget.class);
		RootPanel.get().add(widget);
	}
}
