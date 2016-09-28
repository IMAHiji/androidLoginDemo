package com.lukeaskins.logindemo;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class LoginApplication extends Application {
    public static SharedPreferences prefs;
//    public static LoginApiClient apiClient;

    @Override
    public void onCreate(){
        super.onCreate();

        Context context = this.getApplicationContext();

    }


}
