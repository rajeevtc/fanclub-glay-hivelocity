package co.jp.hivelocity.glay.Repositories;

import co.jp.hivelocity.glay.ApiRestAdapters.FanstreamingApiRestAdapters;
import co.jp.hivelocity.glay.Interfaces.TopAPI;
import co.jp.hivelocity.glay.Models.TopModel;
import retrofit2.Call;
import retrofit2.Retrofit;

public class TopDataSource {

    static TopDataSource INSTANCE;

    public TopDataSource() {

    }

    public static TopDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TopDataSource();
        }
        return INSTANCE;
    }

    TopAPI provideTopAPI() {
        Retrofit retrofit = FanstreamingApiRestAdapters.getRetrofit();
        return retrofit.create(TopAPI.class);
    }

    Call<TopModel> getTopImages() {
        return provideTopAPI().getTopImages();
    }

}
