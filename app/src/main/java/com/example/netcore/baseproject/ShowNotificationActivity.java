package com.example.netcore.baseproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.netcore.baseproject.Model.MasterModel;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import in.netcore.smartechfcm.NetcoreSDK;

public class ShowNotificationActivity extends AppCompatActivity {

    RecyclerView notification_recycler;
    RecyclerAdapter adapter;
    Gson gson=new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_notification);

       notification_recycler=findViewById(R.id.notification_recycler);

       JSONArray json= NetcoreSDK.getNotifications(ShowNotificationActivity.this);

    //  List<MasterModel> mModel= (List<MasterModel>) gson.fromJson(json.toString(),MasterModel.class);
        Type listType = new TypeToken<List<MasterModel>>(){}.getType();
        List<MasterModel> notificationList = gson.fromJson(json.toString(), listType);

        try {

            JSONObject obj = new JSONObject(notificationList.get(1).getMessage());

            Log.d("My App", obj.toString());

        } catch (Throwable t) {
            Log.e("My App", "Could not parse malformed JSON: \"" + json + "\"");
        }

        Log.d("jsonData", "onCreate: "+json);
        adapter=new RecyclerAdapter(getApplicationContext(),notificationList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        notification_recycler.setLayoutManager(mLayoutManager);
        notification_recycler.setAdapter(adapter);

    }
}
