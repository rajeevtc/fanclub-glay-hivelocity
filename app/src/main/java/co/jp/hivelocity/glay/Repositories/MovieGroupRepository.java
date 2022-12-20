package co.jp.hivelocity.glay.Repositories;

import androidx.annotation.NonNull;

import co.jp.hivelocity.glay.Models.MovieListModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieGroupRepository {

    @NonNull
    MovieGroupDataSource dataSource;

    MovieGroupCallbacks callbacks;

    public MovieGroupRepository(@NonNull MovieGroupDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public MovieGroupCallbacks getCallbacks() {
        return callbacks;
    }

    public void setCallbacks(MovieGroupCallbacks callbacks) {
        this.callbacks = callbacks;
    }

    public void getMovieList(Integer groupId) {
        Call<MovieListModel> call = dataSource.getMovieList(groupId);

        call.enqueue(new Callback<MovieListModel>() {
            @Override
            public void onResponse(Call<MovieListModel> call, Response<MovieListModel> response) {
                MovieListModel listModel = response.body();
                callbacks.onMovieListSuccess(listModel.getData());
            }

            @Override
            public void onFailure(Call<MovieListModel> call, Throwable t) {
                callbacks.onFailure(t);
            }
        });
    }

    public interface MovieGroupCallbacks {
        void onMovieListSuccess(MovieListModel.MovieListStreamData listData);
        void onFailure(Throwable error);
    }
}
