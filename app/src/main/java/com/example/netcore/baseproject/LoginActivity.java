package com.example.netcore.baseproject;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import in.netcore.smartechfcm.NetcoreSDK;

public class LoginActivity extends AppCompatActivity {

    Button btn_login, btn_skip;
    EditText edit_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_login = findViewById(R.id.btn_login);
        btn_skip = findViewById(R.id.btn_skip);
        edit_email=findViewById(R.id.ed_email);

        btn_login.setOnClickListener(onClickListen);
        btn_skip.setOnClickListener(onClickListen);

        try {
            Bundle bundle = getIntent().getExtras();
            if(bundle!=null)
                for (String key : bundle.keySet()) {
                    Log.e("", key+" : "+bundle.get("customPayload").toString());
                    JSONObject jsonObject = new JSONObject(bundle.getString(key));
                    Toast.makeText(LoginActivity.this,jsonObject.toString()+" : "+bundle.get(key).toString(),Toast.LENGTH_LONG).show();
                }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    View.OnClickListener onClickListen = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_login:
                    if (!edit_email.getText().toString().trim().equals("")) {

                        if (Patterns.EMAIL_ADDRESS.matcher(edit_email.getText().toString()).matches()) {



                            NetcoreSDK.setIdentity(LoginActivity.this,edit_email.getText().toString());
                            NetcoreSDK.login(LoginActivity.this);
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));

                           // NetcoreSDK.setIdentity(LoginActivity.this,edit_email.getText().toString());
                            //NetcoreSDK.login(LoginActivity.this);

                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "Please enter correct email id", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(LoginActivity.this, " email is mandatory ", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btn_skip:
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                    break;


            }
        }

    };
}
