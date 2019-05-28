package com.example.bank_app;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
