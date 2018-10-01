package com.malouane.data.repository.mapper;

import com.malouane.data.local.model.VenueLocalModel;
import com.malouane.data.local.model.venue.HereNowLocal;
import com.malouane.data.local.model.venue.LocationLocalModel;
import com.malouane.data.remote.model.VenueRemoteModel;
import com.malouane.data.remote.model.venue.HereNowRemote;
import com.malouane.data.remote.model.venue.LocationRemoteModel;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

//**
/* Map remote entities to local one
 */
public class VenueDetailsMapper {
  public VenueLocalModel toLocal(@NotNull VenueRemoteModel venue) {
    return new VenueLocalModel(venue.getId(), venue.getName(),
        remoteLocationTolocal(venue.getLocationRemoteModel()), venue.getVerified(),
        venue.getHasPerk(), remoteHereTolocal(venue.getHereNow()));
  }

  @NotNull public List<VenueLocalModel> toLocal(@NotNull List<VenueRemoteModel> items) {
    List<VenueLocalModel> outputList = new ArrayList<VenueLocalModel>();

    for (VenueRemoteModel item : items) {
      outputList.add(toLocal(item));
    }

    return outputList;
  }

  private LocationLocalModel remoteLocationTolocal(@NotNull LocationRemoteModel location) {
    return new LocationLocalModel(location.getAddress(), location.getCrossStreet(),
        location.getLat(), location.getLng(), location.getDistance(), location.getPostalCode(),
        location.getCc(), location.getCity(), location.getState(), location.getPostalCode());
  }

  private HereNowLocal remoteHereTolocal(@NotNull HereNowRemote hereNow) {
    return new HereNowLocal(hereNow.getCount(), hereNow.getSummary());
  }
}
