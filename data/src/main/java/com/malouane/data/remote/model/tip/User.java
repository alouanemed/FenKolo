package com.malouane.data.remote.model.tip;

import com.malouane.data.remote.model.venueDetails.BestPhoto;
import com.squareup.moshi.Json;

public class User {

  @Json(name = "id")
  private String id;
  @Json(name = "firstName")
  private String firstName;
  @Json(name = "lastName")
  private String lastName;
  @Json(name = "gender")
  private String gender;
  @Json(name = "photo")
  private BestPhoto photo;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return firstName + " " + lastName;
  }

  public BestPhoto getPhoto() {
    return photo;
  }

  public void setPhoto(BestPhoto photo) {
    this.photo = photo;
  }
}