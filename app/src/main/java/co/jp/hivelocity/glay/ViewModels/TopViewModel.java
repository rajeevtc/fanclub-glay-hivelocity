package co.jp.hivelocity.glay.ViewModels;

import android.util.Log;

import java.util.List;

import co.jp.hivelocity.glay.Models.TopDataModel;
import co.jp.hivelocity.glay.Repositories.APICallBacks;
import co.jp.hivelocity.glay.Repositories.TopRepository;

public class TopViewModel implements TopRepository.TopAPICallBacks {

    TopRepository repository;

    public TopViewModel(TopRepository repository) {
        this.repository = repository;
    }

    public TopRepository getRepository() {
        return repository;
    }

    public void setRepository(TopRepository repository) {
        this.repository = repository;
    }

    public void fetchTopImages() {
        repository.setCallbacks(this);
        repository.getTopImages();
    }

    @Override
    public void onSuccess(List<TopDataModel> data) {
        Log.d(String.valueOf(data), "value in response");
    }

    @Override
    public void onFailure() {

    }
}
