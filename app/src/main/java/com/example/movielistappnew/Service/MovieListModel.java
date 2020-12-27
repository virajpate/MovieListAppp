package com.example.movielistappnew.Service;

import android.util.Log;

import com.example.movielistappnew.Contract.MovieListContract;
import com.example.movielistappnew.Model.Movie;
import com.example.movielistappnew.Model.MovieListResponse;
import com.example.movielistappnew.Network.ApiClient;
import com.example.movielistappnew.Network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListModel implements MovieListContract.Model{

    private static final String LANGUAGE = "en-US";
    private String API_KEY="52a18783ed514602a5facb15a0177e61";
    private static final String TAG = "MovieListModel";
    private int pageNo = 1;


    @Override
    public void getMovielist(final onFinishListner onFinishListner, int pageNo) {

        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);

        Call<MovieListResponse> call=apiInterface.getNowPlaying(API_KEY,LANGUAGE,pageNo);

        call.enqueue(new Callback<MovieListResponse>() {
            @Override
            public void onResponse(Call<MovieListResponse> call, Response<MovieListResponse> response) {
                List<Movie> movies=response.body().getMovies();
                Log.e(TAG,"Number of movies received: "+ movies.size());

                onFinishListner.onFinished(movies);
            }

            @Override
            public void onFailure(Call<MovieListResponse> call, Throwable t) {

                Log.e(TAG, t.toString());
                onFinishListner.onFailure(t);
            }
        });
    }
}
