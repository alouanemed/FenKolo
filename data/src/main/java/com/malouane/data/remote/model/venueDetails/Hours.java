package com.malouane.data.remote.model.venueDetails;

import com.squareup.moshi.Json;

public class Hours {

  @Json(name = "status") private String status;
  @Json(name = "isOpen") private Boolean isOpen;
}
