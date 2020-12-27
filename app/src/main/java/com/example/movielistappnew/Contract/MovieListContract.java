package com.example.movielistappnew.Contract;

import com.example.movielistappnew.Model.Movie;

import java.util.List;

public interface MovieListContract {

    interface Model {

        interface onFinishListner {
            void onFinished(List<Movie> movieArrayList);

            void onFailure(Throwable throwable);

        }

        void getMovielist(onFinishListner onFinishListner, int pageNo);
    }

    interface View {
        void Showprogress();

        void hideProgress();

        void SetDatatoRecyclerView(List<Movie> movieListArray);

        void onResponseFailure(Throwable t);

    }

    interface Presenter {
        void onDestroy();

        void getMoreData(int pageNo);

        void requestDataFromServer();
    }
}