package com.example.jasmeetsingh.movies.Network;

import com.example.jasmeetsingh.movies.Trailors;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jasmeetsingh on 22/04/17.
 */

public class TrailorResponse {

    @SerializedName("id")
    private Integer id;
    @SerializedName("results")
    private ArrayList<Trailors> trailorsArrayList;
}
