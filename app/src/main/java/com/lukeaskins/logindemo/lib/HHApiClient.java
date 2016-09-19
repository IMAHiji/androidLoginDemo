package com.lukeaskins.logindemo.lib;

import android.widget.Button;
import android.widget.EditText;

import com.lukeaskins.logindemo.R;
import com.lukeaskins.logindemo.model.Login;
import com.lukeaskins.logindemo.model.UserLoginRequest;
import com.lukeaskins.logindemo.model.UserLoginResponse;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface HHApiClient {

    public static final String URL_BASE = "https://fierce-island-9273.herokuapp.com/";
    public static final String URL_SIGN_IN = "users/sign_in";


    //USER ACTIONS
    @POST(URL_SIGN_IN)
    Call<UserLoginResponse> signIn(@Body UserLoginRequest userLoginRequest);
}
