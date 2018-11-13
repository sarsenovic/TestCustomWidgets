package com.example.testcustomwidgetslibrary;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;

import com.androidnetworking.AndroidNetworking;

public class LoadingDialog {
    private ProgressDialog dialog;

    public LoadingDialog(Context context) {
        show(context);
    }

    public void show(Context context) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
            dialog = new ProgressDialog(context, R.style.LoadingDialogStyle);
        } else{
            dialog = new ProgressDialog(context, R.style.LoadingDialogStyle2);
        }

        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    AndroidNetworking.forceCancelAll();
                    dialog.dismiss();
                }

                return true;
            }
        });

        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage(context.getString(R.string.loading_dialog));
        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
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
}
