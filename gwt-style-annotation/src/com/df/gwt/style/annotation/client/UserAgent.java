package com.df.gwt.style.annotation.client;


public abstract class UserAgent {
	protected abstract boolean accept(String userAgent);


	public static abstract class PatternBaseUserAgent extends UserAgent {

		protected abstract String pattern();

		@Override
		public boolean accept(final String userAgent) {
			return userAgent.toLowerCase().split(pattern()).length > 1;
		}
	}


	public static class OPERA extends PatternBaseUserAgent {@Override protected String pattern() { return "opera"; }}
	public static class SAFARI extends PatternBaseUserAgent {@Override protected String pattern() { return "webkit"; }}
	public static class IE extends PatternBaseUserAgent {@Override protected String pattern() { return "msie"; }}
	public static class GECKO extends PatternBaseUserAgent {@Override protected String pattern() { return "gecko"; }}
	public static class IE6 extends PatternBaseUserAgent {@Override protected String pattern() { return "msie 6\\."; }}
	public static class IE7 extends PatternBaseUserAgent {@Override protected String pattern() { return "msie 7\\."; }}
	public static class IE8 extends PatternBaseUserAgent {@Override protected String pattern() { return "msie 8\\."; }}
	public static class IE7OrLess extends PatternBaseUserAgent {@Override protected String pattern() { return "msie [0-7]\\."; }}
	public static class IE8OrLess extends PatternBaseUserAgent {@Override protected String pattern() { return "msie [0-8]\\."; }}
}
