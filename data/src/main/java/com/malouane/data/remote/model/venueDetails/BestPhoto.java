package com.malouane.data.remote.model.venueDetails;

import com.squareup.moshi.Json;

public class BestPhoto {

  @Json(name = "id") private String id;
  @Json(name = "prefix") private String prefix;
  @Json(name = "suffix") private String suffix;
  @Json(name = "width") private Integer width;
  @Json(name = "height") private Integer height;

  public String getPhotoURl() {
    return prefix + suffix;
  }
}
