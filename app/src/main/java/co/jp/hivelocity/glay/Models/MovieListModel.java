package co.jp.hivelocity.glay.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieListModel {

    @SerializedName("success")
    @Expose
    private Integer success;

    @SerializedName("code")
    @Expose
    private Integer code;

    @SerializedName("meta")
    @Expose
    private Meta meta;

    @SerializedName("data")
    @Expose
    private MovieListStreamData data = null;

    @SerializedName("errors")
    @Expose
    private Errors errors;

    @SerializedName("duration")
    @Expose
    private Double duration;

    public MovieListStreamData getData() {
        return data;
    }

    public class MovieListStreamData {
        @SerializedName("id")
        @Expose
        private Integer id;

        @SerializedName("title")
        @Expose
        private String title;

        @SerializedName("large_cover_image_url")
        @Expose
        private String coverImage;

        @SerializedName("streams")
        @Expose
        private List<MovieListStreamItemData> streams;

        public List<MovieListStreamItemData> getStreams() {
            return streams;
        }

        public Integer getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getCoverImage() {
            return coverImage;
        }
    }

    public class MovieListStreamItemData {

        @SerializedName("id")
        @Expose
        private Integer id;

        @SerializedName("title")
        @Expose
        private String title;

        @SerializedName("playlist_path")
        @Expose
        private String playlistPath;

        @SerializedName("runtime")
        @Expose
        private String runtime;

        public Integer getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getPlaylistPath() {
            return playlistPath;
        }

        public String getRuntime() {
            return runtime;
        }
    }

}
