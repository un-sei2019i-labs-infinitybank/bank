package com.example.mobile_app.presentation.activities;

import android.content.ContentValues;
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

public class SearchUser extends AppCompatActivity {

    EditText et_id, et_name, et_password, et_account;
    Database conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);

        et_id = (EditText) findViewById(R.id.su_id);
        et_name = (EditText) findViewById(R.id.su_name);
        et_password = (EditText) findViewById(R.id.su_password);
        et_account = (EditText) findViewById(R.id.su_account);

        conexion = new Database(this, "db_users", null, 1);
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.su_buscar:
                consultar();
                break;
            case R.id.su_update:
                actualizarUsuario();
                break;
            case R.id.su_delete:
                eliminar();
                break;
            case R.id.su_ir_registro:
                Intent miIntent = new Intent(this, RegisterUser.class);
                startActivity(miIntent);
                finish();
                break;
        }
    }


    private void consultar() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        String id = et_id.getText().toString();

        if (!id.isEmpty()){

            try {

                Cursor cursor = db.rawQuery("select nameUser, passwordUser, accountId from users where idUser = " +
                        id, null);

                cursor.moveToFirst();
                et_name.setText(cursor.getString(0));
                et_password.setText(cursor.getString(1));
                et_account.setText(cursor.getString(2));
                cursor.close();

            }catch (Exception e){
                Toast.makeText(this, "El Id no existe", Toast.LENGTH_SHORT).show();
                limpiar();
            }
            db.close();

        }else {
            Toast.makeText(this, "Debes ingresar el Id", Toast.LENGTH_SHORT).show();
        }
    }


    private void actualizarUsuario() {

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

            int cantidad = db.update("users", values, "idUser =" +id, null);
            db.close();

            if (cantidad == 1){
                Toast.makeText(this, "actualizacion satisfactoria", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "El usuario no existe", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }


    private void eliminar() {
        SQLiteDatabase db = conexion.getWritableDatabase();

        String id = et_id.getText().toString();

        if (!id.isEmpty()){

            int borrado = db.delete("users", "idUser ="+ id,null);
            db.close();

            if (borrado == 1){

                Toast.makeText(this, "usuario eliminado", Toast.LENGTH_SHORT).show();

                et_id.setText("");
                limpiar();

            }else{
                Toast.makeText(this, "el usuario no existe", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "debes ingresar la identificacion", Toast.LENGTH_SHORT).show();
        }


    }


    private void limpiar() {

        et_name.setText("");
        et_password.setText("");
        et_account.setText("");
    }

}