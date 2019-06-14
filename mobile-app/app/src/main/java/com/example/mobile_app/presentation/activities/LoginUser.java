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
import com.example.mobile_app.dataAccess.models.User;

public class LoginUser extends AppCompatActivity {

    EditText et_user, et_password;
    Database conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        et_user =(EditText)findViewById(R.id.userName);
        et_password =(EditText)findViewById(R.id.userPass);
    }

    public void signIn(View view){
        conexion = new Database(this, "db_users", null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        String user = et_user.getText().toString();
        String password = et_password.getText().toString();

        Cursor cursor = db.rawQuery
                ("select nameUser, passwordUser from users where nameUser='" +user+ "'and passwordUser='" +password+"'",null);

        if(cursor.moveToFirst()){

            String usua = cursor.getString(0);
            String pass = cursor.getString(1);

            if(user.equals(usua) && password.equals(pass)){
                Intent intent = new Intent(this, UserManager.class);
                startActivity(intent);

                et_user.setText("");
                et_password.setText("");
            }

        }else{
            Toast.makeText(this,"Usuario no registrado", Toast.LENGTH_SHORT).show();
            et_user.setText("");
            et_password.setText("");
        }

    }
}
