package com.example.netcore.baseproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import in.netcore.smartechfcm.NetcoreSDK;

public class ProfileUpdateActivity extends AppCompatActivity {

    EditText ed_name,ed_email,ed_age,ed_mob,ed_dob,ed_salary,ed_site;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_update);
        ed_name=findViewById(R.id.ed_name);
        ed_email=findViewById(R.id.ed_email);
        ed_age=findViewById(R.id.ed_age);
        ed_mob=findViewById(R.id.ed_mobile);
        ed_dob=findViewById(R.id.ed_dob);
        ed_salary=findViewById(R.id.ed_salary);
        ed_site=findViewById(R.id.ed_site);

        btn_submit=findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        JSONObject profile = new JSONObject();
                try {
                    profile.put("NAME", ed_name.getText().toString());
                    profile.put("AGE", ed_age.getText().toString());
                    profile.put("MOBILE", ed_mob.getText().toString());
                    profile.put("EMAIL",ed_email.getText().toString());
                    profile.put("DOB",ed_dob.getText().toString());
                    profile.put("SALARY",ed_salary.getText().toString());
                    profile.put("WEBSITE",ed_site.getText().toString());
                    NetcoreSDK.profile(ProfileUpdateActivity.this, profile);
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });




    }
}
