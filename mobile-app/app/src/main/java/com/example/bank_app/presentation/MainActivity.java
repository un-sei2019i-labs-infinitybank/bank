package com.example.bank_app.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.bank_app.businessLogic.LoginAdmin;
import com.example.bank_app.businessLogic.LoginUser;
import com.example.bank_app.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //eleccion de usuario


    public void IngresoAdmin(View view){
        Intent ven = new Intent(this, LoginAdmin.class);
        startActivity(ven);
    }

    public  void IngresarUsuario(View view){
        Intent ven = new Intent(this, LoginUser.class);
        startActivity(ven);
    }
}
