package com.example.mobile_app.presentation.activities;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobile_app.R;
import com.example.mobile_app.dataAccess.database.Database;

public class RegisterUser extends AppCompatActivity {

    EditText et_id, et_name, et_password, et_account;
    Database conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        et_id =(EditText)findViewById(R.id.id_user);
        et_name =(EditText)findViewById(R.id.et_RegistroNom);
        et_password=(EditText)findViewById(R.id.et_passRegistro);
        et_account =(EditText)findViewById(R.id.et_NoCuenta);

    }
    public void onClick(View view){
        createUser();
    }

    private void createUser() {
        conexion = new Database(this, "db_users", null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        String id = et_id.getText().toString();
        String name = et_name.getText().toString();
        String password = et_password.getText().toString();
        String account = et_account.getText().toString();

        if (!id.isEmpty() && !name.isEmpty() && !password.isEmpty() && !account.isEmpty()){

            ContentValues values = new ContentValues();
            values.put("idUser", id);
            values.put("nameUser", name);
            values.put("passwordUser", password);
            values.put("accountId", account);

            Long conteo = db.insert("users", "idUser", values);

            Toast.makeText(this, "Registro exitoso N°: "+conteo, Toast.LENGTH_LONG).show();
            db.close();

            //limpiar campos de texto
            et_id.setText("");
            et_name.setText("");
            et_password.setText("");
            et_account.setText("");

        }else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}
