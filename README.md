# TestCustomWidgets
CustomWidgets

1.LoadingDialog 
```
LoadingDialog loadingDialog;

private void showLoadingDialog(Context context) {
    if (loadingDialog != null)
        loadingDialog.hide();
        
    loadingDialog = new LoadingDialog(context);
}

loadingDialog.hide();
```


2.CustomViews 
```
```
Import fonts what you want to use in /src/main/assets/fonts
```
<com.example.testcustomwidgetslibrary.CustomTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:font_name="fontName"
        app:font_variant="fontVariant"/>

```
font_name is name of your font
font_variant is style of your font 

example 
/assets/fonts/ShadowsIntoLight.ttf
in this case you need just to type 
```
app:font_name = "ShadowsIntoLight"
```
(without extension)

if you have something like this: 
/assets/fonts/ShadowsIntoLight-Bold.ttf
in this case you need just to type 
```
app:font_name = "ShadowsIntoLight"
app:font_variant = "Bold"
```

Types of Custom views:
CustomTextView, CustomEditText, CustomAutocompleteTextView, CustomButton

