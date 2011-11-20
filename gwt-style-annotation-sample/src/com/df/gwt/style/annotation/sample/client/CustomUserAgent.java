package com.df.gwt.style.annotation.sample.client;

import com.df.gwt.style.annotation.client.UserAgent;
import com.df.gwt.style.annotation.client.UserAgent.PatternBaseUserAgent;

public class CustomUserAgent extends PatternBaseUserAgent {
	@Override
	protected String pattern() {
		return "Android 2\\.";
	}

	public class AnotherUserAgent extends UserAgent {
		@Override
		protected boolean accept(final String userAgent) {
			// all userAgents are accepted (you can add your useragent check
			// here)
			return true;
		}

	}
}
