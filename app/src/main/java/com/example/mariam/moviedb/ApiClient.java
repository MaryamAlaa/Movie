package com.example.mariam.moviedb;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Domtyyyyyy on 8/14/2017.
 */

public class ApiClient {
    private static Retrofit instance;

    private ApiClient() {
    }

    public static Retrofit getInstance() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/discover/")
                //   .addCallAdapterFactory(Rx)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }


    public static Call<MainActivity.MovieModel> getMovieModel(String sort, String apiKey) {
        return getInstance().create(MoviesApi.class)
                .getMovies(sort, apiKey);
    }
}
