package com.example.netcore.baseproject;

import android.app.Application;

import in.netcore.smartechfcm.NetcoreSDK;


public class AppClass extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
       NetcoreSDK.register(this,AppConstant.SMARTECH_APP_ID);
    }
}
