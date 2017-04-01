package com.example.jasmeetsingh.movies.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jasmeetsingh on 30/03/17.
 */

public class ApiClient {
    static Retrofit retrofit;
    static ApiInterface apiInterface;
    public static ApiInterface client(){
        if(apiInterface==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInterface = retrofit.create(ApiInterface.class);
        }
        return apiInterface;
    }
}
