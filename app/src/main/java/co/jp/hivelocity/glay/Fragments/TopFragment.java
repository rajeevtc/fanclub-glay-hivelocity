package co.jp.hivelocity.glay.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import co.jp.hivelocity.databinding.FragmentTopBinding;
import co.jp.hivelocity.glay.Adapters.TopImageViewPagerAdapter;
import co.jp.hivelocity.glay.Adapters.TopMenuRecyclerViewAdapter;
import co.jp.hivelocity.glay.DependencyInjection.Injections;
import co.jp.hivelocity.glay.Models.TopDataModel;
import co.jp.hivelocity.glay.Models.TopMenuItem;
import co.jp.hivelocity.glay.Repositories.TopDataSource;
import co.jp.hivelocity.glay.Repositories.TopRepository;
import co.jp.hivelocity.glay.ViewModels.TopViewModel;

public class TopFragment extends Fragment implements TopViewModel.ScreenListeners {

    private FragmentTopBinding binding;
    TopImageViewPagerAdapter adapter;

    TopViewModel viewModel;

    static final List<TopMenuItem> itemsList = new ArrayList<TopMenuItem>() {{
        add(TopMenuItem.Music);
        add(TopMenuItem.Movie);
        add(TopMenuItem.LiveStreaming);
        add(TopMenuItem.ARCamera);
        add(TopMenuItem.Photos);
        add(TopMenuItem.News);
        add(TopMenuItem.Profile);
    }};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTopBinding.inflate(inflater, container, false);
        init();
        return binding.getRoot();
    }

    private void init() {
        viewModel = new TopViewModel(Injections.provideTopRepository(), this);
        setupRecyclerView();
        fetchTopImages();
    }

    void setupRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this.getContext(), 1, RecyclerView.HORIZONTAL, false);
        TopMenuRecyclerViewAdapter adapter = new TopMenuRecyclerViewAdapter(itemsList);
        binding.topMenuItemsRecyclerView.setAdapter(adapter);
        binding.topMenuItemsRecyclerView.setLayoutManager(layoutManager);
    }

    void setUpTopImages(List<String> images) {
        adapter = new TopImageViewPagerAdapter(images, this.getContext());
        binding.topImagesViewPager.setAdapter(adapter);
    }

    void fetchTopImages() {
        viewModel.fetchTopImages();
    }

    @Override
    public void showError(Error error) {

    }

    @Override
    public void showLoadingIndicator(Boolean status) {

    }

    @Override
    public void showTopImages(List<String> list) {
        Log.d(String.valueOf(list), "value in response");
        setUpTopImages(list);
    }
}