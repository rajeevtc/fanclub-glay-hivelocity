package co.jp.hivelocity.glay.ViewModels;

import android.util.Log;

import co.jp.hivelocity.glay.Models.MovieListModel;
import co.jp.hivelocity.glay.Repositories.MovieGroupRepository;

public class MovieListViewModel implements MovieGroupRepository.MovieGroupCallbacks {

    MovieGroupRepository repository;
    ScreenListeners listeners;

    public MovieListViewModel(MovieGroupRepository repository, ScreenListeners listeners) {
        this.repository = repository;
        this.listeners = listeners;
    }

    public MovieGroupRepository getRepository() {
        return repository;
    }

    public void setRepository(MovieGroupRepository repository) {
        this.repository = repository;
    }

    public ScreenListeners getListeners() {
        return listeners;
    }

    public void setListeners(ScreenListeners listeners) {
        this.listeners = listeners;
    }

    public void fetchMovieList() {
        repository.setCallbacks(this);
        repository.getMovieList(596);
    }

    @Override
    public void onMovieListSuccess(MovieListModel.MovieListStreamData listData) {
        Log.d(String.valueOf(listData), "Display");
    }

    @Override
    public void onFailure(Throwable error) {

    }

    public interface ScreenListeners {
        void showHeader();
        void showMovieList();
    }
}
