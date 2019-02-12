package com.example.netcore.baseproject;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;

public class Utility {

public static void showAlert(Context context,String title,String message){
    AlertDialog.Builder builder;
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
    } else {
        builder = new AlertDialog.Builder(context);
    }
    builder.setTitle(title)
            .setMessage("mess" +
                    "")
            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // continue with delete
                }
            })
            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // do nothing
                }
            })
            .setIcon(R.mipmap.ic_launcher)
            .show();
}
}
