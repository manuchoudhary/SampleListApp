package com.example.samplelistapp.main_activity;

import android.util.Log;

import com.example.samplelistapp.model.Movie;
import com.example.samplelistapp.model.MovieList;
import com.example.samplelistapp.my_interface.GetMovieDataService;
import com.example.samplelistapp.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetMovieInteractorImpl implements MainContract.GetMovieIntractor {

    private static final String APP_KEY = "b7cd3340a794e5a2f35e3abb820b497f";

    @Override
    public void getMovieArrayList(final OnFinishedListener onFinishedListener) {
        /** Create handle for the RetrofitInstance interface*/
        GetMovieDataService service = RetrofitInstance.getRetrofitInstance().create(GetMovieDataService.class);

        /** Call the method with parameter in the interface to get the place data*/
        Call<MovieList> call = service.getPlaceData(APP_KEY);

        /**Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");
        Log.d("URL Called========", call.request().url() + "");

        call.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                onFinishedListener.onFinished(response.body().getMovieList());

            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }
}
