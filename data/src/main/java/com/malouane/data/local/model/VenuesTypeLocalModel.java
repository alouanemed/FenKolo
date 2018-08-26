package com.malouane.data.local.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "VenueType")
public class VenuesTypeLocalModel {
  @PrimaryKey @NonNull private String id = "";
    private String name;

    public VenuesTypeLocalModel(String id, String name) {

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
}
