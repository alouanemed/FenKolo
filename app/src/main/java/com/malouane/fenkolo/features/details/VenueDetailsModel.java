package com.malouane.fenkolo.features.details;

import com.malouane.fenkolo.domain.entity.Location;

public class VenueDetailsModel {
  private String id;
  private String name;
  private Double rating;
  private String ratingText;
  private String photo;
  private String price;
  private Location location;

  public VenueDetailsModel(String id, String name, Double rating, String ratingText, String photo,
      String price, Location location) {
    this.id = id;
    this.name = name;
    this.rating = rating;
    this.ratingText = ratingText;
    this.photo = photo;
    this.price = price;
    this.location = location;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRatingText() {
    return ratingText;
  }

  public void setRatingText(String ratingText) {
    this.ratingText = ratingText;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public Float getRating() {
    return rating == null ? 0 : rating.floatValue();
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setRating(Double rating) {
    this.rating = rating;
  }

  public String getPhoto() {
    return photo;
  }

  public Location getLocation() {
    return location;
  }

  public String formatLocation() {
    String locationFormatted = "";
    if (location.getFormattedAddress() != null && !location.getFormattedAddress().isEmpty()) {
      locationFormatted = location.getFormattedAddress().get(0);
    } else {
      locationFormatted = location.getAddress() + "\n" + location.getState();
    }
    return locationFormatted;
  }

}