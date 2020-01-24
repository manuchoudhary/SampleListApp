package com.example.samplelistapp.main_activity;

import com.example.samplelistapp.model.Movie;

import java.util.ArrayList;
import java.util.List;

public interface MainContract {

    /**
     * Call when user interact with the view and other when view OnDestroy()
     * */
    interface Presenter{

        void onDestroy();

        void onRefreshButtonClick();

        void requestDataFromServer();

    }

    /**
     * showProgress() and hideProgress() would be used for displaying and hiding the progressBar
     * while the setDataToRecyclerView and onResponseFailure is fetched from the GetPlaceInteractorImpl class
     **/
    interface MainView {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(List<Movie> movieList);

        void onResponseFailure(Throwable throwable);

        void setDataToMainView(Movie movie);

    }

    /**
     * Intractors are classes built for fetching data from your database, web services, or any other data source.
     **/
    interface GetMovieIntractor {

        interface OnFinishedListener {
            void onFinished(List<Movie> movieList);
            void onFailure(Throwable t);
        }

        void getMovieArrayList(OnFinishedListener onFinishedListener);
    }

}
