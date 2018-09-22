package com.malouane.fenkolo.features.list;

import com.malouane.fenkolo.domain.entity.Location;
import com.malouane.fenkolo.domain.entity.Venue;
import org.jetbrains.annotations.NotNull;

/**
 * Map Data entities to RV binding data
 */
class VenueMapper {
  VenueModel toLocal(@NotNull Venue venue) {
    return new VenueModel(venue.getId(), venue.getName(), formatLocation(venue),
        venue.getLocation().getDistance(), venue.getHereNow().getSummary());
  }

  private String formatLocation(@NotNull Venue venue) {
    String locationFormatted = "";
    Location location = venue.getLocation();
    if (location.getFormattedAddress() != null && !location.getFormattedAddress().isEmpty()) {
      locationFormatted = location.getFormattedAddress().get(0);
    } else {
      locationFormatted = venue.getLocation().getAddress() + "\n" + location.getState();
    }
    return locationFormatted;
  }
}
