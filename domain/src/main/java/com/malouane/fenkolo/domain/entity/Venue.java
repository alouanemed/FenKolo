package com.malouane.fenkolo.domain.entity;

public class Venue {
    private String id;
    private String name;
    private Location location;
    //    private List<Category> categories = null;
    private Boolean verified;
    //private Stats stats;
    private Boolean hasPerk;
  private HereNow hereNow;

  public Venue(String id, String name, Location location, Boolean verified, Boolean hasPerk,
      HereNow hereNow) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.verified = verified;
        this.hasPerk = hasPerk;
    this.hereNow = hereNow;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

  public HereNow getHereNow() {
    return hereNow;
  }
}
