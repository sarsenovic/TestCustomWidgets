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
