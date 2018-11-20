package com.example.testcustomwidgetslibrary;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Builds an alert dialog with custom features.
 */
public class DialogMessage {

    /**
     * Builds an alert dialog just with message.
     *
     * @param context Context.
     * @param title not null String, naslov.
     * @param message not null String koji zelimo da ispisemo kao poruku.
     */
    public static void showDialogMessage(Context context, String title, String message) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle(title)
                .setMessage(message)
                .create()
                .show();
    }

    /**
     * Builds an alert dialog with message and default button.
     *
     * @param context Context.
     * @param title not null String, naslov.
     * @param message not null String koji zelimo da ispisemo kao poruku.
     * @param actionName not null String za ime dugmeta
     */
    public static void showDialogMessageWithDefaultAction(Context context, String title, String message, String actionName) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle(title)
                .setMessage(message)
                .setPositiveButton(actionName, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Default
                    }
                })
                .create()
                .show();
    }

    /**
     * Builds an alert dialog with one action.
     *
     * @param context Context.
     * @param title not null String, naslov.
     * @param message not null String koji zelimo da ispisemo kao poruku.
     * @param callback Interfejs za akcije.
     * @param positiveButtonText not null String za naziv akcije.
     * @param tag not null String koji sluzi za lakse manipulisanje dijalozima ako ih ima vise u okviru klase.
     */
    public static void showDialogMessageWithOneAction(Context context, String title, String message, final DialogMessageInterface callback, String positiveButtonText, final String tag) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        callback.onDialogClickPositiveButton(tag);
                    }
                })
                .create()
                .show();
    }

    /**
     * Builds an alert dialog with one action.
     *
     * @param context Context.
     * @param title not null String, naslov.
     * @param message not null String koji zelimo da ispisemo kao poruku.
     * @param callback Interfejs za akcije.
     * @param positiveButtonText not null String za naziv akcije 1.
     * @param negativeButtonText not null String za naziv akcije 2.
     * @param tag not null String koji sluzi za lakse manipulisanje dijalozima ako ih ima vise u okviru klase.
     */
    public static void showDialogMessageWithTwoActions(Context context, String title, String message, final DialogMessageInterface callback, String positiveButtonText,
                                                       String negativeButtonText, final String tag) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        callback.onDialogClickPositiveButton(tag);
                    }
                })
                .setNegativeButton(negativeButtonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        callback.onDialogClickNegativeButton(tag);
                    }
                })
                .create()
                .show();
    }

    /**
     * Builds an alert dialog with one action.
     *
     * @param context Context.
     * @param title not null String, naslov.
     * @param message not null String koji zelimo da ispisemo kao poruku.
     * @param callback Interfejs za akcije.
     * @param positiveButtonText not null String za naziv akcije 1.
     * @param negativeButtonText not null String za naziv akcije 2.
     * @param neutralButtonText not null String za naziv akcije 3.
     * @param tag not null String koji sluzi za lakse manipulisanje dijalozima ako ih ima vise u okviru klase.
     */
    public static void showDialogMessageWithThreeActions(Context context, String title, String message, final DialogMessageInterface callback, String positiveButtonText,
                                                         String negativeButtonText, String neutralButtonText, final String tag) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        callback.onDialogClickPositiveButton(tag);
                    }
                })
                .setNegativeButton(negativeButtonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        callback.onDialogClickNegativeButton(tag);
                    }
                })
                .setNeutralButton(neutralButtonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        callback.onDialogClickNeutralButton(tag);
                    }
                })
                .create()
                .show();
    }
}
