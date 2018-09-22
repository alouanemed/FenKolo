package com.malouane.fenkolo.features.list;

public class VenueModel {
  private String id;
  private String name;
  private String location;
  private int distance;
  private String hereNow;

  public VenueModel(String id, String name, String location, int distance, String hereNow) {
    this.id = id;
    this.name = name;
    this.location = location;
    this.distance = distance;
    this.hereNow = hereNow;
  }

  public int getDistance() {
    return distance;
  }

  public String getHereNow() {
    return hereNow;
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

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}
