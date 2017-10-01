package com.example.mariam.moviedb;

/**
 * Created by Domtyyyyyy on 8/13/2017.
 */

public class Movie {
    String title, overview, vote_average, poster_path;


    public Movie(String movieName, String moviePoster, String movieRate, String movieStory) {
        this.title = movieName;
        this.poster_path = moviePoster;
        this.vote_average = movieRate;
        this.overview = movieStory;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getVote_average() {
        return vote_average;
    }

    public String getPoster_path() {
        String photo = "https://image.tmdb.org/t/p/w342" + poster_path + "?" + "api_key=" +"3ced090e6c0a7e8515a161d9eff34d5c";
        return photo;
    }
}
