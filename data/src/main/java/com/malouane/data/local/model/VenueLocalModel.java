package com.malouane.data.local.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;
import com.malouane.data.local.CategoriesConverters;
import com.malouane.data.local.model.venue.Category;
import com.malouane.data.local.model.venue.HereNowLocal;
import com.malouane.data.local.model.venue.LocationLocalModel;
import java.util.List;
import org.jetbrains.annotations.NotNull;

@Entity(tableName = "Venue")
@TypeConverters(CategoriesConverters.class)
public class VenueLocalModel {
    @PrimaryKey @NotNull
    private String id;
    private String name;
  @Embedded(prefix = "location_")
    private LocationLocalModel locationLocalModel;
    private List<Category> categories = null;
    private Boolean verified;
    private Boolean hasPerk;
  private HereNowLocal hereNow;


  public VenueLocalModel(String id, String name, LocationLocalModel locationLocalModel,
      Boolean verified, Boolean hasPerk, HereNowLocal hereNow) {
        this.id = id;
        this.name = name;
        this.locationLocalModel = locationLocalModel;
        this.hasPerk = hasPerk;
    this.hereNow = hereNow;
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

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Boolean getHasPerk() {
        return hasPerk;
    }

    public void setHasPerk(Boolean hasPerk) {
        this.hasPerk = hasPerk;
    }

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }

  public HereNowLocal getHereNow() {
    return hereNow;
  }
}
