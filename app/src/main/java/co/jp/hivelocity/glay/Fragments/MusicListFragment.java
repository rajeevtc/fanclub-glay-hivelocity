package co.jp.hivelocity.glay.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Objects;

import co.jp.hivelocity.R;
import co.jp.hivelocity.databinding.FragmentMusicListBinding;
import co.jp.hivelocity.glay.Adapters.MusicListRecyclerViewAdapter;
import co.jp.hivelocity.glay.DependencyInjection.Injections;
import co.jp.hivelocity.glay.Models.MusicGroupStreamsModel;
import co.jp.hivelocity.glay.Repositories.MusicGroupRepository;
import co.jp.hivelocity.glay.ViewModels.MusicStreamItemViewModel;
import co.jp.hivelocity.glay.ViewModels.MusicStreamsListViewModel;

/**
 * create by rajeev
 */
public class MusicListFragment extends Fragment implements MusicStreamsListViewModel.ScreenListeners, MusicListRecyclerViewAdapter.MusicListItemClickListeners  {

    FragmentMusicListBinding binding;
    MusicStreamsListViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMusicListBinding.inflate(inflater, container, false);
        init();
        return binding.getRoot();
    }

    void init() {
        viewModel = new MusicStreamsListViewModel(Injections.provideMusicStreamsRepository(), this);
        fetchMusicGroupStreams();
    }

    void fetchMusicGroupStreams() {
        viewModel.fetchMusicGroupStreams();
    }

    void setupMusicListRecyclerView(List<MusicStreamItemViewModel> listItemViewModel) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        MusicListRecyclerViewAdapter adapter = new MusicListRecyclerViewAdapter(listItemViewModel, getContext(), this);
        binding.recyclerViewMusicList.setAdapter(adapter);
        binding.recyclerViewMusicList.setLayoutManager(layoutManager);
    }

    @Override
    public void loadStreamList(List<MusicStreamItemViewModel> listItemViewModel) {
        Log.d(String.valueOf(listItemViewModel), "Value of streams");
        setupMusicListRecyclerView(listItemViewModel);
    }

    @Override
    public void loadHeader(MusicStreamsListViewModel.MusicStreamHeaderViewModel headerViewModel) {
        String headerImage = headerViewModel.getGroupCoverImage();
        Glide.with(getContext())
                .load(headerImage)
                .into(binding.imageViewHeader);

        binding.textViewHeader.setText(headerViewModel.getGroupTitle());
    }

    @Override
    public void musicListItemClicked(MusicStreamItemViewModel itemViewModel) {
        NavDirections directions = MusicListFragmentDirections.actionMusicListFragmentToMusicPlayerFragment(itemViewModel);

        Navigation.findNavController(binding.getRoot()).navigate(directions);
    }
}