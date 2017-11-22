package com.example.jasmeetsingh.movies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView imageView = (ImageView)findViewById(R.id.cover_image);
        Picasso.with(this).load("http://image.tmdb.org/t/p/w185/45Y1G5FEgttPAwjTYic6czC9xCn.jpg").into(imageView);
        ImageView imageView2 = (ImageView)findViewById(R.id.movieImage);
        Picasso.with(this).load("http://image.tmdb.org/t/p/w185/45Y1G5FEgttPAwjTYic6czC9xCn.jpg").into(imageView2);

    }


}
