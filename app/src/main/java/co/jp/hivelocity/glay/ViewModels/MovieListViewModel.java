package co.jp.hivelocity.glay.ViewModels;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import co.jp.hivelocity.glay.Models.MovieListModel;
import co.jp.hivelocity.glay.Models.MusicGroupStreamsModel;
import co.jp.hivelocity.glay.Repositories.MovieGroupRepository;

public class MovieListViewModel implements MovieGroupRepository.MovieGroupCallbacks {

    MovieGroupRepository repository;
    ScreenListeners listeners;

    public MovieListViewModel(MovieGroupRepository repository, ScreenListeners listeners) {
        this.repository = repository;
        this.listeners = listeners;
    }

    public MovieGroupRepository getRepository() {
        return repository;
    }

    public void setRepository(MovieGroupRepository repository) {
        this.repository = repository;
    }

    public ScreenListeners getListeners() {
        return listeners;
    }

    public void setListeners(ScreenListeners listeners) {
        this.listeners = listeners;
    }

    public void fetchMovieList() {
        repository.setCallbacks(this);
        repository.getMovieList(596);
    }

    @Override
    public void onMovieListSuccess(MovieListModel.MovieListStreamData listData) {
        Log.d(String.valueOf(listData), "Display");
        Integer index = 1;
        List<MovieListViewModel.MovieListItemViewModel> listItemViewModel = new ArrayList<>();
        for (MovieListModel.MovieListStreamItemData stream :
                listData.getStreams()) {
            MovieListViewModel.MovieListItemViewModel itemViewModel = new MovieListViewModel.MovieListItemViewModel(index, stream.getTitle(), stream.getRuntime(), false);
            listItemViewModel.add(itemViewModel);
            if (listItemViewModel.size() == listData.getStreams().size()) {
                listeners.showMovieList(listItemViewModel, listData.getTitle());
            }
            index++;
        }

        String firstStreamPath = listData.getStreams().get(0).getPlaylistPath();
        MovieHeaderViewModel headerViewModel = new MovieHeaderViewModel(listData.getCoverImage(), firstStreamPath, listData.getTitle());
        listeners.showHeader(headerViewModel);
    }

    @Override
    public void onFailure(Throwable error) {

    }

    public interface ScreenListeners {
        void showHeader(MovieHeaderViewModel headerViewModel);
        void showMovieList(List<MovieListViewModel.MovieListItemViewModel> list, String headerTitle);
    }

    public class MovieHeaderViewModel {
        String imageUrl;
        String playlistUrl;
        String groupTitle;

        public MovieHeaderViewModel(String imageUrl, String playlistUrl, String groupTitle) {
            this.imageUrl = imageUrl;
            this.playlistUrl = playlistUrl;
            this.groupTitle = groupTitle;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public String getPlaylistUrl() {
            return playlistUrl;
        }

        public String getGroupTitle() {
            return groupTitle;
        }
    }

    public class MovieListItemViewModel {
        Integer itemNumber;
        String musicTitle;
        String musicRuntime;
        Boolean shouldShowOption;

        public MovieListItemViewModel(Integer itemNumber, String musicTitle, String musicRuntime, Boolean shouldShowOption) {
            this.itemNumber = itemNumber;
            this.musicTitle = musicTitle;
            this.musicRuntime = musicRuntime;
        }

        public Boolean getShouldShowOption() {
            return shouldShowOption;
        }

        public String getMusicTitle() {
            return musicTitle;
        }

        public Integer getItemNumber() {
            return itemNumber;
        }

        public String getMusicRuntime() {
            return musicRuntime;
        }
    }
}
