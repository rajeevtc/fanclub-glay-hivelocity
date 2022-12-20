package co.jp.hivelocity.glay.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.jp.hivelocity.databinding.FragmentMovieListBinding;
import co.jp.hivelocity.glay.DependencyInjection.Injections;
import co.jp.hivelocity.glay.ViewModels.MovieListViewModel;

public class MovieListFragment extends Fragment implements MovieListViewModel.ScreenListeners {

    FragmentMovieListBinding binding;
    MovieListViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMovieListBinding.inflate(inflater, container, false);
        setUp();
        return binding.getRoot();
    }

    void setUp() {
        viewModel = new MovieListViewModel(Injections.provideMovieGroupRepository(), this);
        viewModel.fetchMovieList();
    }

    @Override
    public void showHeader() {

    }

    @Override
    public void showMovieList() {

    }
}