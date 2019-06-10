package com.example.bank_app.presentation;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bank_app.dataAccess.database.database;
import com.example.bank_app.dataAccess.models.userDao;

import com.example.bank_app.R;

public class LoginUser extends AppCompatActivity {

    private EditText et_user, et_password;
    private userDao useDao;
    public static database mydatabase;

    //private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        mydatabase= Room.databaseBuilder(getApplicationContext(),database.class, "user_db").build();

        et_user =(EditText)findViewById(R.id.txt_user);
        et_password =(EditText)findViewById(R.id.txt_pass);
    }

    public LoginUser(Application application){
        //super(application);

        //admin = database.getDatabase(application);

    }


    //metodo login de usuario
/*
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
                Intent ven = new Intent(this, UserPlataform.class);
                startActivity(ven);

                et_user.setText("");
                et_password.setText("");
            }

        }else{
            Toast.makeText(this,"Usuario no registrado", Toast.LENGTH_SHORT).show();
        }


    }*/
}

