package com.example.application.api;

import com.example.application.model.CategoryList;
import com.example.application.model.StoreList;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;

public interface ApiRequestData {
    /* @GET("users")
     Call<List<StoreList>> getstore();
 */
    @Headers({"APIKEY: bd_suvlascentralpos"})
    @GET("index.php?r=configuraciones/franquicias")
    Call<StoreList> getAllStore();

    @GET("index.php?r=menu")
    Call<CategoryList> getAllMenubyCahegorywise(@Header("APIKEY") String contentType);

}
