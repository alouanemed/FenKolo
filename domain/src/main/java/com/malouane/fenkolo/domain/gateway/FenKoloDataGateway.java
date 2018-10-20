package com.malouane.fenkolo.domain.gateway;

import com.malouane.fenkolo.domain.entity.Venue;
import com.malouane.fenkolo.domain.entity.VenueDetails;
import com.malouane.fenkolo.domain.entity.VenueType;
import io.reactivex.Observable;
import java.util.List;

public interface FenKoloDataGateway {
  Observable<List<Venue>> getVenues(String locationLatLong, String catId, String query,
        String radius, boolean refresh);

    Observable<List<VenueType>> getVenueTypes();

  Observable<VenueDetails> getVenueDetails(String id, boolean refresh);

  Observable<VenueDetails> getVenueTips(String id, boolean refresh);
}