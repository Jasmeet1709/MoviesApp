package com.example.jasmeetsingh.movies.Network;

import com.example.jasmeetsingh.movies.Casts;
import com.example.jasmeetsingh.movies.Crew;
import com.example.jasmeetsingh.movies.MoviesDetails;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jasmeetsingh on 22/04/17.
 */

public class CastResponse {
    @SerializedName("id")
    private Integer id;
    @SerializedName("cast")
    private ArrayList<Casts> casts;
    @SerializedName("crew")
    private ArrayList<Crew> crews;
}
