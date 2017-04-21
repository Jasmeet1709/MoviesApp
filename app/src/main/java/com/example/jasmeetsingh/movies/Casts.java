package com.example.jasmeetsingh.movies;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jasmeetsingh on 22/04/17.
 */

public class Casts {
    @SerializedName("cast_id")
    private Integer cast_id;
    @SerializedName("character")
    private String character;
    @SerializedName("credit_id")
    private String credit_id;
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("order")
    private Integer order;
    @SerializedName("profile_path")
    private String profile_path;

    public Casts(Integer cast_id, String character, String credit_id, Integer id, String name, Integer order, String profile_path) {
        this.cast_id = cast_id;
        this.character = character;
        this.credit_id = credit_id;
        this.id = id;
        this.name = name;
        this.order = order;
        this.profile_path = profile_path;
    }

    public Integer getCast_id() {
        return cast_id;
    }

    public void setCast_id(Integer cast_id) {
        this.cast_id = cast_id;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }
    //    "cast_id": 0,
//            "character": "Logan / Wolverine",
//            "credit_id": "533fea800e0a2636220013dd",
//            "id": 6968,
//            "name": "Hugh Jackman",
//            "order": 0,
//            "profile_path": "/iTfqkvcIvL8D32xXluth7LBGhW1.jpg"
}
