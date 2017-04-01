package com.example.jasmeetsingh.movies;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jasmeetsingh on 01/04/17.
 */

public class Genres {

    public static HashMap<Integer,String> hashMap = new HashMap<>();

    public static HashMap<Integer, String> getHashMap() {
////        int array[]={28,80,14,9648,53,12,99,36,10749,10752,16,18,27,878,37,35,10751,10402,10770};
////        for(int i=0;i<array.length;i++){
////
//        }
        hashMap.put(28,"Action");hashMap.put(12,"Adventure");hashMap.put(16,"Animation");hashMap.put(35,"Comedy");
        hashMap.put(80,"Crime");hashMap.put(99,"Documentary");hashMap.put(18,"Drama");hashMap.put(10751,"Family");
        hashMap.put(14,"Fantasy");hashMap.put(36,"History");hashMap.put(27,"Horror");hashMap.put(10402,"Music");
        hashMap.put(9648,"Mystery");hashMap.put(10749,"Romance");hashMap.put(878,"Science Fiction");hashMap.put(10770,"TV Movie");
        hashMap.put(53,"Thriller");hashMap.put(10752,"War");hashMap.put(37,"Western");


        return hashMap;
    }
}
