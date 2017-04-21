package com.example.jasmeetsingh.movies.Network;

import com.example.jasmeetsingh.movies.MoviesDetails;
import com.example.jasmeetsingh.movies.Review;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jasmeetsingh on 21/04/17.
 */

public class ReviewResponse {
    @SerializedName("id")
    private Integer id;
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private ArrayList<Review> results;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public ArrayList<Review> getResults() {
        return results;
    }

    public void setResults(ArrayList<Review> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
