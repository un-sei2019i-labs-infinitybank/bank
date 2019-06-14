package com.example.mobile_app.dataAccess.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //creacion de tablas
        //db.execSQL("insert into users values(01,'admin', 'admin')");

        db.execSQL("create table admins(idAdmin Integer primary key, nameAdmin text, passwordAdmin)");
        db.execSQL("insert into admins values(1,'admin', 'admin')");

        db.execSQL("create table users(idUser Integer, nameUser text, passwordUser text, accountId Integer)");
        //db.execSQL("insert into users values(1,'user', 'user', 1235)");

        db.execSQL("create table accounts(idAccount Integer primary key, balance Integer, userId)");
        db.execSQL("create table transactions(idTransantion Integer primary key, sourceAccountId Integer, targetAccountId Integer, Date date)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists users");
        db.execSQL("drop table if exists accounts");
        db.execSQL("drop table if exists transactions");

        onCreate(db);

    }
}
