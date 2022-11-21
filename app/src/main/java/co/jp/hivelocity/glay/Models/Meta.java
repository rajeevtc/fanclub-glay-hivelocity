package co.jp.hivelocity.glay.Models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Meta {

    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("endpoint")
    @Expose
    private String endpoint;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

}

