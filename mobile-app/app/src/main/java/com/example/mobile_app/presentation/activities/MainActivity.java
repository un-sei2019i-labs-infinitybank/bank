package com.example.mobile_app.presentation.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mobile_app.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClick(View view) {
        Intent miIntent = null;
        switch (view.getId()) {
            case R.id.btn_admin:
                miIntent = new Intent(this, LoginAdmin.class);
                break;
            case R.id.btn_user:
                miIntent = new Intent(this, LoginUser.class);
                break;

        }
        if (miIntent != null) {
            startActivity(miIntent);
        }
    }
}
