package co.jp.hivelocity.glay.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.jp.hivelocity.databinding.MusicStreamsListItemBinding;
import co.jp.hivelocity.databinding.StreamsListHeaderBinding;
import co.jp.hivelocity.glay.Models.TopMenuItem;
import co.jp.hivelocity.glay.ViewModels.MovieListViewModel;

public class MovieListRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    List<MovieListViewModel.MovieListItemViewModel> listviewModels;
    Context context;
    String headerTitle;
    private MovieListItemClickListeners listeners;

    public MovieListRecyclerViewAdapter(List<MovieListViewModel.MovieListItemViewModel> listviewModels, Context context, MovieListItemClickListeners listener) {
        this.listviewModels = listviewModels;
        this.context = context;
        this.listeners = listener;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            LayoutInflater inflater = LayoutInflater.from(context);
            MovieListHeaderViewHolder viewHolder = new MovieListHeaderViewHolder(StreamsListHeaderBinding.inflate(inflater, parent, false));
            return viewHolder;
        } else {
            LayoutInflater inflater = LayoutInflater.from(context);
            MovieListItemViewHolder viewHolder = new MovieListItemViewHolder(MusicStreamsListItemBinding.inflate(inflater, parent, false));
            return viewHolder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MovieListItemViewHolder) {
            MovieListItemViewHolder holderTypeItem = (MovieListItemViewHolder) holder;
            MovieListViewModel.MovieListItemViewModel itemViewModel = listviewModels.get(position - 1);
            holderTypeItem.binding.textViewItemNumber.setText(itemViewModel.getItemNumber().toString());
            holderTypeItem.binding.textViewSongName.setText(itemViewModel.getMusicTitle());
            holderTypeItem.binding.textViewSongRuntime.setText(itemViewModel.getMusicRuntime());
            holderTypeItem.binding.imageViewOptions.setVisibility(View.GONE);
        } else {
            MovieListHeaderViewHolder holderTypeHeader = (MovieListHeaderViewHolder) holder;
            holderTypeHeader.binding.textViewHeader.setText(headerTitle);
        }
    }

    @Override
    public int getItemCount() {
        return listviewModels.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    public class MovieListItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        MusicStreamsListItemBinding binding;

        public MovieListItemViewHolder(MusicStreamsListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            MovieListViewModel.MovieListItemViewModel item = listviewModels.get(this.getLayoutPosition() - 1);
            listeners.onMovieItemClick(item);
        }
    }

    public class MovieListHeaderViewHolder extends RecyclerView.ViewHolder {
        StreamsListHeaderBinding binding;

        public MovieListHeaderViewHolder(StreamsListHeaderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface MovieListItemClickListeners {
        void onMovieItemClick(MovieListViewModel.MovieListItemViewModel item);
    }
}

