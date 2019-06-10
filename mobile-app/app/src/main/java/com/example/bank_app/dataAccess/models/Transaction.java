package com.example.bank_app.dataAccess.models;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Account.class,
        parentColumns = "id",
        childColumns = "account_id", onDelete = CASCADE))

public class Transaction {

    @PrimaryKey
    private int id;
    private String date;

    private int account_id;


    public Transaction(int id, String date, int account_id) {
        this.id = id;
        this.date = date;
        this.account_id=account_id;
    }

    /*
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

*/

}
