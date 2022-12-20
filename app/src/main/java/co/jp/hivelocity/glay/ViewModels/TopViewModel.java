package co.jp.hivelocity.glay.ViewModels;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import co.jp.hivelocity.glay.Interfaces.BaseView;
import co.jp.hivelocity.glay.Models.TopDataModel;
import co.jp.hivelocity.glay.Models.TopMenuItem;
import co.jp.hivelocity.glay.Repositories.TopRepository;

public class TopViewModel implements TopRepository.TopAPICallBacks {

    public interface ScreenListeners extends BaseView {
        void showTopImages(List<String> list);
    }

    TopRepository repository;

    ScreenListeners listeners;

    public List<TopMenuItem> itemsList = new ArrayList<TopMenuItem>() {{
        add(TopMenuItem.Music);
        add(TopMenuItem.Movie);
        add(TopMenuItem.LiveStreaming);
        add(TopMenuItem.ARCamera);
        add(TopMenuItem.Photos);
        add(TopMenuItem.News);
        add(TopMenuItem.Profile);
    }};

    public TopRepository getRepository() {
        return repository;
    }

    public void setRepository(TopRepository repository) {
        this.repository = repository;
    }

    public TopViewModel(TopRepository repository, ScreenListeners listeners) {
        this.repository = repository;
        this.listeners = listeners;
    }

    public void fetchTopImages() {
        repository.setCallbacks(this);
        repository.getTopImages();
    }

    public ScreenListeners getListeners() {
        return listeners;
    }

    public void setListeners(ScreenListeners listeners) {
        this.listeners = listeners;
    }

    @Override
    public void onSuccess(List<TopDataModel> data) {
        List<String> items = data.stream()
                .map(value -> value.getTopImageUrl())
                .collect(Collectors.toList());
        listeners.showTopImages(items);
    }

    @Override
    public void onFailure() {

    }
}
