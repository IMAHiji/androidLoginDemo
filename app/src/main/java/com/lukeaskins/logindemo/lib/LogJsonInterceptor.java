package com.lukeaskins.logindemo.lib;

import android.support.compat.BuildConfig;
import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class LogJsonInterceptor implements Interceptor {
    private static final String TAG = "JSON INTERCEPTOR ACTIVITY";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Response response = chain.proceed(request);
        String rawJson = response.body().string();

        Log.d(BuildConfig.APPLICATION_ID, String.format("raw JSON response is: %s", rawJson));

        return response.newBuilder()
                .body(ResponseBody.create(response.body().contentType(), rawJson)).build();
    }
}
