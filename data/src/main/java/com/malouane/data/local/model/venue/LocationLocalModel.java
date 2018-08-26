package com.malouane.data.local.model.venue;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import java.util.List;

@Entity(tableName = "Location")
public class LocationLocalModel {
    //@PrimaryKey
    //private String id;
    private String address;
    private String crossStreet;
    private Double lat;
    private Double lng;
    private Integer distance;
    private String postalCode;
    private String cc;
    private String city;
    private String state;
    private String country;
  @Ignore private List<String> formattedAddress = null;

  public LocationLocalModel() {
  }

    public LocationLocalModel(String address, String crossStreet, Double lat, Double lng,
        Integer distance, String postalCode, String cc, String city, String state, String country) {
        this.address = address;
        this.crossStreet = crossStreet;
        this.lat = lat;
        this.lng = lng;
        this.distance = distance;
        this.postalCode = postalCode;
        this.cc = cc;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCrossStreet() {
        return crossStreet;
    }

    public void setCrossStreet(String crossStreet) {
        this.crossStreet = crossStreet;
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

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(List<String> formattedAddress) {
        this.formattedAddress = formattedAddress;
    }
}
