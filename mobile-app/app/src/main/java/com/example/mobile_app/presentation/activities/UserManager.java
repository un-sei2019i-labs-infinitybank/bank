package com.example.mobile_app.presentation.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mobile_app.R;

public class UserManager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_manager);
    }

    public void onClick(View view) {
        Intent miIntent = null;
        switch (view.getId()) {
            case R.id.btn_regUser:
                miIntent = new Intent(this, RegisterUser.class);
                break;
            case R.id.btn_consUser:
                miIntent = new Intent(this, SearchUser.class);
                break;


        }
        if (miIntent != null) {
            startActivity(miIntent);
        }
    }
}
