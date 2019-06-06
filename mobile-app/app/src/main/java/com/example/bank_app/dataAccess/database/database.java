package com.example.bank_app.DataAccess.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bank_app.DataAccess.models.user;
import com.example.bank_app.DataAccess.models.userDao;


@Database(entities= user.class, version=1)
public abstract class database extends RoomDatabase {
    private static final String DB_NAME= "user_db";
    private static database instance;

    public static synchronized database getInstance(Context context) {
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(), database.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract userDao userDAO();


}

/*
public class Database extends SQLiteOpenHelper {
    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(code int primary key, user text, password text)");
        db.execSQL("insert into users values(01,'admin', 'admin')");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("create table users(code int primary key, user text, password text)");
        db.execSQL("insert into users values(01,'admin', 'admin')");


    }
}
*/