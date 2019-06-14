package com.example.mobile_app.dataAccess.models;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable {

    private Integer id;
    private Integer sourceAccountId;
    private Integer targetAccountId;
    private Date date;

    public Transaction(Integer id, Integer sourceAccountId, Integer targetAccountId, Date date) {
        this.id = id;
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.date = date;
    }

    public Transaction() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(Integer sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public Integer getTargetAccountId() {
        return targetAccountId;
    }

    public void setTargetAccountId(Integer targetAccountId) {
        this.targetAccountId = targetAccountId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
