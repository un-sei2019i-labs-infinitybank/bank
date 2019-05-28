package com.example.bank_app;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainIndex extends AppCompatActivity {

    private EditText et_code, et_user, et_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_index);

        et_code = (EditText)findViewById(R.id.txt_codigo);
        et_user = (EditText)findViewById(R.id.txt_userName);
        et_password = (EditText)findViewById(R.id.txt_passR);
    }

    public void Registrar(View view){
        AdminSQLite admin = new AdminSQLite(this, "gerence", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String code = et_code.getText().toString();
        String user = et_user.getText().toString();
        String password = et_password.getText().toString();

        ContentValues values = new ContentValues();
        values.put("code",code);
        values.put("user",user);
        values.put("password", password);

        db.insert("users",null,values);
        db.close();

        Intent ven = new Intent(this, MainActivity.class);
        startActivity(ven);

        Toast.makeText(this, "registro exitoso", Toast.LENGTH_SHORT).show();
    }
    public void Cancelar(View view){
        finish();
    }
}
