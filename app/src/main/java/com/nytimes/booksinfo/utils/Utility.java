package com.nytimes.booksinfo.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class Utility {
    public static OkHttpClient getOkHttpClientClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .build();
        return client;
    }

}
