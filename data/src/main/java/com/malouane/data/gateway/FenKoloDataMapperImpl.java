package com.malouane.data.gateway;

import com.example.fenkolo.domain.entity.Venue;
import com.malouane.data.local.model.VenueLocalModel;
import com.malouane.data.remote.model.VenueRemoteModel;
import com.malouane.fenkolo.domain.entity.Venue;
import com.malouane.fenkolo.domain.gateway.FenKoloDataGateway;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;

public class FenKoloDataMapperImpl implements FenKoloDataGateway {

    @Override
    public Observable<List<Venue>> getVenues(int locationLatLong, String catId, String query, String radius) {
        return null;
    }
}
