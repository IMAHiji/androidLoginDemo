package com.lukeaskins.logindemo.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lukeaskins.logindemo.R;
import com.lukeaskins.logindemo.lib.HHApiClient;
import com.lukeaskins.logindemo.model.response.UserLoginResponse;

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

import static android.R.attr.level;
import static com.lukeaskins.logindemo.lib.HHApiClient.URL_BASE;

public class UserActivity extends AppCompatActivity {

    private static final String TAG = "USER_ACTIVITY";
    public String ACCESS_TOKEN;


    @BindView(R.id.userName) TextView userName;
    @BindView(R.id.phoneNumber) TextView phoneNumber;
    @BindView(R.id.validateTokenButton) Button validateToken;
    String mUsername;
    String mPhoneNumber;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
        Intent intent = getIntent();

        final UserLoginResponse deSerializedData = deSerializeBooty(intent.getStringExtra("users"));

        mUsername = deSerializedData.getUsers().getEmail();
        mPhoneNumber = deSerializedData.getUsers().getFirstName();

        userName.setText(mUsername);
        phoneNumber.setText(mPhoneNumber);

        SharedPreferences prefs = getSharedPreferences(ACCESS_TOKEN, MODE_PRIVATE);

        final String token = prefs.getString("Access-Token", null);
        final String tokenType = prefs.getString("Token-Type", null);
        final String client = prefs.getString("Client", null);
        final String expiry = prefs.getString("Expiry", null);
        final String uid = prefs.getString("Uid", null);

        Log.d(TAG, "Access-Token RETRIEVED: " + token);
        Log.d(TAG, "Token-TYPE RETRIEVED: " + tokenType);
        Log.d(TAG, "Client RETRIEVED: " + client);
        Log.d(TAG, "Expiry RETRIEVED: " + expiry);
        Log.d(TAG, "Uid RETRIEVED: " + uid);


        validateToken.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Validate Token With SharedPrefs Clicked  --> " + token);

                HttpLoggingInterceptor logging  = new HttpLoggingInterceptor();
                logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);

                OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder();
                httpClient.addInterceptor(logging);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(URL_BASE)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient.build())
                        .build();
                //Build the service from your API Interface
                HHApiClient service = retrofit.create(HHApiClient.class);
                Call<UserLoginResponse> userLoginResponseCall =  service.validateToken(token, tokenType, client, expiry, uid );
                userLoginResponseCall.enqueue(new Callback<UserLoginResponse>() {
                    @Override
                    public void onResponse(Call<UserLoginResponse> call, Response<UserLoginResponse> response) {
                        int statusCode = response.code();

                        Headers headers = response.headers();

                        okhttp3.Response rawResponse = response.raw();


                        Log.d(TAG, "VALIDATE TOKEN RESPONSE RECEIVED----> " + statusCode);
                        Log.d(TAG, "Body Response----> " + rawResponse);

                    }

                    @Override
                    public void onFailure(Call<UserLoginResponse> call, Throwable t) {
                        Log.d(TAG, "FAILURE  ----> " + t.getMessage());
                    }
                });

            }
        });

    }

    public UserLoginResponse deSerializeBooty(String s){
        Gson gson = new Gson();
        UserLoginResponse deSerializedData = gson.fromJson(s, UserLoginResponse.class);

        return deSerializedData;
    }

}
