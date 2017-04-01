package com.example.jasmeetsingh.movies.Network;

import com.example.jasmeetsingh.movies.MoviesDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jasmeetsingh on 30/03/17.
 */

public interface ApiInterface {
    @GET("movie/popular")
    Call<MovieResponse> getMovieDetails(@Query("api_key") String apiKey);
}
