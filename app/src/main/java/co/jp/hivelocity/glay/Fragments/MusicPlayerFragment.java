package co.jp.hivelocity.glay.Fragments;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import co.jp.hivelocity.R;
import co.jp.hivelocity.databinding.FragmentMusicPlayerBinding;
import co.jp.hivelocity.glay.ViewModels.MusicStreamItemViewModel;

public class MusicPlayerFragment extends Fragment {

    FragmentMusicPlayerBinding binding;
    MediaPlayer player;

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

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        player = null;
    }

    void init() {
        if (getArguments() != null) {
            MusicStreamItemViewModel model = (MusicStreamItemViewModel) getArguments().getSerializable("musicDetails");
            binding.textViewMusicTitle.setText(model.getMusicTitle());

            String headerImage = model.getCoverImage();
            Glide.with(getContext())
                    .load(headerImage)
                    .into(binding.imageViewMusic);

            player = MediaPlayer.create(this.getContext(), R.raw.eminem);
            player.start();

            binding.playView.setImageResource(R.drawable.stop_icon);
            binding.playView.setTag(1);
            binding.playView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if ((Integer) binding.playView.getTag() == 0) {
                        player.start();
                        binding.playView.setTag(1);
                        binding.playView.setImageResource(R.drawable.stop_icon);
                    } else {
                        binding.playView.setTag(0);
                        binding.playView.setImageResource(R.drawable.play_icon);
                        player.pause();
                    }
                }
            });
        }
    }
}