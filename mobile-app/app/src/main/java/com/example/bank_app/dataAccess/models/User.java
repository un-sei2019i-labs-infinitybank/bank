package com.example.bank_app.dataAccess.models;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;


@Entity(tableName="usuario")
public class User {

    //User usuario = new User();
    @PrimaryKey
    @NonNull
    private int id;
    @NonNull
    @ColumnInfo(name="name")
    private String mName;
    @NonNull
    @ColumnInfo(name="account")
    private String mAccount;
    @NonNull
    @ColumnInfo(name="password")
    private String mPassword;
    @NonNull
    @ColumnInfo(name="balance")
    private long mBalance;

    public User(){

    }

    public User(int id, String name, String account, String password, long balance){
        this.id=id;
        this.mName=name;
        this.mAccount=account;
        this.mPassword=password;
        this.mBalance=balance;
    }



    @NonNull
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @NonNull
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }
    @NonNull
    public String getAccount() {
        return mAccount;
    }

    public void setAccount(String account) {
        this.mAccount = account;
    }
    @NonNull
    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        this.mPassword = password;
    }
    @NonNull
    public long getBalance() {
        return mBalance;
    }

    public void setBalance(long balance) {
        this.mBalance = balance;
    }
}
