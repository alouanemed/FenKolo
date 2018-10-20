package com.malouane.fenkolo.features.details.tips;

public class TipModel {
  private String id;
  private String text;
  private int agreeCount;
  private int disagreeCount;
  private int date;
  private String userName;
  private String userPhoto;
  private String photo;

  public TipModel(String id, String text, int agreeCount, int disagreeCount,
      int date, String userName, String photo, String userPhoto) {
    this.id = id;
    this.text = text;
    this.agreeCount = agreeCount;
    this.disagreeCount = disagreeCount;
    this.date = date;
    this.userName = userName;
    this.photo = photo;
    this.userPhoto = userPhoto;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getText() {
    return text;
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

  public int getDate() {
    return date;
  }

  public void setDate(int date) {
    this.date = date;
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

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getUserName() {
    return userName;
  }

  public String getPhoto() {
    return photo;
  }
}

