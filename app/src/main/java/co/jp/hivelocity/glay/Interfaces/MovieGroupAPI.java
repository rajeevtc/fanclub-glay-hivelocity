package co.jp.hivelocity.glay.Interfaces;

import co.jp.hivelocity.glay.Configs.APIConfigurations;
import co.jp.hivelocity.glay.Models.MovieListModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface MovieGroupAPI {
    @GET("groups/{id}")
    Call<MovieListModel> getMovieList(@Header(APIConfigurations.HeaderNameHiSession) String sessionId, @Path("id") Integer id);
}
