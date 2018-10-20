package com.malouane.fenkolo.features.details.tips;

public class TipModel {
  private String text;
  private String agreeCount;
  private String disagreeCount;
  private String date;
  private String userName;
  private String photo;

  public TipModel(String text, String agreeCount, String disagreeCount, String date,
      String userName, String photo) {
    this.text = text;
    this.agreeCount = agreeCount;
    this.disagreeCount = disagreeCount;
    this.date = date;
    this.userName = userName;
    this.photo = photo;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getAgreeCount() {
    return agreeCount;
  }

  public void setAgreeCount(String agreeCount) {
    this.agreeCount = agreeCount;
  }

  public String getDisagreeCount() {
    return disagreeCount;
  }

  public void setDisagreeCount(String disagreeCount) {
    this.disagreeCount = disagreeCount;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getText() {
    return text;
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

