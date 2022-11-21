package co.jp.hivelocity.glay.Models;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopModel {

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
    private List<TopDataModel> data = null;
    @SerializedName("errors")
    @Expose
    private Errors errors;
    @SerializedName("duration")
    @Expose
    private Double duration;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<TopDataModel> getData() {
        return data;
    }

    public void setData(List<TopDataModel> data) {
        this.data = data;
    }

    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors errors) {
        this.errors = errors;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

}