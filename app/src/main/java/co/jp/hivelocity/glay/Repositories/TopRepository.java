package co.jp.hivelocity.glay.Repositories;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.Observable;

import co.jp.hivelocity.glay.Models.TopModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopRepository {

    @NonNull
    TopDataSource dataSource;

    public TopRepository(@NonNull TopDataSource dataSource) {
        this.dataSource = dataSource;
    }

    TopRepository getInstance(@NonNull TopDataSource dataSource) {
        TopRepository instance = new TopRepository(dataSource);
        return instance;
    }

    public void getTopImages() {

        Call<TopModel> call = dataSource.getTopImages();

        call.enqueue(new Callback<TopModel>() {
            @Override
            public void onResponse(Call<TopModel> call, Response<TopModel> response) {
                TopModel model = response.body();
                Log.d(model.toString(),"Total values");
            }

            @Override
            public void onFailure(Call<TopModel> call, Throwable t) {

            }
        });

    }
}
