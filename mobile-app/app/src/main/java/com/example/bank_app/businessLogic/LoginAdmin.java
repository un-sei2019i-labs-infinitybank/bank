package com.example.bank_app.businessLogic;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

<<<<<<< HEAD
import com.example.bank_app.DataAccess.database.Database;
=======
import com.example.bank_app.DataAccess.database.AdminSQLite;
>>>>>>> 378c1852c1748abfc6df2220604f14cf8edc540e
import com.example.bank_app.R;

public class LoginAdmin extends AppCompatActivity {

    private EditText et_user, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        et_user =(EditText)findViewById(R.id.txt_admin);
        et_password =(EditText)findViewById(R.id.txt_passA);
    }

    //metodo login de usuario

    public void Ingresar(View view){

        Database admin = new Database(this, "gerence", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String user = et_user.getText().toString();
        String password = et_password.getText().toString();

        Cursor fila = db.rawQuery
                ("select user, password from users where user='" + user + "'and password='" + password+"'",null);


        if(fila.moveToFirst()){

            String usua=fila.getString(0);
            String pass=fila.getString(1);

            if(user.equals(usua) && password.equals(pass)){
                Intent ven = new Intent(this, RegisterUser.class);
                startActivity(ven);

                et_user.setText("");
                et_password.setText("");
            }

        }else{
            Toast.makeText(this,"Administrador no registrado", Toast.LENGTH_SHORT).show();
        }


    }
}
