package com.malouane.data.local.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Relation;
import android.arch.persistence.room.TypeConverters;

import com.malouane.data.local.CategoriesConverters;
import com.malouane.data.local.model.venue.Category;
import com.malouane.data.local.model.venue.LocationLocalModel;
import com.squareup.moshi.Json;

import java.util.List;

@Entity(tableName = "Venue")
@TypeConverters(CategoriesConverters.class)
public class VenueLocalModel {
    @PrimaryKey
    private String id;
    private String name;
    @Embedded
    private LocationLocalModel locationLocalModel;
    private List<Category> categories = null;
//    private List<Category> categories = null;
    private Boolean verified;
    //private Stats stats;
    private Boolean hasPerk;

    public VenueLocalModel(String id, String name, LocationLocalModel locationLocalModel, Boolean verified, Boolean hasPerk) {
        this.id = id;
        this.name = name;
        this.locationLocalModel = locationLocalModel;
        this.verified = verified;
        this.hasPerk = hasPerk;
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

}
