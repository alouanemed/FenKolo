package com.malouane.data.remote.model.venueDetails;

import com.squareup.moshi.Json;

public class Price {

  @Json(name = "phone") private String phone;
  @Json(name = "formattedPhone") private String formattedPhone;
  @Json(name = "instagram") private String instagram;
}
