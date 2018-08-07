package com.malouane.data.remote.model.venue;

import com.squareup.moshi.*;

public class VenuePage {

    @Json(name = "id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
