package com.malouane.data.remote.model;

import com.malouane.data.remote.model.venue.BeenHere;
import com.malouane.data.remote.model.venue.Category;
import com.malouane.data.remote.model.venue.Contact;
import com.malouane.data.remote.model.venue.HereNowRemote;
import com.malouane.data.remote.model.venue.LocationRemoteModel;
import com.malouane.data.remote.model.venue.Stats;
import com.malouane.data.remote.model.venue.VenuePage;
import com.squareup.moshi.Json;
import java.util.List;
public class VenueRemoteModel {
    @Json(name = "id")
    private String id;
    @Json(name = "name")
    private String name;
    @Json(name = "contact")
    private Contact contact;
    @Json(name = "location")
    private LocationRemoteModel locationRemoteModel;
    @Json(name = "categories")
    private List<Category> categories = null;
    @Json(name = "verified")
    private Boolean verified;
    @Json(name = "stats")
    private Stats stats;
    @Json(name = "beenHere")
    private BeenHere beenHere;
    @Json(name = "venuePage")
    private VenuePage venuePage;
    @Json(name = "hereNow") private HereNowRemote hereNow;
    @Json(name = "referralId")
    private String referralId;
    @Json(name = "venueChains")
    private List<Object> venueChains = null;
    @Json(name = "hasPerk")
    private Boolean hasPerk;

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

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public LocationRemoteModel getLocationRemoteModel() {
        return locationRemoteModel;
    }

    public void setLocationRemoteModel(LocationRemoteModel locationRemoteModel) {
        this.locationRemoteModel = locationRemoteModel;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public BeenHere getBeenHere() {
        return beenHere;
    }

    public void setBeenHere(BeenHere beenHere) {
        this.beenHere = beenHere;
    }

    public VenuePage getVenuePage() {
        return venuePage;
    }

    public void setVenuePage(VenuePage venuePage) {
        this.venuePage = venuePage;
    }

  public HereNowRemote getHereNow() {
        return hereNow;
    }

  public void setHereNow(HereNowRemote hereNow) {
        this.hereNow = hereNow;
    }

    public String getReferralId() {
        return referralId;
    }

    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }

    public List<Object> getVenueChains() {
        return venueChains;
    }

    public void setVenueChains(List<Object> venueChains) {
        this.venueChains = venueChains;
    }

    public Boolean getHasPerk() {
        return hasPerk;
    }

    public void setHasPerk(Boolean hasPerk) {
        this.hasPerk = hasPerk;
    }

}

