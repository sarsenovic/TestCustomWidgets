package com.example.testcustomwidgetslibrary;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.KeyEvent;

import com.androidnetworking.AndroidNetworking;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoadingDialog {
    private static final String HEX_PATTERN = "^#([0-9a-f]{3}|[0-9a-f]{6}|[0-9a-f]{8})$";
    private ProgressDialog dialog;
    private Pattern pattern;
    private Matcher matcher;
    private int color;

//    String hexColor;
    String colorString;
    String style;
    String message;
    boolean cancelable;
    boolean cancelableOnTouchOutside;
    boolean dismissOnBackClick;
//    private Res res;

//    public LoadingDialog(Context context, String colorString, String style, String message, boolean dismissOnBackClick) {
//        this.colorString = colorString;
//        this.style = style;
//        this.message = message;
//        this.dismissOnBackClick = dismissOnBackClick;
//
////        pattern = Pattern.compile(HEX_PATTERN);
////        matcher = pattern.matcher(hexColor);
//
//        show(context);
//    }

    public LoadingDialog(Context context, String message, boolean dismissOnBackClick) {
        this.message = message;
        this.dismissOnBackClick = dismissOnBackClick;

//        pattern = Pattern.compile(HEX_PATTERN);
//        matcher = pattern.matcher(hexColor);

        show(context);
    }

    public void show(Context context) {

//        if (matcher.matches()) {
//            color = Color.parseColor(hexColor);
//
////            res = new Res(context.getResources());
////            res.getColor();
//        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
            dialog = new ProgressDialog(context, R.style.LoadingDialogStyle);
        } else{
            dialog = new ProgressDialog(context, R.style.LoadingDialogStyle2);
        }

        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    if (dismissOnBackClick) {
                        AndroidNetworking.forceCancelAll();
                        dialog.dismiss();
                    }
                }

                return true;
            }
        });



        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        if (message == null) {
            dialog.setMessage(context.getString(R.string.loading_dialog));
        } else {
            dialog.setMessage(message);
        }

        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(cancelableOnTouchOutside);
        dialog.setCancelable(cancelable);
        dialog.show();
    }

    public void hide() {
        if (dialog != null) {
            try {
                dialog.dismiss();
            } catch (Exception e) {
                // U slučaju kada je dismiss pozvan asinhrono a activity prethodno ugašen
            }
        }
    }

    public boolean isCancelable() {
        return cancelable;
    }

    public void setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
    }

    public boolean isCancelableOnTouchOutside() {
        return cancelableOnTouchOutside;
    }

    public void setCancelableOnTouchOutside(boolean cancelableOnTouchOutside) {
        this.cancelableOnTouchOutside = cancelableOnTouchOutside;
    }
}
