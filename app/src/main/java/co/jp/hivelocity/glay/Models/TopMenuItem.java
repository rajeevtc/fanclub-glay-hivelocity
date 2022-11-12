package co.jp.hivelocity.glay.Models;

public enum TopMenuItem {
    Music,
    Movie,
    News,
    ARCamera,
    ;

    String imageName(TopMenuItem type) {
        switch (type) {
            case Movie:
                return "top_icon_video";
            case Music:
                return "top_icon_music";
            case News:
                return "top_icon_news";
            case ARCamera:
                return "top_icon_arcamera";
            default:
                return "top_icon_music";
        }
    }
}