package com.malouane.data.remote.model;

import com.malouane.data.remote.model.venue.BeenHere;
import com.malouane.data.remote.model.venue.Category;
import com.malouane.data.remote.model.venue.Contact;
import com.malouane.data.remote.model.venue.HereNow;
import com.malouane.data.remote.model.venue.LocationRemoteModel;
import com.malouane.data.remote.model.venue.Stats;
import com.malouane.data.remote.model.venue.VenuePage;
import com.squareup.moshi.Json;
import java.util.List;

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