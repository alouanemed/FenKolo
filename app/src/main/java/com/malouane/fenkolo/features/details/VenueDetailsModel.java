package com.malouane.fenkolo.features.details;

import com.malouane.fenkolo.domain.entity.Location;

public class VenueDetailsModel {
  private String id;
  private String name;
  private String rating;
  private String photo;
  private String price;
  private Location location;

  public VenueDetailsModel(String id, String name, String rating, String photo, Location location) {
    this.id = id;
    this.name = name;
    this.rating = rating;
    this.photo = photo;
    this.location = location;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getRating() {
    return rating;
  }

  public String getPhoto() {
    return photo;
  }

  public Location getLocation() {
    return location;
  }
}