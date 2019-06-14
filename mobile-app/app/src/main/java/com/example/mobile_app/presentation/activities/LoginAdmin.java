package com.example.mobile_app.presentation.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobile_app.R;
import com.example.mobile_app.dataAccess.database.Database;

public class LoginAdmin extends AppCompatActivity {

    EditText et_admin, et_password;
    Database conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        et_admin = (EditText)findViewById(R.id.adminName);
        et_password = (EditText)findViewById(R.id.adminPass);

        conexion = new Database(this,"db_users", null,1);
    }

    public void signIn(View view){
        SQLiteDatabase db = conexion.getWritableDatabase();

        String admin = et_admin.getText().toString();
        String password = et_password.getText().toString();

        Cursor cursor = db.rawQuery
                ("select nameAdmin, passwordAdmin from admins where nameAdmin='" +admin+ "'and passwordAdmin='"+password+"'",null);

        if (cursor.moveToFirst()){

            String administrator = cursor.getString(0);
            String pass = cursor.getString(1);

            if (admin.equals(administrator) && password.equals(pass)){

                Intent intent = new Intent(this, UserManager.class);
                startActivity(intent);

                et_admin.setText("");
                et_password.setText("");
            }

        }else{
            Toast.makeText(this,"Datos incorrectos, vuelva a intentar", Toast.LENGTH_SHORT).show();
            et_admin.setText("");
            et_password.setText("");
        }

    }
}
