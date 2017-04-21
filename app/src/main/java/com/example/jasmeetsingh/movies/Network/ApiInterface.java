package com.example.jasmeetsingh.movies.Network;

import com.example.jasmeetsingh.movies.MoviesDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by jasmeetsingh on 30/03/17.
 */

public interface ApiInterface {
    @GET("movie/popular")
    Call<MovieResponse> getPopularMovie(@Query("api_key") String apiKey,@Query("page") int page);
    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovie(@Query("api_key") String apiKey,@Query("page") int page);
    @GET("movie/upcoming")
    Call<MovieResponse> getUpcomingMovie(@Query("api_key") String apiKey,@Query("page") int page);
    @GET("movie/now_playing")
    Call<MovieResponse> getNowPlayingMovie(@Query("api_key") String apiKey,@Query("page") int page);
    @GET("movie/{movie_id}")
    Call<MovieResponse> getMovieDetails(@Path("movie_id") int movieId,@Query("api_key") String apiKey);
    @GET("movie/{movie_id}/credits")
    Call<MovieResponse> getMovieCast(@Path("movie_id") int movieId,@Query("api_key") String apiKey);
    @GET("movie/{movie_id}/reviews")
    Call<MovieResponse> getMovieReviews(@Path("movie_id") int movieId,@Query("api_key") String apiKey);
    @GET("movie/{movie_id}")
    Call<MovieResponse> getSimilarMovie(@Path("movie_id") int movieId,@Query("api_key") String apiKey);
    @GET("movie/{movie_id}/videos")
    Call<MovieResponse> getMovieTrailors(@Path("movie_id") int movieId,@Query("api_key") String apiKey);


}
