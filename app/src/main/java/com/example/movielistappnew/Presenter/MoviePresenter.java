package com.example.movielistappnew.Presenter;

import com.example.movielistappnew.Contract.MovieListContract;
import com.example.movielistappnew.Model.Movie;
import com.example.movielistappnew.Service.MovieListModel;

import java.util.List;

public class MoviePresenter implements MovieListContract.Presenter,MovieListContract.Model.onFinishListner {


    private MovieListContract.View movielistview;
    private MovieListContract.Model movielistmodel;

    public MoviePresenter(MovieListContract.View movielistview) {
        this.movielistview = movielistview;
        movielistmodel = new MovieListModel();
    }




    @Override
    public void onDestroy() {
      this.movielistview=null;
    }

    @Override
    public void getMoreData(int pageNo) {

        if(movielistview != null) {
            movielistview.Showprogress();
        }

        movielistmodel.getMovielist(this, pageNo);

    }

    @Override
    public void requestDataFromServer() {

        if(movielistview != null) {
            movielistview.Showprogress();
        }

        movielistmodel.getMovielist(this, 1);

    }


    @Override
    public void onFinished(List<Movie> movieArrayList) {

        movielistview.SetDatatoRecyclerView(movieArrayList);
        if(movielistview != null) {
            movielistview.hideProgress();
        }

    }


    @Override
    public void onFailure(Throwable throwable) {

        movielistview.onResponseFailure(throwable);

        if (movielistview != null){
            movielistview.hideProgress();
        }
    }
}
