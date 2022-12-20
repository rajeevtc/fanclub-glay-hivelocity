package co.jp.hivelocity.glay.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

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

public class TopFragment extends Fragment implements TopViewModel.ScreenListeners, TopMenuRecyclerViewAdapter.TopMenuItemClickListeners {

    private FragmentTopBinding binding;
    TopImageViewPagerAdapter adapter;

    TopViewModel viewModel;

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
        fetchTopImages();
        setupRecyclerView();
    }

    void setupRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this.getContext(), 1, RecyclerView.HORIZONTAL, false);
        TopMenuRecyclerViewAdapter adapter = new TopMenuRecyclerViewAdapter(viewModel.itemsList, this);
        binding.topMenuItemsRecyclerView.setAdapter(adapter);
        binding.topMenuItemsRecyclerView.setLayoutManager(layoutManager);
    }

    void setUpTopImages(List<String> images) {
        adapter = new TopImageViewPagerAdapter(images, this.getContext());
        binding.topImagesViewPager.setAdapter(adapter);

        new TabLayoutMediator(binding.pagerIndicator, binding.topImagesViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText("TAB " + (position + 1));
            }
        });

        binding.topImagesViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
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

    @Override
    public void onTopMenuClick(TopMenuItem item) {
        Log.d(item.title(), "item details");
        NavDirections action = item.navigationDirection();
        Navigation.findNavController(binding.getRoot()).navigate(action);
    }
}