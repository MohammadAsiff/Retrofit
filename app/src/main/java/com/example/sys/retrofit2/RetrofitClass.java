package com.example.sys.retrofit2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {
    public static final String ROOT_URL = "http://52.224.222.102:9245/api/";


    private static Retrofit retrofit = null;

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory( GsonConverterFactory.create())
                .build();

    }
    public static ApiService getApiService() {

        return getRetrofitInstance().create(ApiService.class);

    }

}
