package com.example.mobile_app.dataAccess.models;

import java.io.Serializable;

public class Account implements Serializable {

    private Integer id;
    private Integer balance;
    private Integer userId;

    public Account(Integer id, Integer balance, Integer userId) {
        this.id = id;
        this.balance = balance;
        this.userId = userId;
    }

    public Account() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
