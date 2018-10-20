package com.malouane.data.gateway.mapper;

import com.malouane.data.local.model.VenueDetailsLocalModel;
import com.malouane.data.local.model.VenueLocalModel;
import com.malouane.data.local.model.VenueTipsLocalModel;
import com.malouane.data.local.model.VenuesTypeLocalModel;
import com.malouane.data.local.model.venue.HereNowLocal;
import com.malouane.data.local.model.venue.LocationLocalModel;
import com.malouane.fenkolo.domain.entity.HereNow;
import com.malouane.fenkolo.domain.entity.Location;
import com.malouane.fenkolo.domain.entity.Venue;
import com.malouane.fenkolo.domain.entity.VenueDetails;
import com.malouane.fenkolo.domain.entity.VenueTip;
import com.malouane.fenkolo.domain.entity.VenueType;
import org.jetbrains.annotations.NotNull;

public class FenKoloDataMapper {

  public Venue venueToEntity(VenueLocalModel venue) {
    return new Venue(venue.getId(), venue.getName(),
        localLocationToEntity(venue.getLocationLocalModel()), venue.getVerified(),
        venue.getHasPerk(), localHereToEntity(venue.getHereNow()));
  }

  public VenueDetails venueDetailsToEntity(VenueDetailsLocalModel venue) {
    return new VenueDetails(venue.getId(), venue.getName(), venue.getRating(), venue.getPhoto(),
        localLocationToEntity(venue.getLocationLocalModel()), venue.getRatingText(),
        venue.getPrice());
  }

  public VenueType localVenueTypeToEntity(VenuesTypeLocalModel venue) {
    return new VenueType(venue.getId(), venue.getName());
  }

  private HereNow localHereToEntity(@NotNull HereNowLocal hereNow) {
    return new HereNow(hereNow.getCount(), hereNow.getSummary());
  }

  private Location localLocationToEntity(LocationLocalModel location) {
    return new Location(location.getAddress(), location.getCrossStreet(), location.getLat(),
        location.getLng(), location.getDistance(), location.getPostalCode(), location.getCc(),
        location.getCity(), location.getState(), location.getPostalCode(),
        location.getFormattedAddress());
  }

  public VenueTip tipToLocal(@NotNull VenueTipsLocalModel tip) {
    return new VenueTip(tip.getId(), "", tip.getCreatedAt(), tip.getText(),
        tip.getAgreeCount(), tip.getDisagreeCount(), tip.getUserName(), tip.getUserPhoto());
  }
}
