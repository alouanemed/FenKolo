package com.malouane.data.remote.model;

import com.malouane.data.remote.model.venue.BeenHere;
import com.malouane.data.remote.model.venue.Contact;
import com.malouane.data.remote.model.venue.LocationRemoteModel;
import com.malouane.data.remote.model.venue.Stats;
import com.malouane.data.remote.model.venueDetails.BestPhoto;
import com.malouane.data.remote.model.venueDetails.Hours;
import com.malouane.data.remote.model.venueDetails.Likes;
import com.malouane.data.remote.model.venueDetails.Popular;
import com.malouane.data.remote.model.venueDetails.Price;
import com.squareup.moshi.Json;

public class VenueDetailsRemoteModel {
  @Json(name = "id") private String id;
  @Json(name = "name") private String name;
  @Json(name = "contact") private Contact contact;
  @Json(name = "location") private LocationRemoteModel location;
  @Json(name = "canonicalUrl") private String canonicalUrl;
  @Json(name = "verified") private Boolean verified;
  @Json(name = "stats") private Stats stats;
  @Json(name = "url") private String url;
  @Json(name = "price") private Price price;
  @Json(name = "hasMenu") private Boolean hasMenu;
  @Json(name = "likes") private Likes likes;
  @Json(name = "dislike") private Boolean dislike;
  @Json(name = "ok") private Boolean ok;
  @Json(name = "rating") private Double rating;
  @Json(name = "ratingColor") private String ratingColor;
  @Json(name = "ratingSignals") private Integer ratingSignals;
  @Json(name = "allowMenuUrlEdit") private Boolean allowMenuUrlEdit;
  @Json(name = "beenHere") private BeenHere beenHere;
  @Json(name = "createdAt") private Integer createdAt;
  @Json(name = "shortUrl") private String shortUrl;
  @Json(name = "timeZone") private String timeZone;
  @Json(name = "hours") private Hours hours;
  @Json(name = "popular") private Popular popular;
  @Json(name = "bestPhoto") private BestPhoto bestPhoto;

  public VenueDetailsRemoteModel(String id, String name, Contact contact,
      LocationRemoteModel location, String canonicalUrl, Boolean verified, Stats stats, String url,
      Price price, Boolean hasMenu, Likes likes, Boolean dislike, Boolean ok, Double rating,
      String ratingColor, Integer ratingSignals, Boolean allowMenuUrlEdit, BeenHere beenHere,
      Integer createdAt, String shortUrl, String timeZone, Hours hours, Popular popular,
      BestPhoto bestPhoto) {
    this.id = id;
    this.name = name;
    this.contact = contact;
    this.location = location;
    this.canonicalUrl = canonicalUrl;
    this.verified = verified;
    this.stats = stats;
    this.url = url;
    this.price = price;
    this.hasMenu = hasMenu;
    this.likes = likes;
    this.dislike = dislike;
    this.ok = ok;
    this.rating = rating;
    this.ratingColor = ratingColor;
    this.ratingSignals = ratingSignals;
    this.allowMenuUrlEdit = allowMenuUrlEdit;
    this.beenHere = beenHere;
    this.createdAt = createdAt;
    this.shortUrl = shortUrl;
    this.timeZone = timeZone;
    this.hours = hours;
    this.popular = popular;
    this.bestPhoto = bestPhoto;
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

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }

  public LocationRemoteModel getLocation() {
    return location;
  }

  public void setLocation(LocationRemoteModel location) {
    this.location = location;
  }

  public String getCanonicalUrl() {
    return canonicalUrl;
  }

  public void setCanonicalUrl(String canonicalUrl) {
    this.canonicalUrl = canonicalUrl;
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

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }

  public Boolean getHasMenu() {
    return hasMenu;
  }

  public void setHasMenu(Boolean hasMenu) {
    this.hasMenu = hasMenu;
  }

  public Likes getLikes() {
    return likes;
  }

  public void setLikes(Likes likes) {
    this.likes = likes;
  }

  public Boolean getDislike() {
    return dislike;
  }

  public void setDislike(Boolean dislike) {
    this.dislike = dislike;
  }

  public Boolean getOk() {
    return ok;
  }

  public void setOk(Boolean ok) {
    this.ok = ok;
  }

  public Double getRating() {
    return rating;
  }

  public void setRating(Double rating) {
    this.rating = rating;
  }

  public String getRatingColor() {
    return ratingColor;
  }

  public void setRatingColor(String ratingColor) {
    this.ratingColor = ratingColor;
  }

  public Integer getRatingSignals() {
    return ratingSignals;
  }

  public void setRatingSignals(Integer ratingSignals) {
    this.ratingSignals = ratingSignals;
  }

  public Boolean getAllowMenuUrlEdit() {
    return allowMenuUrlEdit;
  }

  public void setAllowMenuUrlEdit(Boolean allowMenuUrlEdit) {
    this.allowMenuUrlEdit = allowMenuUrlEdit;
  }

  public BeenHere getBeenHere() {
    return beenHere;
  }

  public void setBeenHere(BeenHere beenHere) {
    this.beenHere = beenHere;
  }

  public Integer getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Integer createdAt) {
    this.createdAt = createdAt;
  }

  public String getShortUrl() {
    return shortUrl;
  }

  public void setShortUrl(String shortUrl) {
    this.shortUrl = shortUrl;
  }

  public String getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }

  public Hours getHours() {
    return hours;
  }

  public void setHours(Hours hours) {
    this.hours = hours;
  }

  public Popular getPopular() {
    return popular;
  }

  public void setPopular(Popular popular) {
    this.popular = popular;
  }

  public BestPhoto getBestPhoto() {
    return bestPhoto;
  }

  public void setBestPhoto(BestPhoto bestPhoto) {
    this.bestPhoto = bestPhoto;
  }
}