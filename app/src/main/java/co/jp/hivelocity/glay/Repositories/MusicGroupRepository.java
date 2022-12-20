package co.jp.hivelocity.glay.Repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import co.jp.hivelocity.glay.Models.MusicGroupStreamsModel;
import co.jp.hivelocity.glay.Models.MusicGroupStreamsModel.MusicGroupDataModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MusicGroupRepository {

    @NonNull
    MusicGroupDataSource dataSource;

    MusicGroupStreamsCallback listeners;

    public MusicGroupRepository(@NonNull MusicGroupDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setDataSource(@NonNull MusicGroupDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setListeners(MusicGroupStreamsCallback listeners) {
        this.listeners = listeners;
    }

    public MusicGroupRepository getInstance(@NonNull MusicGroupDataSource dataSource, MusicGroupStreamsCallback listeners) {
        MusicGroupRepository repository = new MusicGroupRepository(dataSource);
        return repository;
    }

    public void getMusicStreams(int groudId) {
        Call<MusicGroupStreamsModel> call = dataSource.getGroupStreams(groudId);

        call.enqueue(new Callback<MusicGroupStreamsModel>() {
            @Override
            public void onResponse(Call<MusicGroupStreamsModel> call, Response<MusicGroupStreamsModel> response) {
                MusicGroupStreamsModel model = response.body();
                Log.d(model.toString(),"Total values");
                listeners.onGroupStreamsSuccess(model.getData());
            }

            @Override
            public void onFailure(Call<MusicGroupStreamsModel> call, Throwable t) {

            }
        });
    }

    public interface MusicGroupStreamsCallback {
        void onGroupStreamsSuccess(MusicGroupDataModel streams);
        void onFailure();
    }

}
