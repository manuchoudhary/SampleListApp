package com.example.samplelistapp.main_activity;

import com.example.samplelistapp.model.Movie;

import java.util.List;

public class MainPresenterImpl implements MainContract.Presenter, MainContract.GetMovieIntractor.OnFinishedListener {

    private MainContract.MainView mainView;
    private MainContract.GetMovieIntractor getMovieIntractor;

    public MainPresenterImpl(MainContract.MainView mainView, MainContract.GetMovieIntractor getMovieIntractor) {
        this.mainView = mainView;
        this.getMovieIntractor = getMovieIntractor;
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onRefreshButtonClick() {

        if(mainView != null){
            mainView.showProgress();
        }
        getMovieIntractor.getMovieArrayList(this);

    }

    @Override
    public void requestDataFromServer() {
        getMovieIntractor.getMovieArrayList(this);
    }


    @Override
    public void onFinished(List<Movie> movieArrayList) {
        if(mainView != null){
            mainView.setDataToRecyclerView(movieArrayList);
            mainView.setDataToMainView(movieArrayList.get(0));
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }
    }
}
