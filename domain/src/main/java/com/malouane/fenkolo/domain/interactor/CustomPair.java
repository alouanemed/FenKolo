package com.malouane.fenkolo.domain.interactor;

public class CustomPair {
  private int frst;
  private boolean second;

  int locationLatLong;
  String catId;
  String query;
  private String id;
  private String name;

  public int getFrst() {
    return frst;
  }

  public void setFrst(int frst) {
    this.frst = frst;
  }

  public boolean isSecond() {
    return second;
  }

  public void setSecond(boolean second) {
    this.second = second;
  }

  public int getLocationLatLong() {
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
}