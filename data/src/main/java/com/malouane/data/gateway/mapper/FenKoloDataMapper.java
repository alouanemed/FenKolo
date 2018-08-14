package com.malouane.data.gateway.mapper;

import com.malouane.data.local.model.VenueLocalModel;
import com.malouane.data.local.model.VenuesTypeLocalModel;
import com.malouane.data.local.model.venue.LocationLocalModel;
import com.malouane.fenkolo.domain.entity.Location;
import com.malouane.fenkolo.domain.entity.Venue;
import com.malouane.fenkolo.domain.entity.VenueType;

public class FenKoloDataMapper {
  public final Venue toEntity(VenueLocalModel venue) {
    return new Venue(venue.getId(), venue.getName(), toEntity(venue.getLocationLocalModel()),
        venue.getVerified(), venue.getHasPerk());
  }

  public final VenueType toEntity(VenuesTypeLocalModel venue) {
    return new VenueType(venue.getId(), venue.getName());
  }

  Location toEntity(LocationLocalModel location) {
    return new Location(location.getAddress(), location.getCrossStreet(), location.getLat(),
        location.getLng(), location.getDistance(), location.getPostalCode(), location.getCc(),
        location.getCity(), location.getState(), location.getPostalCode(),
        location.getFormattedAddress());
  }
}
