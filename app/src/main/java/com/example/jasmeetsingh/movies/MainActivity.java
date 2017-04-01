package com.example.jasmeetsingh.movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentPopularMovies fragmentPopularMovies = (FragmentPopularMovies)getFragmentManager().findFragmentById(R.id.fragment_list);

    }
}
