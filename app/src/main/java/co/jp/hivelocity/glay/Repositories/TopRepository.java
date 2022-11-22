package co.jp.hivelocity.glay.Repositories;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.Observable;

import co.jp.hivelocity.glay.Models.TopDataModel;
import co.jp.hivelocity.glay.Models.TopModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopRepository {

    @NonNull
    TopDataSource dataSource;
    TopAPICallBacks callbacks;

    public TopRepository(@NonNull TopDataSource dataSource) {
        this.dataSource = dataSource;
    }

    TopRepository getInstance(@NonNull TopDataSource dataSource) {
        TopRepository instance = new TopRepository(dataSource);
        return instance;
    }

    public void setDataSource(@NonNull TopDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setCallbacks(TopAPICallBacks callbacks) {
        this.callbacks = callbacks;
    }

    public void getTopImages() {

        Call<TopModel> call = dataSource.getTopImages();

        call.enqueue(new Callback<TopModel>() {
            @Override
            public void onResponse(Call<TopModel> call, Response<TopModel> response) {
                TopModel model = response.body();
                Log.d(model.toString(),"Total values");
                callbacks.onSuccess(model.getData());
            }

            @Override
            public void onFailure(Call<TopModel> call, Throwable t) {
                callbacks.onFailure();
            }
        });

    }

    public interface TopAPICallBacks {
        void onSuccess(List<TopDataModel> data);
        void onFailure();
    }
}

