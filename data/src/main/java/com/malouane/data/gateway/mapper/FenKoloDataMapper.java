package com.malouane.data.gateway.mapper;

import com.malouane.data.local.model.venue.LocationLocalModel;
import com.malouane.fenkolo.domain.entity.Venue;
import com.malouane.data.local.model.VenueLocalModel;
import com.malouane.data.remote.model.VenueRemoteModel;
import com.malouane.fenkolo.domain.entity.Location;

import org.jetbrains.annotations.NotNull;

public class FenKoloDataMapper {
    public final Venue toEntity(@NotNull VenueLocalModel venue) {
        return new Venue(venue.getId(), venue.getName(),  toEntity(venue.getLocationLocalModel()), venue.getVerified(), venue.getHasPerk());
    }

    public final Location toEntity(@NotNull LocationLocalModel location) {
        return new Location(
                location.getAddress(),
                location.getCrossStreet(),
                location.getLat(),
                location.getLng(),
                location.getDistance(),
                location.getPostalCode(),
                location.getCc(),
                location.getCity(),
                location.getState(),
                location.getPostalCode(),
                location.getFormattedAddress()
                );
    }
}
