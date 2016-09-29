package com.lukeaskins.logindemo;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lukeaskins.logindemo.lib.HHApiClient;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginApplication extends Application {
    public static SharedPreferences prefs;
    public static HHApiClient apiClient;
    public static Retrofit retrofit;
    public static HttpLoggingInterceptor httpLogger = new HttpLoggingInterceptor();


    public static final String URL_BASE = "https://fierce-island-9273.herokuapp.com/";

    @Override
    public void onCreate(){
        super.onCreate();

        Context context = this.getApplicationContext();

    }

    public static HHApiClient getApiClient(){
        if(apiClient == null){

            httpLogger.setLevel(HttpLoggingInterceptor.Level.HEADERS);

            OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder();
            httpClient.addInterceptor(httpLogger);

            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
            apiClient = retrofit.create(HHApiClient.class);

        }
        return apiClient;
    }

}
