package com.malouane.data.local.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import org.jetbrains.annotations.NotNull;

@Entity(tableName = "VenueTips") public class VenueTipsLocalModel {
  @PrimaryKey @NotNull private String id;
  private String photo;
  private int createdAt;
  private String text;
  private int agreeCount;
  private int disagreeCount;
  private String userName;
  private String userPhoto;

  public VenueTipsLocalModel(@NotNull String id, String photo, int createdAt, String text,
      int agreeCount, int disagreeCount, String userName, String userPhoto) {
    this.id = id;
    this.photo = photo;
    this.createdAt = createdAt;
    this.text = text;
    this.agreeCount = agreeCount;
    this.disagreeCount = disagreeCount;
    this.userName = userName;
    this.userPhoto = userPhoto;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public int getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(int createdAt) {
    this.createdAt = createdAt;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getAgreeCount() {
    return agreeCount;
  }

  public void setAgreeCount(int agreeCount) {
    this.agreeCount = agreeCount;
  }

  public int getDisagreeCount() {
    return disagreeCount;
  }

  public void setDisagreeCount(int disagreeCount) {
    this.disagreeCount = disagreeCount;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPhoto() {
    return userPhoto;
  }

  public void setUserPhoto(String userPhoto) {
    this.userPhoto = userPhoto;
  }
}