package co.jp.hivelocity.glay.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.jp.hivelocity.databinding.TopMenuItemBinding;
import co.jp.hivelocity.glay.Models.TopMenuItem;

public class TopMenuRecyclerViewAdapter extends RecyclerView.Adapter<TopMenuRecyclerViewAdapter.TopMenuItemViewHolder> {

    private List<TopMenuItem> menuList;

    public TopMenuRecyclerViewAdapter(List<TopMenuItem> menuList) {
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public TopMenuItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new TopMenuItemViewHolder(TopMenuItemBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TopMenuItemViewHolder holder, int position) {
        TopMenuItem item = menuList.get(position);
        holder.binding.imageView.setImageResource(item.imageName());
        holder.binding.tvTopName.setText(item.title());
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    class TopMenuItemViewHolder extends RecyclerView.ViewHolder {

        TopMenuItemBinding binding;

        public TopMenuItemViewHolder(TopMenuItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
