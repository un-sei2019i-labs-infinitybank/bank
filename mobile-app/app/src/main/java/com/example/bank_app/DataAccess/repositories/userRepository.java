package com.example.bank_app.DataAccess.repositories;

import com.example.bank_app.DataAccess.models.user;

public class userRepository extends user{

    user usuario;

    public void createUser(){
        usuario = new user();
    }
    public void getUserById(){
        usuario.getId();
    }
    public void  updateUser(){

    }
    public void deleteUser(){

    }
}
