package com.gweiland.Retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    Retrofit retrofit;
    public static String BASE_URL = "https://sandbox-api.coinmarketcap.com";


    private static RetrofitClient mClient;

    private RetrofitClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


         retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

    }
    public static synchronized RetrofitClient getmClient() {
        if (mClient == null) {
            mClient = new RetrofitClient();
        }
        return mClient;

    }

    public Api getApi() {
        return retrofit.create(Api.class);
    }
}
