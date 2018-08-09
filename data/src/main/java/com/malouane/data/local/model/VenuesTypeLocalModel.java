package com.malouane.data.local.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import com.malouane.data.local.CategoriesConverters;
import com.malouane.data.local.model.venue.Category;
import com.malouane.data.local.model.venue.LocationLocalModel;
import java.util.List;

@Entity(tableName = "VenueType")
public class VenuesTypeLocalModel {
    @PrimaryKey
    private String id;
    private String name;

    public VenuesTypeLocalModel(String id, String name) {
        this.id = id;
        this.name = name;
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
