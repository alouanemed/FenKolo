package com.malouane.fenkolo.domain.entity;

public class VenueTip {
  private String id;
  private String photo;
  private int createdAt;
  private String text;
  private int agreeCount;
  private int disagreeCount;
  private String userName;
  private String userPhoto;

  public VenueTip(String id, String photo, int createdAt, String text, int agreeCount,
      int disagreeCount, String userName, String userPhoto) {
    this.id = id;
    this.photo = photo;
    this.createdAt = createdAt;
    this.text = text;
    this.agreeCount = agreeCount;
    this.disagreeCount = disagreeCount;
    this.userName = userName;
    this.userPhoto = userPhoto;
  }
}