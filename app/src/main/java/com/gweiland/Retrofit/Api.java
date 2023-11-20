package com.gweiland.Retrofit;

import com.gweiland.Model.CoinInfoResponse;
import com.gweiland.Model.Data_Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface Api {



    @GET("v1/cryptocurrency/listings/latest")
    Call<Data_Response> ListingsLatest(
            @Header("X-CMC_PRO_API_KEY") String auth,
            @Query("start") int start,
            @Query("limit") int limit,
            @Query("sort") String sort
    );

    @GET("v2/cryptocurrency/info")
    Call<CoinInfoResponse>SymbolREsponse(@Header("X-CMC_PRO_API_KEY") String auth,
                                         @Query("id") int id);

}
