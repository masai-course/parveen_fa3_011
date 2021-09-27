package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiiService {

    @GET("posts/{input}")
    Call<ResponseModel> fetchData(@Path("input") int input);
}
