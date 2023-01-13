package co.jp.hivelocity.glay.ViewModels;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import co.jp.hivelocity.glay.Models.MusicGroupStreamsModel;
import co.jp.hivelocity.glay.Models.MusicGroupStreamsModel.MusicGroupDataModel;
import co.jp.hivelocity.glay.Repositories.MusicGroupRepository;

public class MusicStreamsListViewModel implements MusicGroupRepository.MusicGroupStreamsCallback {

    MusicGroupRepository repository;

    MusicGroupDataModel streamDetails;

    ScreenListeners listeners;

    public MusicStreamsListViewModel(MusicGroupRepository repository, ScreenListeners listeners) {
        this.repository = repository;
        this.listeners = listeners;
    }

    public void fetchMusicGroupStreams() {
        repository.setListeners(this);
        repository.getMusicStreams(602);
    }

    @Override
    public void onGroupStreamsSuccess(MusicGroupDataModel streams) {

        streamDetails = streams;

        Integer index = 1;
        List<MusicStreamItemViewModel> listItemViewModel = new ArrayList<>();
        for (MusicGroupStreamsModel.MusicGroupStreamData stream :
             streams.getStreams()) {
            MusicStreamItemViewModel itemViewModel = new MusicStreamItemViewModel(index, stream.getTitle(), stream.getRuntime());
            itemViewModel.setCoverImage(streams.getCoverImage());
            listItemViewModel.add(itemViewModel);
            if (listItemViewModel.size() == streams.getStreams().size()) {
                listeners.loadStreamList(listItemViewModel);
            }
            index++;
        }

        MusicStreamHeaderViewModel viewModel = new MusicStreamHeaderViewModel(streams.getTitle(), streams.getCoverImage());
        listeners.loadHeader(viewModel);
    }

    @Override
    public void onFailure() {

    }

    public interface ScreenListeners {
        void loadStreamList(List<MusicStreamItemViewModel> listItemViewModel);
        void loadHeader(MusicStreamHeaderViewModel headerViewModel);
    }

    public class MusicStreamHeaderViewModel {
        String groupTitle;
        String groupCoverImage;

        public MusicStreamHeaderViewModel(String groupTitle, String groupCoverImage) {
            this.groupTitle = groupTitle;
            this.groupCoverImage = groupCoverImage;
        }

        public String getGroupTitle() {
            return groupTitle;
        }

        public String getGroupCoverImage() {
            return groupCoverImage;
        }
    }
}
