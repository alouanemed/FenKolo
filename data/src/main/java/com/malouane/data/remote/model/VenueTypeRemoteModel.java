package com.malouane.data.remote.model;

import com.malouane.data.remote.model.venue.CategoryRemoteModel;
import com.squareup.moshi.Json;
import java.util.List;

public class VenueTypeRemoteModel {
    @Json(name = "id")
    private String id;
    @Json(name = "name")
    private String name;
  @Json(name = "categories") private List<CategoryRemoteModel> categories = null;

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

  public List<CategoryRemoteModel> getCategories() {
    return categories;
  }

  public void setCategories(List<CategoryRemoteModel> categories) {
    this.categories = categories;
  }
}