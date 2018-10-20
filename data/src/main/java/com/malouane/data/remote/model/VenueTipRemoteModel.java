package com.malouane.data.remote.model;

import com.malouane.data.remote.model.tip.User;
import com.malouane.data.remote.model.venueDetails.Likes;
import com.squareup.moshi.Json;

public class VenueTipRemoteModel {
  @Json(name = "id")
  private String id;
  @Json(name = "createdAt")
  private Integer createdAt;
  @Json(name = "text")
  private String text;
  @Json(name = "lang")
  private String lang;
  @Json(name = "likes")
  private Likes likes;
  @Json(name = "agreeCount")
  private Integer agreeCount;
  @Json(name = "disagreeCount")
  private Integer disagreeCount;
  @Json(name = "user")
  private User user;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Integer createdAt) {
    this.createdAt = createdAt;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getLang() {
    return lang;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }

  public Likes getLikes() {
    return likes;
  }

  public void setLikes(Likes likes) {
    this.likes = likes;
  }

  public Integer getAgreeCount() {
    return agreeCount;
  }

  public void setAgreeCount(Integer agreeCount) {
    this.agreeCount = agreeCount;
  }

  public Integer getDisagreeCount() {
    return disagreeCount;
  }

  public void setDisagreeCount(Integer disagreeCount) {
    this.disagreeCount = disagreeCount;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}