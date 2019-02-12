package com.example.netcore.baseproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                    break;
                case R.id.remove_from_cart:
                    break;
                case R.id.checkout:
                    break;
                case R.id.cart_expired:
                    break;
                case R.id.page_browse:
                    break;
                case R.id.profile_update:
                    break;
                case R.id.opt_in:
                    break;
                case R.id.opt_out:
                    break;
                case R.id.custom_data:
                    break;
                case R.id.other_function:
                    break;
                case R.id.get_guid:
                    break;
                case R.id.get_notification:
                    break;
                case R.id.logout:
                    break;

            }
        }
    };
}
//    git config --global user.email "you@example.com"
//    git config --global user.name "Your Name"
