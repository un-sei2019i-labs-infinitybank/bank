package com.example.bank_app.DataAccess.models;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;


@Entity(tableName="usuario")
public class user {

    //user usuario = new user();
    @PrimaryKey
    @NonNull
    private int id;
    @ColumnInfo(name="name")
    private String name;
    @ColumnInfo(name="account")
    private String account;
    @ColumnInfo(name="password")
    private String password;
    @ColumnInfo(name="balance")
    private long balance;

    public user(int id, String name, String account, String password, long balance){
        this.id=id;
        this.name=name;
        this.account=account;
        this.password=password;
        this.balance=balance;
    }

    @NonNull

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
