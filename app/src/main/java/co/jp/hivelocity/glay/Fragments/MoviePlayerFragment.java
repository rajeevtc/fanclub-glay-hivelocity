package co.jp.hivelocity.glay.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.net.Uri;
import android.widget.MediaController;

import co.jp.hivelocity.databinding.FragmentMoviePlayerBinding;

public class MoviePlayerFragment extends Fragment {

   // String videoUrl = "http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4";
    String videoUrl = "https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1";
    FragmentMoviePlayerBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMoviePlayerBinding.inflate(inflater, container, false);
        playVideo(videoUrl);
        return binding.getRoot();
    }

    void playVideo(String url) {
        Uri uri = Uri.parse(url);
        binding.videoView.setVideoURI(uri);
        //binding.videoView.setVideoPath(videoUrl);
        MediaController mediaController = new MediaController(this.getContext());
        mediaController.setAnchorView(binding.videoView);
        mediaController.setMediaPlayer(binding.videoView);
        binding.videoView.setMediaController(mediaController);
        binding.videoView.start();
    }
}