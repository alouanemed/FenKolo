package com.malouane.fenkolo.features.details;

import com.malouane.fenkolo.domain.entity.Location;
import com.malouane.fenkolo.domain.entity.VenueDetails;
import org.jetbrains.annotations.NotNull;

/**
 * Map Data entities to RV binding data
 */
class VenueDetailsMapper {
  VenueDetailsModel toLocal(@NotNull VenueDetails venue) {
    return new VenueDetailsModel(venue.getId(), venue.getName(), venue.getRating(), "",
        venue.getPhoto(), venue.getPrice(), venue.getLocation());
  }

  private String formatLocation(@NotNull Location location) {
    String locationFormatted = "";
    if (location.getFormattedAddress() != null && !location.getFormattedAddress().isEmpty()) {
      locationFormatted = location.getFormattedAddress().get(0);
    } else {
      locationFormatted = location.getAddress() + "\n" + location.getState();
    }
    return locationFormatted;
  }
}
