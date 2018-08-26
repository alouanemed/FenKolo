package com.malouane.data.local.model.venue;

import android.arch.persistence.room.Entity;

@Entity(tableName = "Icon")
public class Icon {
    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

  public Icon() {
  }
}
