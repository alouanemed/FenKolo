package com.malouane.data.remote.model.venue;

import com.squareup.moshi.*;

public class Meta {

    @Json(name = "code")
    private Integer code;
    @Json(name = "requestId")
    private String requestId;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

}
