package com.lukeaskins.logindemo.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lukeaskins.logindemo.LoginApplication;
import com.lukeaskins.logindemo.R;
import com.lukeaskins.logindemo.RegisterActivity;
import com.lukeaskins.logindemo.lib.HHApiClient;
import com.lukeaskins.logindemo.model.response.UserLoginResponse;
import com.lukeaskins.logindemo.model.request.UserLoginRequest;
import com.lukeaskins.logindemo.user.User;

import butterknife.BindView;
import butterknife.ButterKnife;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.lukeaskins.logindemo.LoginApplication.getApiClient;


public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.username) EditText mUsername;
    @BindView(R.id.password) EditText mPassword;
    @BindView(R.id.buttonLogin) Button mButtonLogin;
    @BindView(R.id.registerLink) TextView mRegisterLink;

    private static final String TAG = "LOGIN_ACTIVITY";
    public static final String URL_SIGN_IN = "users/sign_in";
    public static final String URL_BASE = "https://fierce-island-9273.herokuapp.com/";


    public static SharedPreferences prefs;
    public String ACCESS_TOKEN;

    public User user = new User();
    private String sessionEmail;
    private String sessionPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);




        mRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "LOGIN BUTTON CLICKED");
                login();
            }
        });
    }


    public void login() {
        Log.d(TAG, "LOGIN REQUESTED");
        //Check if Empty
        if (isEmpty(mUsername) || isEmpty(mPassword)) {
            //If either one is empty, Tell user to enter text
            Toast.makeText(this, "Please enter your username and pasword", Toast.LENGTH_LONG).show();
        } else {
            Log.d(TAG, "LOGIN Begins");
            String email = mUsername.getText().toString();
            String password = mPassword.getText().toString();



            //Check for network availability
            if(isNetworkAvailable()){
                //If available, Perform Login Request


                //Generate a login from the input data
                UserLoginRequest userLoginRequest = new UserLoginRequest();
                userLoginRequest.setEmail(email);
                userLoginRequest.setPassword(password);


                HHApiClient service = LoginApplication.getApiClient();

                //Call your service with Retrofit: Call<your expected response class> = service.[whatever_you_named_your_endpoint_in_the_interface]
                Call<UserLoginResponse> userLoginResponseCall =  service.signIn(userLoginRequest);
                userLoginResponseCall.enqueue(new Callback<UserLoginResponse>() {
                    @Override
                    public void onResponse(Call<UserLoginResponse> call, Response<UserLoginResponse> response) {

                        Headers headers = response.headers();
                        UserLoginResponse userLoginResponse = response.body();
                        processHeaders(headers);

                        Intent userIntent = new Intent(LoginActivity.this, UserActivity.class);
                        userIntent.putExtra("users", serializeBooty(userLoginResponse));
                        LoginActivity.this.startActivity(userIntent);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<UserLoginResponse> call, Throwable t) {
                        Log.d(TAG, "FAILURE  ----> " + t.getMessage());
                    }
                });
            }else{
                //If not available, Toast a message to the user indicating lack of network availability
                Toast.makeText(this, "NETWORK IS UNAVAILABLE", Toast.LENGTH_LONG).show();
            }
        }




        //Catch errors
    }

    private boolean isNetworkAvailable() {

        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        boolean isAvailable = false;

        if(networkInfo != null && networkInfo.isConnected()){
            isAvailable = true;
        }
        return isAvailable;
    }

    private boolean isEmpty (EditText checkText){
        Log.d(TAG, "Checking Length for text in field " );
        if(checkText.getText().toString().trim().length() == 0){
            Log.d(TAG, "EMPTY FIELD" );
            return true;
        }else{
            return false;
        }
    }

    public String serializeBooty(UserLoginResponse userLoginResponse){
        Gson gson = new Gson();
        String s = gson.toJson(userLoginResponse);
        return s;
    }

    public void processHeaders(Headers headers){
        String token = headers.get("Access-Token");
        String tokenType = headers.get("Token-Type");
        String client = headers.get("Client");
        String expiry = headers.get("Expiry");
        String uid = headers.get("Uid");

        SharedPreferences.Editor editor = getSharedPreferences(ACCESS_TOKEN, Context.MODE_PRIVATE).edit();
        editor.putString("Access-Token", token);
        editor.putString("Token-Type", tokenType);
        editor.putString("Client", client);
        editor.putString("Expiry", expiry);
        editor.putString("Uid", uid);
        editor.apply();
        Log.d(TAG, "Access-Token Saved: " + token);
        Log.d(TAG, "Token-TYPE Saved: " + tokenType);
        Log.d(TAG, "Client Saved: " + client);
        Log.d(TAG, "Expiry Saved: " + expiry);
        Log.d(TAG, "Uid Saved: " + uid);
    }

}
