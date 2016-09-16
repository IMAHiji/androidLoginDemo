package com.lukeaskins.logindemo;

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

import org.json.JSONException;
import org.w3c.dom.Text;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.username) EditText mUsername;
    @BindView(R.id.password) EditText mPassword;
    @BindView(R.id.buttonLogin) Button mButtonLogin;
    @BindView(R.id.registerLink) TextView mRegisterLink;

    private static final String TAG = "LOGIN_ACTIVITY";
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
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
                Log.v(TAG, "LOGIN BUTTON CLICKED");
                login();
            }
        });

    }


    public void login() {
        Log.d(TAG, "LOGIN REQUESTED");
        String baseUrl = "https://fierce-island-9273.herokuapp.com/users/sign_in";
        Context context = this.getApplicationContext();
        String email = mUsername.getText().toString();
        String password = mPassword.getText().toString();






        //Check for network availability
        if(isNetworkAvailable()){

            //If available, Perform Login Request
            OkHttpClient client = new OkHttpClient();
            String payload = loginJSON(email, password);
            Log.v(TAG, "Network Available Beginning Request build with " + payload);
            RequestBody body = RequestBody.create(JSON, payload);

            Request request = new Request.Builder().url(baseUrl).post(body).build();
            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    //Do something with a failure
                    Log.v(TAG, "FAILIURE", e);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    //Do something with the response data
                    try {
                        String jsonData = response.body().string();
                        Headers responseHeaders = response.headers();



//                        Log.v(TAG, "Response  --> BODY" + jsonData);
                        Log.v(TAG, "Response  --> ACCESS TOKEN : " + response.header("Access-Token"));
                        if (response.isSuccessful()) {
                            Log.v(TAG, "SUCCESSFUL RESPONSE");
                        }
                        else{
                            Log.v(TAG, "Unsuccessful Response");
                        }
                    }
                    catch (IOException e){
                        Log.e(TAG, "IO Exception Caught", e);
                    }
                }
            });
        }else{
            //If not available, Toast a message to the user indicating lack of network availability
            Toast.makeText(this, "NETWORK IS UNAVAILABLE", Toast.LENGTH_LONG).show();
        }


        //Catch errors

        //
    }

    String loginJSON(String userName, String password){
        return "{\"email\": \"" + userName + "\", \"password\":\"" + password +"\"}";

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


}
