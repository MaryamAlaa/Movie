package com.example.mariam.moviedb;

import com.example.mariam.moviedb.MainActivity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Domtyyyyyy on 8/14/2017.
 */

    public interface MoviesApi {
        @GET("movie")
        Call<MainActivity.MovieModel> getMovies(@Query("sort_by") String sort, @Query("api_key") String api_key);
    }

