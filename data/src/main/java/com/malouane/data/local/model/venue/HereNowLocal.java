package com.malouane.data.local.model.venue;

import android.arch.persistence.room.Entity;

@Entity(tableName = "HereNow") public class HereNowLocal {
  private Integer count;
  private String summary;

  public HereNowLocal(Integer count, String summary) {
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
