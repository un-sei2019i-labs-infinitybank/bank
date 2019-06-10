package com.example.bank_app.dataAccess.models;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;
@Dao
public interface AccountDao {

    @Insert
    void insert(Account account);

    @Update
    void update(Account account);

    @Delete
    void delete(Account account);
    @Query("SELECT * FROM account")
    List<Account> getAllAccounts();

    @Query("SELECT * FROM account WHERE user_id=:user_id")
    List<Account> findRepositoriesForUser(int user_id);

}
