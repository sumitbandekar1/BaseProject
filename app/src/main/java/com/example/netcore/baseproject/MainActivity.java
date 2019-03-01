package com.example.netcore.baseproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import in.netcore.smartechfcm.NetcoreSDK;

public class MainActivity extends AppCompatActivity {

    Button btn_add_to_cart,btn_remove_from_cart,btn_checkout,btn_card_expired,btn_page_browse,btn_profile_update
            ,btn_opt_in,btn_opt_out ,btn_custom_data,btn_other_function,btn_guid,btn_get_pn,btn_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_add_to_cart=findViewById(R.id.custome_event);
        btn_remove_from_cart=findViewById(R.id.remove_from_cart);
        btn_checkout=findViewById(R.id.checkout);
        btn_card_expired=findViewById(R.id.cart_expired);
        btn_page_browse=findViewById(R.id.page_browse);
        btn_profile_update=findViewById(R.id.profile_update);
        btn_opt_in=findViewById(R.id.opt_in);
        btn_opt_out=findViewById(R.id.opt_out);
        btn_custom_data=findViewById(R.id.custom_data);
        btn_other_function=findViewById(R.id.other_function);
        btn_guid=findViewById(R.id.get_guid);
        btn_get_pn=findViewById(R.id.get_notification);
        btn_logout=findViewById(R.id.logout);

        btn_add_to_cart.setOnClickListener(onClickListen);
        btn_remove_from_cart.setOnClickListener(onClickListen);
        btn_checkout.setOnClickListener(onClickListen);
        btn_card_expired.setOnClickListener(onClickListen);
        btn_page_browse.setOnClickListener(onClickListen);
        btn_profile_update.setOnClickListener(onClickListen);
        btn_opt_in.setOnClickListener(onClickListen);
        btn_opt_out.setOnClickListener(onClickListen);
        btn_custom_data.setOnClickListener(onClickListen);
        btn_other_function.setOnClickListener(onClickListen);
        btn_guid.setOnClickListener(onClickListen);
        btn_get_pn.setOnClickListener(onClickListen);
        btn_logout.setOnClickListener(onClickListen);

    }

    View.OnClickListener onClickListen=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.custome_event:
                    /*-----add to cart----*/
                    JSONObject jsonObject = new JSONObject();
                    JSONObject payload = new JSONObject();
                    try {
                        payload.put("name", "Nexus 5");
                        payload.put("prid", 2);
                        payload.put("price", 15000);
                        payload.put("prqt", 1);
                        jsonObject.put("payload", payload);
                        NetcoreSDK.track(MainActivity.this, "Add To Cart", jsonObject.toString());
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
                case R.id.remove_from_cart:

                    JSONObject jsonObject2 = new JSONObject();
                    JSONObject payload2 = new JSONObject();
                    try {
                        payload2.put("name", "Nexus s");
                        payload2.put("prid", 2);
                        payload2.put("price", 15000);
                        payload2.put("prqt", 1);
                        jsonObject2.put("payload", payload2);
                        NetcoreSDK.track(MainActivity.this, "remove to cart", jsonObject2.toString());
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }


                    break;
                case R.id.checkout:

                    JSONObject jsonObject1 = new JSONObject();
                    JSONObject payload1 = new JSONObject();
                    try {
                        payload1.put("name", "Nexus");
                        payload1.put("prid", 2);
                        payload1.put("price", 15000);
                        payload1.put("prqt", 1);
                        jsonObject1.put("payload", payload1);
                        NetcoreSDK.track(MainActivity.this, "Checkout", jsonObject1.toString());
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }

                    break;
                case R.id.cart_expired:
                    break;
                case R.id.page_browse:
                    break;
                case R.id.profile_update:
                    startActivity(new Intent(MainActivity.this,ProfileUpdateActivity.class));
                    break;
                case R.id.opt_in:
                    break;
                case R.id.opt_out:
                    break;
                case R.id.custom_data:
                    startActivity(new Intent(MainActivity.this,CustomDataActivity.class));
                    break;
                case R.id.other_function:
                    startActivity(new Intent(MainActivity.this,OtherFunctionsActivity.class));
                    break;
                case R.id.get_guid:
                    Utility.showAlert(MainActivity.this,"GUID",NetcoreSDK.getGUID(MainActivity.this));
                    break;
                case R.id.get_notification:
                    startActivity(new Intent(MainActivity.this,ShowNotificationActivity.class));
                    break;
                case R.id.logout:

                    NetcoreSDK.logout(MainActivity.this);
                    NetcoreSDK.clearIdentity(MainActivity.this);

                    break;

            }
        }
    };
}
//    git config --global user.email "you@example.com"
//    git config --global user.name "Your Name"
