# TestCustomWidgets
CustomWidgets

1.LoadingDialog 

LoadingDialog loadingDialog;

private void showLoadingDialog(Context context) {
    hideLoadingDialog();
    loadingDialog = new LoadingDialog(context);
}

private void hideLoadingDialog() {
    if (loadingDialog != null) {
        loadingDialog.hide();
        loadingDialog = null;
    }
}
