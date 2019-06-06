package com.example.bank_app.DataAccess.models;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface userDao {

    @Query("Select * from usuario")
    List<user> getuserList();
    @Insert
    void insertuser(user usuario);
    @Update
    void updateuser(user usuario);
    @Delete
    void deleteuser(user usuario);

}
