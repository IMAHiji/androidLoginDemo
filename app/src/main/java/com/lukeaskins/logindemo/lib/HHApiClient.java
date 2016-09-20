package com.lukeaskins.logindemo.lib;

import com.lukeaskins.logindemo.model.UserLoginResponse;
import com.lukeaskins.logindemo.model.UserLoginRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface HHApiClient {

    public static final String URL_BASE = "https://fierce-island-9273.herokuapp.com/";
    public static final String URL_SIGN_IN = "users/sign_in";


    //USER ACTIONS
    @POST(URL_SIGN_IN)
    Call<UserLoginResponse> signIn(@Body UserLoginRequest userLoginRequest);
}
