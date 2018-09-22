package com.malouane.data.remote.model;

import com.squareup.moshi.Json;

public class VenueTypeRemoteModel {
    @Json(name = "id")
    private String id;
    @Json(name = "name")
    private String name;

    public VenueTypeRemoteModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}