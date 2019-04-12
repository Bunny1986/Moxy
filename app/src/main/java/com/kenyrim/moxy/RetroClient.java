package com.kenyrim.moxy;

import com.kenyrim.moxy.service.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {


    private static final String URL = "https://prnk.blob.core.windows.net/tmp/";

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }
}
