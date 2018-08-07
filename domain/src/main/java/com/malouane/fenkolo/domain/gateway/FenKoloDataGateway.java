package com.malouane.fenkolo.domain.gateway;

import com.malouane.fenkolo.domain.entity.Venue;

import java.util.List;

import io.reactivex.Observable;

public interface FenKoloDataGateway {
    Observable<List<Venue>> getVenues(int locationLatLong, String catId, String query, String radius);
}