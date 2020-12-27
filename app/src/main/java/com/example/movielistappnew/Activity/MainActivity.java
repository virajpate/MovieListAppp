package com.example.movielistappnew.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.movielistappnew.Contract.MovieListContract;
import com.example.movielistappnew.Model.Movie;
import com.example.movielistappnew.Presenter.MoviePresenter;
import com.example.movielistappnew.R;
import com.example.movielistappnew.View.Movie_List_Adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieListContract.View {

    private MoviePresenter moviePresenter;
    private RecyclerView rvMovieList;
    private List<Movie> movieList;
    private Movie_List_Adapter movieListAdapter;
    private ProgressBar pbLoading;
    private int pageNo = 1;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMovieList = findViewById(R.id.rvMovieList);
        pbLoading = findViewById(R.id.pbLoading);
        movieList = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvMovieList.setLayoutManager(layoutManager);
        rvMovieList.setHasFixedSize(true);

        moviePresenter = new MoviePresenter(this);
        moviePresenter.requestDataFromServer();

    }

    @Override
    public void Showprogress() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void SetDatatoRecyclerView(List<Movie> movieListArray) {
        movieList.addAll(movieListArray);
        movieListAdapter =new Movie_List_Adapter(movieList,this);
        rvMovieList.setAdapter(movieListAdapter);

    }

    @Override
    public void onResponseFailure(Throwable t) {
        Log.e(TAG,t.getMessage()+"Error from MainActivity");
        Log.e(TAG,t.getMessage());
        Toast.makeText(MainActivity.this, "Error in getting data", Toast.LENGTH_LONG).show();
    }
}
