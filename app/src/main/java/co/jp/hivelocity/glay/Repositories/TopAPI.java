package co.jp.hivelocity.glay.Repositories;

import java.util.Observable;

import co.jp.hivelocity.glay.Models.TopModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface TopAPI {

    @GET("top/images")
    Call<TopModel> getTopImages();
}
