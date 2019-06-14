package com.example.mobile_app.dataAccess.models;

import java.io.Serializable;

public class User implements Serializable {

    private Integer id;
    private String name;
    private String password;
    private Integer accountId;

    public User(Integer id, String name, String password, Integer accountId) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.accountId = accountId;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
