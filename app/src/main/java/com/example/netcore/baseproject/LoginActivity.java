package com.example.netcore.baseproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    }

    View.OnClickListener onClickListen = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_login:
                    if (!edit_email.getText().toString().trim().equals("")) {

                        if (Patterns.EMAIL_ADDRESS.matcher(edit_email.getText().toString()).matches()) {
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
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
