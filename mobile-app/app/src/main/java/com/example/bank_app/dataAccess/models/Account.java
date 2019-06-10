package com.example.bank_app.dataAccess.models;

import com.example.bank_app.dataAccess.models.User;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;



@Entity(foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "id",
        childColumns = "user_id", onDelete = CASCADE))

public class Account {

    @PrimaryKey
    private int id;

    private int balance;
    private int user_id;

    public Account(int id, int balance, int user_id){
        this.id=id;
        this.balance=balance;
        this.user_id=user_id;
    }
}
