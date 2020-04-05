package com.example.myapplication8;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String Base_URL = "http://172.105.84.77:1234/";

    @GET("region")
    Call<List<Region>> getRegions();

    @GET("cities")
    Call<List<Cities>> getCities();


}
