package com.example.samplelistapp.my_interface;

import com.example.samplelistapp.model.MovieList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetMovieDataService {

    @GET("upcoming?")
    Call<MovieList> getPlaceData(@Query("api_key") String appId);
}
