### GWT Style Annotation ###

Get rid of that lengthy .css file and add your style right where they belong in the code with java annotation.

Using annotations provides a nice separation of concerns. The logic code is clean of styling code. The style rules will be annotated right on the element they belong to.

You can use the style annotations on any class that extends from `com.google.gwt.user.client.ui.Widget` and instantiated with GWT.create() method.


After adding the latest jar file to your project (copy it to `war/WEB-INF/lib` directory and add it to project dependencies in Eclipse), inherit the module in your gwt.xml file
```
<inherits name="com.df.gwt.style.annotation.StyleAnnotation"/>
```
That's it.

Now you can add styles to a widget class:
```
@Padding("5px")
public class MyWidget extends Widget{}
```

A field inside a widget class
```
@Border("outset 3px")
Label label = new Label("I am styled");
```

A method return value
```
@FontWeightBold
protected Widget getMyWidget() {
	return myWidget;
}
```

A method argument
```
void myMethod(@Color("red") Label label) {
	// code goes here
}
```

**Please note:**
  * Make sure annotations are only used in a widget subclass and that widget is instantiated using `GWT.create()` method. **Only widgets that are instantiated with `GWT.create()` will be styled according to their annotations**.
  * Style annotations are not allowed on a **final class**, a **private field**, and a **final, static, or private method** (if you have private field you can add the style to the getter  method or setter's argument).


Here is a sample styled widget:

```
@Background("white")
public class SimpleWidget extends FlowPanel {

	@Border("outset 3px")
	@Padding("5px !important")
	Label label = new Label("I am styled");

	{
		this.add(getLabel());
		addStyleToArgument(label);

		this.add(GWT.<DoMoreWidget> create(DoMoreWidget.class));
	}

	@FontWeightBold(important = true)
	@FontStyleItalic
	@Background("lavendar")
	@Style("\\-webkit-border-radius:10px")
	protected Widget getLabel() {
		return label;
	}

	void addStyleToArgument(@Color("red") final Label label) {
		// code goes here
	}

}
```

Take a look at the [DoMoreWidget.java](https://code.google.com/p/gwt-style-annotation/source/browse/gwt-style-annotation-sample/src/com/df/gwt/style/annotation/sample/client/DoMoreWidget.java) in the sample code to see all you can do like [group a couple of rules as a single annotation](https://code.google.com/p/gwt-style-annotation/source/browse/gwt-style-annotation-sample/src/com/df/gwt/style/annotation/sample/client/CommonStyle.java), [external rules](https://code.google.com/p/gwt-style-annotation/source/browse/gwt-style-annotation-sample/src/com/df/gwt/style/annotation/sample/client/DoMoreWidget.java), [selectors](https://code.google.com/p/gwt-style-annotation/source/browse/gwt-style-annotation-sample/src/com/df/gwt/style/annotation/sample/client/LinkStyle.java), [conditional rules based on userAgent](https://code.google.com/p/gwt-style-annotation/source/browse/gwt-style-annotation-sample/src/com/df/gwt/style/annotation/sample/client/DisplayInlineBlockFix.java) and more.




.