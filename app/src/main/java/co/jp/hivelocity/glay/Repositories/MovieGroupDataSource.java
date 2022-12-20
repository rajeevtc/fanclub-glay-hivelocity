package co.jp.hivelocity.glay.Repositories;

import co.jp.hivelocity.glay.ApiRestAdapters.HistreamingApiRestAdapters;
import co.jp.hivelocity.glay.Interfaces.MovieGroupAPI;
import co.jp.hivelocity.glay.Models.MovieListModel;
import retrofit2.Call;
import retrofit2.Retrofit;

public class MovieGroupDataSource {

    static MovieGroupDataSource INSTANCE;

    public static MovieGroupDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MovieGroupDataSource();
        }
        return INSTANCE;
    }

    MovieGroupAPI providesMovieGroundAPI() {
        Retrofit retrofit = HistreamingApiRestAdapters.getRetrofit();
        return retrofit.create(MovieGroupAPI.class);
    }

    Call<MovieListModel> getMovieList(Integer groupId) {
        return providesMovieGroundAPI().getMovieList("111", groupId);
    }
}
