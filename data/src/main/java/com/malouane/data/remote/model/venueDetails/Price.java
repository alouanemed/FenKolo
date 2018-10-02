package com.malouane.data.remote.model.venueDetails;

import com.squareup.moshi.Json;

public class Price {
  @Json(name = "tier") private String tier;
  @Json(name = "message") private String message;
  @Json(name = "currency") private String currency;

  public String getTier() {
    return tier;
  }

  public String getMessage() {
    return message;
  }

  public String getCurrency() {
    return currency;
  }
}
