package com.example.bank_app.dataAccess.models;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.bank_app.dataAccess.models.User;

import java.util.List;

@Dao
public interface userDao {

    @Query("Select * from usuario")
    List<User> getUserList();
    @Insert
    void insertUser(User usuario);
    @Update
    void updateUser(User usuario);
    @Delete
    void deleteUser(User usuario);

}
