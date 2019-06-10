package com.example.bank_app.dataAccess.models;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;
@Dao
public interface TransactionDao {

    @Query("SELECT * FROM [transaction]")
    List<Transaction> getAllTransaction();

    @Query("SELECT * FROM [transaction] WHERE account_id=:account_id")
    List<Transaction> findRepositoriesForUser(int account_id);

    @Insert
    void insert(Transaction transaction);

    @Update
    void update(Transaction transaction);

    @Delete
    void delete(Transaction transaction);

}