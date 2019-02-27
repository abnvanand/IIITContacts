package com.example.iiitcontacts.network;

import com.example.iiitcontacts.network.interceptors.LoggingInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class OkHttp {
    private static OkHttpClient client;

    private OkHttp() {
    }

    public static OkHttpClient getInstance() {
        if (client == null) {
            client = new OkHttpClient.Builder()
                    .addInterceptor(new LoggingInterceptor())
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build();
        }
        return client;
    }
}
