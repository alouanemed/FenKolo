package com.malouane.fenkolo.domain.entity;

public class HereNow {
  private Integer count;
  private String summary;

  public HereNow(Integer count, String summary) {
    this.count = count;
    this.summary = summary;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }
}
