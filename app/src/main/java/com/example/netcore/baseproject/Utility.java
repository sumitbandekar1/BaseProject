package com.example.netcore.baseproject;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;

public class Utility {

public static void showAlert(Context context,String title,String message){
    final AlertDialog.Builder builder;
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        builder = new AlertDialog.Builder(context, android.R.style.Theme_DeviceDefault_Dialog_MinWidth);
    } else {
        builder = new AlertDialog.Builder(context);
    }
    builder.setTitle(title)
            .setMessage(message)
            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            })
            .setIcon(R.mipmap.ic_launcher)
            .show();
    }
}
