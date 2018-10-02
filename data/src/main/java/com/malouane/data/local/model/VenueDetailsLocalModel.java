package com.malouane.data.local.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import com.malouane.data.local.model.venue.LocationLocalModel;
import org.jetbrains.annotations.NotNull;

@Entity(tableName = "VenueDetails") public class VenueDetailsLocalModel {
  @PrimaryKey @NotNull private String id;
  private String name;
  @Embedded(prefix = "location_") private LocationLocalModel locationLocalModel;
  private Double rating;
  private String photo;
  private String price;
  private String ratingText;

  public VenueDetailsLocalModel(@NotNull String id, String name,
      LocationLocalModel locationLocalModel, Double rating, String photo, String price,
      String ratingText) {
    this.id = id;
    this.name = name;
    this.locationLocalModel = locationLocalModel;
    this.rating = rating;
    this.photo = photo;
    this.price = price;
    this.ratingText = ratingText;
  }

  public String getPrice() {
    return price;
  }

  public String getRatingText() {
    return ratingText;
  }

  @NonNull public String getId() {
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

  public LocationLocalModel getLocationLocalModel() {
    return locationLocalModel;
  }

  public void setLocationLocalModel(LocationLocalModel locationLocalModel) {
    this.locationLocalModel = locationLocalModel;
  }

  public Double getRating() {
    return rating;
  }

  public String getPhoto() {
    return photo;
  }
}