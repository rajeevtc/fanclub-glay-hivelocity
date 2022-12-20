package co.jp.hivelocity.glay.Repositories;

import co.jp.hivelocity.glay.ApiRestAdapters.HistreamingApiRestAdapters;
import co.jp.hivelocity.glay.Interfaces.MusicGroupAPI;
import co.jp.hivelocity.glay.Models.MusicGroupStreamsModel;
import co.jp.hivelocity.glay.Models.TopModel;
import retrofit2.Call;
import retrofit2.Retrofit;

public class MusicGroupDataSource {

    static MusicGroupDataSource INSTANCE;

    public static MusicGroupDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MusicGroupDataSource();
        }
        return INSTANCE;
    }

    MusicGroupAPI provideMusicGroupApi() {
        Retrofit retrofit = HistreamingApiRestAdapters.getRetrofit();
        return retrofit.create(MusicGroupAPI.class);
    }

    Call<MusicGroupStreamsModel> getGroupStreams(int id) {
        return provideMusicGroupApi().getGroupStreams("1111", id);
    }
}
