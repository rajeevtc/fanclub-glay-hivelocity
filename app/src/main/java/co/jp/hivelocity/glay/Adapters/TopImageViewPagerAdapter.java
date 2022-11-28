package co.jp.hivelocity.glay.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.net.URL;
import java.util.List;

import co.jp.hivelocity.databinding.TopImageItemBinding;

public class TopImageViewPagerAdapter extends RecyclerView.Adapter<TopImageViewPagerAdapter.TopImageViewHolder> {

    List<String> topImages;
    Context context;

    public TopImageViewPagerAdapter(List<String> topImages, Context context) {
        this.topImages = topImages;
        this.context = context;
    }

    @NonNull
    @Override
    public TopImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new TopImageViewHolder(TopImageItemBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TopImageViewHolder holder, int position) {
        String topImage = topImages.get(position);
        Glide.with(context)
                .load(topImage)
                .into(holder.binding.imageViewTop);
    }

    @Override
    public int getItemCount() {
        return topImages.size();
    }

    public class TopImageViewHolder extends RecyclerView.ViewHolder {
        TopImageItemBinding binding;

        public TopImageViewHolder(TopImageItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
