package co.jp.hivelocity.glay.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import co.jp.hivelocity.databinding.FragmentTopBinding;
import co.jp.hivelocity.glay.Adapters.TopMenuRecyclerViewAdapter;
import co.jp.hivelocity.glay.Models.TopMenuItem;

public class TopFragment extends Fragment {

    private FragmentTopBinding binding;
    TopMenuRecyclerViewAdapter adapter;

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
        setupRecyclerView();
    }

    void setupRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this.getContext(), 1, RecyclerView.HORIZONTAL, false);
        TopMenuRecyclerViewAdapter adapter = new TopMenuRecyclerViewAdapter(itemsList);
        binding.topMenuItemsRecyclerView.setAdapter(adapter);
        binding.topMenuItemsRecyclerView.setLayoutManager(layoutManager);
    }

}