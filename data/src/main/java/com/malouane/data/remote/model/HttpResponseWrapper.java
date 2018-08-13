package com.malouane.data.remote.model;

import com.malouane.data.remote.model.venue.*;
import com.squareup.moshi.*;

public class HttpResponseWrapper<T> {

    @Json(name = "meta")
    private Meta meta;
    @Json(name = "response")
    private T response;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

}
