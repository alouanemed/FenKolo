package com.malouane.fenkolo.domain.interactor;

public class CustomPair {
  private int first;
  private boolean second;

  String locationLatLong;
  String catId;
  String query;
  private String id;
  private String name;

  public CustomPair(String id
  ) {
  this.id = id;
  }
  public CustomPair(String locationLatLong, String catId) {
    this.locationLatLong = locationLatLong;
    this.catId = catId;
  }

  public int getFirst() {
    return first;
  }

  public void setFirst(int first) {
    this.first = first;
  }

  public boolean isSecond() {
    return second;
  }

  public void setSecond(boolean second) {
    this.second = second;
  }

  public String getLocationLatLong() {
    return locationLatLong;
  }

  public String getCatId() {
    return catId;
  }

  public String getQuery() {
    return query;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setLocationLatLong(String locationLatLong) {
    this.locationLatLong = locationLatLong;
  }

  public void setCatId(String catId) {
    this.catId = catId;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }
}