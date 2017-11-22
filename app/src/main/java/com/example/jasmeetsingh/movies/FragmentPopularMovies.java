package com.example.jasmeetsingh.movies;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.jasmeetsingh.movies.Network.ApiClient;
import com.example.jasmeetsingh.movies.Network.ApiInterface;
import com.example.jasmeetsingh.movies.Network.MovieResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jasmeetsingh on 30/03/17.
 */

public class FragmentPopularMovies extends Fragment{

    RecyclerView recyclerView;
    ProgressBar progressBar;
    ArrayList<MoviesDetails> arrayList;
    PopularMoviesAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_look,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        progressBar=(ProgressBar)view.findViewById(R.id.progressBar);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        arrayList = new ArrayList<>();
        adapter = new PopularMoviesAdapter(getActivity(),arrayList);
        recyclerView.setAdapter(adapter);
        progressBar.setIndeterminate(false);
        progressBar.setVisibility(View.GONE);

        fetchMovies();
        return view;

    }

    private void fetchMovies() {
        ApiInterface apiInterface = ApiClient.client();
        for(int i=1;i<976;i++) {
            Call<MovieResponse> arrayListCall = apiInterface.getPopularMovie("31fda39458292782a21614f8c2debed6",i);

            arrayListCall.enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                    if (response.isSuccessful()) {
                        Log.i("movieList", response.message() + response.code());

                        MovieResponse movieResponse = response.body();
                        ArrayList<MoviesDetails> moviesDetailsArrayList = movieResponse.getResults();
                        //arrayList.clear();
                        arrayList.addAll(moviesDetailsArrayList);
                        adapter.notifyDataSetChanged();

                    }
                }

                @Override
                public void onFailure(Call<MovieResponse> call, Throwable t) {

                }
            });
        }
//        call.enqueue(new Callback<CoursesResponse>() {
//            @Override
//            public void onResponse(Call<CoursesResponse> call, Response<CoursesResponse> response) {
//
//                if(response.isSuccessful()){
//                    Log.i("CourseAppTag", response.message() + response.code());
//
//                    CoursesResponse coursesResponse = response.body();
//                    ArrayList<Course> coursesList = coursesResponse.getData().getCourses();
//                    courses.clear();
//                    courses.addAll(coursesList);
//                    courseTitleList.clear();
//                    for(int i = 0; i < courses.size(); i++){
//                        courseTitleList.add(courses.get(i).title);
//                    }
//                    adapter.notifyDataSetChanged();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<CoursesResponse> call, Throwable t) {
//
//            }
//        });
    }

}
