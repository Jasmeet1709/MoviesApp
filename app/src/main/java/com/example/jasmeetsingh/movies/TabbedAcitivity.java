package com.example.jasmeetsingh.movies;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.example.jasmeetsingh.movies.Network.ApiClient;
import com.example.jasmeetsingh.movies.Network.ApiInterface;
import com.example.jasmeetsingh.movies.Network.MovieResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabbedAcitivity extends AppCompatActivity  {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    PopularMoviesAdapter popularMoviesAdapter;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed_acitivity);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);

        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabbed_acitivity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        //private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance() {
            PlaceholderFragment fragment = new PlaceholderFragment();
//            Bundle args = new Bundle();
//           // args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//            fragment.setArguments(args);
            return fragment;
        }

        RecyclerView recyclerView;
        ArrayList<MoviesDetails> arrayList;
        PopularMoviesAdapter adapter;
        ClickListener clickListener;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.list_look,container,false);
            recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));
            arrayList = new ArrayList<>();
            adapter = new PopularMoviesAdapter(getActivity(),arrayList);
            recyclerView.setAdapter(adapter);
            recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new ClickItemListener() {
                @Override
                public void onClick(View view, int position) {

                    Intent intent = new Intent();
                    intent.putExtra("MovieId",arrayList.get(position).getId());
                    intent.setClass(getContext(),Details.class);
                    startActivity(intent);
                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));
            fetchMovies();
            return view;
        }
        private void fetchMovies() {
            ApiInterface apiInterface = ApiClient.client();
            //for (int i = 1; i < 976; i++) {
                Call<MovieResponse> arrayListCall = apiInterface.getPopularMovie("31fda39458292782a21614f8c2debed6", 1);

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
            //}
        }



        public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

            private GestureDetector gestureDetector;
            //  private MainActivity.ClickListListener clickListListener;
            //private MainActivity.c
            private TabbedAcitivity.ClickItemListener clickListener;

            public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final TabbedAcitivity.ClickItemListener clickListener) {
                this.clickListener = clickListener;
                gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        return true;
                    }

                    @Override
                    public void onLongPress(MotionEvent e) {
                        View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                        if (child != null && clickListener != null) {
                            //clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                            clickListener.onLongClick(child,recyclerView.getChildAdapterPosition(child));
                        }
                    }
                });
            }

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                    clickListener.onClick(child, rv.getChildPosition(child));
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        }

    }


    public static class PlaceholderFragmentTopRated extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        //private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragmentTopRated() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragmentTopRated newInstance() {
            PlaceholderFragmentTopRated fragment = new PlaceholderFragmentTopRated();
//            Bundle args = new Bundle();
//           // args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//            fragment.setArguments(args);
            return fragment;
        }

        RecyclerView recyclerView;
        ArrayList<MoviesDetails> arrayList;
        PopularMoviesAdapter adapter;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.list_look,container,false);
            recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));
            arrayList = new ArrayList<>();
            adapter = new PopularMoviesAdapter(getActivity(),arrayList);
            recyclerView.setAdapter(adapter);
            fetchMovies();
            return view;
        }
        private void fetchMovies() {
            ApiInterface apiInterface = ApiClient.client();
            //for (int i = 1; i < 976; i++) {
            Call<MovieResponse> arrayListCall = apiInterface.getTopRatedMovie("31fda39458292782a21614f8c2debed6", 1);

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
            //}
        }

    }

    public static class PlaceholderFragmentUpcoming extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        //private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragmentUpcoming() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragmentUpcoming newInstance() {
            PlaceholderFragmentUpcoming fragment = new PlaceholderFragmentUpcoming();
//            Bundle args = new Bundle();
//           // args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//            fragment.setArguments(args);
            return fragment;
        }

        RecyclerView recyclerView;
        ArrayList<MoviesDetails> arrayList;
        PopularMoviesAdapter adapter;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.list_look,container,false);
            recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));
            arrayList = new ArrayList<>();
            adapter = new PopularMoviesAdapter(getActivity(),arrayList);
            recyclerView.setAdapter(adapter);
            fetchMovies();
            return view;
        }
        private void fetchMovies() {
            ApiInterface apiInterface = ApiClient.client();
            //for (int i = 1; i < 976; i++) {
            Call<MovieResponse> arrayListCall = apiInterface.getUpcomingMovie("31fda39458292782a21614f8c2debed6", 1);

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
            //}
        }

    }

    public static class PlaceholderFragmentNowPlaying extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        //private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragmentNowPlaying() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragmentNowPlaying newInstance() {
            PlaceholderFragmentNowPlaying fragment = new PlaceholderFragmentNowPlaying();
//            Bundle args = new Bundle();
//           // args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//            fragment.setArguments(args);
            return fragment;
        }

        RecyclerView recyclerView;
        ArrayList<MoviesDetails> arrayList;
        PopularMoviesAdapter adapter;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.list_look,container,false);
            recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));
            arrayList = new ArrayList<>();
            adapter = new PopularMoviesAdapter(getActivity(),arrayList);
            recyclerView.setAdapter(adapter);
            fetchMovies();
            return view;
        }
        private void fetchMovies() {
            ApiInterface apiInterface = ApiClient.client();
            //for (int i = 1; i < 976; i++) {
            Call<MovieResponse> arrayListCall = apiInterface.getNowPlayingMovie("31fda39458292782a21614f8c2debed6", 1);

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
            //}
        }

    }



    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0: return PlaceholderFragment.newInstance();
                case 1: return PlaceholderFragmentTopRated.newInstance();
                case 2: return PlaceholderFragmentUpcoming.newInstance();
                case 3: return PlaceholderFragmentNowPlaying.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Popular";
                case 1:
                    return "TopRated";
                case 2:
                    return "Upcoming";
                case 3:
                    return "NowPlaying";
            }
            return null;
        }
    }
    public interface ClickListener{
        void onClickListListener(MoviesDetails moviesDetails);
    }

    public interface ClickItemListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }
}
