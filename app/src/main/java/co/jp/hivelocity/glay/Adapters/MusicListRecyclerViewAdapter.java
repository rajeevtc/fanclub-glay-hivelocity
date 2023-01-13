package co.jp.hivelocity.glay.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.jp.hivelocity.databinding.MusicStreamsListItemBinding;
import co.jp.hivelocity.glay.ViewModels.MusicStreamItemViewModel;
import co.jp.hivelocity.glay.ViewModels.MusicStreamsListViewModel;

public class MusicListRecyclerViewAdapter extends RecyclerView.Adapter<MusicListRecyclerViewAdapter.MusicListItemViewHolder> {
    List<MusicStreamItemViewModel> itemsViewModel;
    Context context;
    MusicListItemClickListeners listeners;

    public MusicListRecyclerViewAdapter(List<MusicStreamItemViewModel> itemsViewModel, Context context, MusicListItemClickListeners listeners) {
        this.itemsViewModel = itemsViewModel;
        this.context = context;
        this.listeners = listeners;
    }

    @NonNull
    @Override
    public MusicListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        MusicListItemViewHolder viewHolder = new MusicListItemViewHolder(MusicStreamsListItemBinding.inflate(inflater, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MusicListItemViewHolder holder, int position) {
        MusicStreamItemViewModel itemViewModel = itemsViewModel.get(position);
        holder.binding.textViewItemNumber.setText(itemViewModel.getItemNumber().toString());
        holder.binding.textViewSongName.setText(itemViewModel.getMusicTitle());
        holder.binding.textViewSongRuntime.setText(itemViewModel.getMusicRuntime());
    }

    @Override
    public int getItemCount() {
        return itemsViewModel.size();
    }

    public class MusicListItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        MusicStreamsListItemBinding binding;

        public MusicListItemViewHolder(MusicStreamsListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            MusicStreamItemViewModel itemViewModel = itemsViewModel.get(getLayoutPosition());
            listeners.musicListItemClicked(itemViewModel);
        }
    }

    public interface MusicListItemClickListeners {
        void musicListItemClicked(MusicStreamItemViewModel itemViewModel);
    }
}
