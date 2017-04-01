package com.example.jasmeetsingh.movies.Network;

import com.example.jasmeetsingh.movies.MoviesDetails;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jasmeetsingh on 30/03/17.
 */

public class MovieResponse {
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private ArrayList<MoviesDetails> results;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public ArrayList<MoviesDetails> getResults() {
        return results;
    }

    public void setResults(ArrayList<MoviesDetails> results) {
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
