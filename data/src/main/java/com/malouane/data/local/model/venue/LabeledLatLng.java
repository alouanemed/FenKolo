package com.malouane.data.local.model.venue;

import android.arch.persistence.room.Entity;
import com.squareup.moshi.Json;

@Entity(tableName = "LabeledLatLng")
public class LabeledLatLng{
    private String label;
    private Double lat;
    private Double lng;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

}
