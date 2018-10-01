package com.malouane.data.remote.model.venueDetails;

import com.squareup.moshi.Json;

public class Popular {

  @Json(name = "isOpen") private Boolean isOpen;
  @Json(name = "isLocalHoliday") private Boolean isLocalHoliday;/*
  @Json(name = "timeframes")
  private List<Timeframe_> timeframes = null;*/
}
