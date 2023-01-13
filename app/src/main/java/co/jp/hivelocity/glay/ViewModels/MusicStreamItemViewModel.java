package co.jp.hivelocity.glay.ViewModels;
import java.io.Serializable;

public class MusicStreamItemViewModel implements Serializable {
    Integer itemNumber;
    String musicTitle;
    String musicRuntime;
    String coverImage;

    public MusicStreamItemViewModel(Integer itemNumber, String musicTitle, String musicRuntime) {
        this.itemNumber = itemNumber;
        this.musicTitle = musicTitle;
        this.musicRuntime = musicRuntime;
    }

    public String getMusicTitle() {
        return musicTitle;
    }

    public Integer getItemNumber() {
        return itemNumber;
    }

    public String getMusicRuntime() {
        return musicRuntime;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }
}