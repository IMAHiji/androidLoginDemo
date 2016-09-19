package com.lukeaskins.logindemo.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class Login {
    @SerializedName("email")
    String email;
    @SerializedName("password")
    String password;

    public Login(String email, String password){
        this.email = email;
        this.password = password;
    }
}
