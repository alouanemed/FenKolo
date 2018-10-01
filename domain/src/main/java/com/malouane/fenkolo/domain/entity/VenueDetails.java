package com.malouane.fenkolo.domain.entity;

public class VenueDetails {
  private String id;
  private String name;
  private Double rating;
  private String photo;
  private Location location;

  public VenueDetails(String id, String name, Double rating, String photo, Location location) {
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

  public Double getRating() {
    return rating;
  }

  public String getPhoto() {
    return photo;
  }

  public Location getLocation() {
    return location;
  }
}
