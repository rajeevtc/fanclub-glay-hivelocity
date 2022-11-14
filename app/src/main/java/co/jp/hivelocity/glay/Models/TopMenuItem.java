package co.jp.hivelocity.glay.Models;

import co.jp.hivelocity.R;

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
                return "Movie";
            case Music:
                return "Music";
            case News:
                return "News";
            case ARCamera:
                return "AR Camera";
            case LiveStreaming:
                return "Live";
            case Photos:
                return "Photos";
            case Profile:
                return "Profile";
        }
        return "Music";
    }
}