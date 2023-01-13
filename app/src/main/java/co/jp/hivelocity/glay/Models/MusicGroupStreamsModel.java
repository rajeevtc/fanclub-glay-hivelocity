package co.jp.hivelocity.glay.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MusicGroupStreamsModel {

    @SerializedName("success")
    @Expose
    private Integer success;

    public MusicGroupDataModel getData() {
        return data;
    }

    @SerializedName("code")
    @Expose
    private Integer code;

    @SerializedName("meta")
    @Expose
    private Meta meta;

    @SerializedName("data")
    @Expose
    private MusicGroupDataModel data = null;

    @SerializedName("errors")
    @Expose
    private Errors errors;

    @SerializedName("duration")
    @Expose
    private Double duration;

    public class MusicGroupDataModel {
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
        private List<MusicGroupStreamData> streams;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCoverImage() {
            return coverImage;
        }

        public void setCoverImage(String coverImage) {
            this.coverImage = coverImage;
        }

        public List<MusicGroupStreamData> getStreams() {
            return streams;
        }

        public void setStreams(List<MusicGroupStreamData> streams) {
            this.streams = streams;
        }
    }

    public class MusicGroupStreamData {
        @SerializedName("id")
        @Expose
        private Integer id;

        @SerializedName("title")
        @Expose
        private String title;

        @SerializedName("runtime")
        @Expose
        private String runtime;

        @SerializedName("large_cover_image_url")
        @Expose
        private String coverImage;

        public String getCoverImage() {
            return coverImage;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getRuntime() {
            return runtime;
        }

        public void setRuntime(String runtime) {
            this.runtime = runtime;
        }
    }
}
