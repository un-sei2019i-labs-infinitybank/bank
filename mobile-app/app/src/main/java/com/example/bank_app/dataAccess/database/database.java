package com.example.bank_app.dataAccess.database;

import com.example.bank_app.dataAccess.models.Account;
import com.example.bank_app.dataAccess.models.AccountDao;
import com.example.bank_app.dataAccess.models.User;
import com.example.bank_app.dataAccess.models.userDao;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



@Database(entities= {User.class, Account.class}, version=1)
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

    public abstract userDao getuserDAO();
    public abstract AccountDao getAccountDAO();
    //public abstract userDao userDAO();

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