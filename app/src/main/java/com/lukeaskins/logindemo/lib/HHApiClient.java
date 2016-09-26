package com.lukeaskins.logindemo.lib;

import com.lukeaskins.logindemo.model.response.UserLoginResponse;
import com.lukeaskins.logindemo.model.request.UserLoginRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface HHApiClient {




    public static final String URL_BASE = "https://fierce-island-9273.herokuapp.com/";
    public static final String URL_SIGN_IN = "users/sign_in";
    public static final String URL_VALIDATE_TOKEN = "users/validate_token";


    //USER ACTIONS
    @POST(URL_SIGN_IN)
    Call<UserLoginResponse> signIn(@Body UserLoginRequest userLoginRequest);

    @GET(URL_VALIDATE_TOKEN)
    Call<UserLoginResponse> validateToken(
            @Header("access-token") String token,
            @Header("token-type") String tokenType,
            @Header("Client") String clientId,
            @Header("expiry") String expiry,
            @Header("uid") String uid );
}
