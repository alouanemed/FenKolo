package com.malouane.fenkolo.features.details.tips;

public class TipModel {
  private String text;
  private String likes;
  private String date;
  private String userName;
  private String photo;

  public TipModel(String text, String likes, String date, String userName, String photo) {
    this.text = text;
    this.likes = likes;
    this.date = date;
    this.userName = userName;
    this.photo = photo;
  }

  public String getText() {
    return text;
  }

  public String getLikes() {
    return likes;
  }

  public String getDate() {
    return date;
  }

  public String getUserName() {
    return userName;
  }

  public String getPhoto() {
    return photo;
  }
}

