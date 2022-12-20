package co.jp.hivelocity.glay.Models;

import androidx.navigation.NavDirections;

import co.jp.hivelocity.R;
import co.jp.hivelocity.glay.Fragments.TopFragmentDirections;

public enum TopMenuItem {
    Music,
    Movie,
    News,
    LiveStreaming,
    Photos,
    ARCamera,
    Profile,
    ;

    public int imageName() {
        switch (this) {
            case Movie:
                return R.drawable.top_icon_video;
            case Music:
                return R.drawable.top_icon_music;
            case News:
                return R.drawable.top_icon_news;
            case ARCamera:
                return R.drawable.top_icon_arcamera;
            case LiveStreaming:
                return R.drawable.top_icon_streaming;
            case Photos:
                return R.drawable.top_icon_photo;
            case Profile:
                return R.drawable.top_icon_profile;
        }
        return R.drawable.top_icon_music;
    }

    public String title() {
        switch (this) {
            case Movie:
                return "MOVIE";
            case Music:
                return "MUSIC";
            case News:
                return "NEWS";
            case ARCamera:
                return "AR CAMERA";
            case LiveStreaming:
                return "LIVE";
            case Photos:
                return "PHOTOS";
            case Profile:
                return "PROFILE";
        }
        return "MUSIC";
    }

    public NavDirections navigationDirection() {
        switch (this) {
            case Music:
                return TopFragmentDirections.actionTopFragmentToMusicListFragment();
            case Movie:
                return TopFragmentDirections.actionTopFragmentToMovieListFragment();
            case News:
                return TopFragmentDirections.actionTopFragmentToMusicListFragment();
            case ARCamera:
                return TopFragmentDirections.actionTopFragmentToMusicListFragment();
            case LiveStreaming:
                return TopFragmentDirections.actionTopFragmentToMusicListFragment();
            case Photos:
                return TopFragmentDirections.actionTopFragmentToMusicListFragment();
            case Profile:
                return TopFragmentDirections.actionTopFragmentToMusicListFragment();
        }
        return TopFragmentDirections.actionTopFragmentToMusicListFragment();
    }
}