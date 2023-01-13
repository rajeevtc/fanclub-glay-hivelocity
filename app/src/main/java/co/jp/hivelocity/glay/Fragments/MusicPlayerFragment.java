package co.jp.hivelocity.glay.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import co.jp.hivelocity.databinding.FragmentMusicPlayerBinding;
import co.jp.hivelocity.glay.ViewModels.MusicStreamItemViewModel;

public class MusicPlayerFragment extends Fragment {

    FragmentMusicPlayerBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMusicPlayerBinding.inflate(inflater, container, false);
        init();
        return binding.getRoot();
    }

    void init() {
        if (getArguments() != null) {
            MusicStreamItemViewModel model = (MusicStreamItemViewModel) getArguments().getSerializable("musicDetails");
            binding.textViewMusicTitle.setText(model.getMusicTitle());

            String headerImage = model.getCoverImage();
            Glide.with(getContext())
                    .load(headerImage)
                    .into(binding.imageViewMusic);
        }
    }
}