package co.jp.hivelocity.glay.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import co.jp.hivelocity.databinding.FragmentMovieListBinding;
import co.jp.hivelocity.glay.Adapters.MovieListRecyclerViewAdapter;
import co.jp.hivelocity.glay.DependencyInjection.Injections;
import co.jp.hivelocity.glay.ViewModels.MovieListViewModel;
import co.jp.hivelocity.glay.ViewModels.MusicStreamsListViewModel;

public class MovieListFragment extends Fragment implements MovieListViewModel.ScreenListeners, MovieListRecyclerViewAdapter.MovieListItemClickListeners {

    FragmentMovieListBinding binding;
    MovieListViewModel viewModel;
    MovieListRecyclerViewAdapter adapter;

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
    public void showHeader(MovieListViewModel.MovieHeaderViewModel headerViewModel) {
        String image = headerViewModel.getImageUrl();
        Glide.with(this)
                .load(image)
                .into(binding.imageViewHeader);
        binding.imageViewPlay.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMovieList(List<MovieListViewModel.MovieListItemViewModel> list, String headerTitle) {
        adapter = new MovieListRecyclerViewAdapter(list, this.getContext(), this);
        adapter.setHeaderTitle(headerTitle);
        binding.recyclerViewMovieList.setAdapter(adapter);
        binding.recyclerViewMovieList.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }

    @Override
    public void onMovieItemClick(MovieListViewModel.MovieListItemViewModel item) {
        NavDirections action = MovieListFragmentDirections.actionMovieListFragmentToMoviePlayerFragment();
        Navigation.findNavController(binding.getRoot()).navigate(action);
    }
}