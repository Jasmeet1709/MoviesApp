package com.example.jasmeetsingh.movies;

import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by jasmeetsingh on 21/04/17.
 */

public class SingleMovieDetail {
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("belongs_to_collection")
    private boolean belongs_to_collection;
    @SerializedName("budget")
    private Integer budget;
    @SerializedName("genres")
    private HashMap<Integer,String> genres;
    @SerializedName("homepage")
    private String homepage;
    @SerializedName("id")
    private Integer id;
    @SerializedName("imdb_id")
    private String imdb_id;
    @SerializedName("original_title")
    private String original_title;
    @SerializedName("overview")
    private String overview;
    @SerializedName("popularity")
    private Double popularity;
    @SerializedName("poster_path")
    private String poster_path;
    @SerializedName("production_companies")
    private HashMap<String,Integer> production_companies;
    @SerializedName("production_countries")
    private HashMap<String,String> production_countries;
    @SerializedName("release_date")
    private String release_date;
    @SerializedName("status")
    private String status;
    @SerializedName("tagline")
    private String tagline;
    @SerializedName("title")
    private String title;
    @SerializedName("vote_average")
    private Double vote_average;

    public SingleMovieDetail(boolean adult, String backdropPath, boolean belongs_to_collection, Integer budget, HashMap<Integer, String> genres, String homepage, Integer id, String imdb_id, String original_title, String overview, Double popularity, String poster_path, HashMap<String, Integer> production_companies, HashMap<String, String> production_countries, String release_date, String status, String tagline, String title, Double vote_average) {
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.belongs_to_collection = belongs_to_collection;
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.id = id;
        this.imdb_id = imdb_id;
        this.original_title = original_title;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.production_companies = production_companies;
        this.production_countries = production_countries;
        this.release_date = release_date;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.vote_average = vote_average;
    }

    public boolean getAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public boolean isBelongs_to_collection() {
        return belongs_to_collection;
    }

    public void setBelongs_to_collection(boolean belongs_to_collection) {
        this.belongs_to_collection = belongs_to_collection;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public HashMap<Integer, String> getGenres() {
        return genres;
    }

    public void setGenres(HashMap<Integer, String> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public HashMap<String, Integer> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(HashMap<String, Integer> production_companies) {
        this.production_companies = production_companies;
    }

    public HashMap<String, String> getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(HashMap<String, String> production_countries) {
        this.production_countries = production_countries;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }
    //    {
//        "adult": false,
//            "backdrop_path": "/5pAGnkFYSsFJ99ZxDIYnhQbQFXs.jpg",
//            "belongs_to_collection": null,
//            "budget": 97000000,
//            "genres": [
//        {
//            "id": 28,
//                "name": "Action"
//        },
//        {
//            "id": 18,
//                "name": "Drama"
//        },
//        {
//            "id": 878,
//                "name": "Science Fiction"
//        }
//  ],
//        "homepage": "http://www.foxmovies.com/movies/logan",
//            "id": 263115,
//            "imdb_id": "tt3315342",
//            "original_language": "en",
//            "original_title": "Logan",
//            "overview": "In the near future, a weary Logan cares for an ailing Professor X in a hide out on the Mexican border. But Logan's attempts to hide from the world and his legacy are up-ended when a young mutant arrives, being pursued by dark forces.",
//            "popularity": 62.118666,
//            "poster_path": "/45Y1G5FEgttPAwjTYic6czC9xCn.jpg",
//            "production_companies": [
//        {
//            "name": "Twentieth Century Fox Film Corporation",
//                "id": 306
//        },
//        {
//            "name": "Donners' Company",
//                "id": 431
//        },
//        {
//            "name": "Marvel Entertainment",
//                "id": 7505
//        },
//        {
//            "name": "TSG Entertainment",
//                "id": 22213
//        }
//  ],
//        "production_countries": [
//        {
//            "iso_3166_1": "US",
//                "name": "United States of America"
//        }
//  ],
//        "release_date": "2017-02-28",
//            "revenue": 603432613,
//            "runtime": 137,
//            "spoken_languages": [
//        {
//            "iso_639_1": "en",
//                "name": "English"
//        },
//        {
//            "iso_639_1": "es",
//                "name": "Español"
//        }
//  ],
//        "status": "Released",
//            "tagline": "His Time Has Come",
//            "title": "Logan",
//            "video": false,
//            "vote_average": 7.5,
//            "vote_count": 2553
//    }





//    OkHttpClient client = new OkHttpClient();
//
//    MediaType mediaType = MediaType.parse("application/octet-stream");
//    RequestBody body = RequestBody.create(mediaType, "{}");
//    Request request = new Request.Builder()
//            .url("https://api.themoviedb.org/3/movie/263115?language=en-US&api_key=31fda39458292782a21614f8c2debed6")
//            .get()
//            .build();
//
//    Response response = client.newCall(request).execute();
//
//
//
//    public SingleMovieDetail() throws IOException {
//    }
}
