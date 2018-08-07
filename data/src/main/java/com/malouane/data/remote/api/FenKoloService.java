package com.malouane.data.remote.api;

import com.malouane.data.remote.model.VenueRemoteModel;
import com.serjltt.moshi.adapters.Wrapped;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface FenKoloService {
    @GET("venues/search")
    @Wrapped(path = {"response", "venues"})
    Observable<List<VenueRemoteModel>> getVenues(@Query("ll") int locationLatLong,
                                                 @Query("categoryId") String catId,
                                                 @Query("query") String query,
                                                 @Query("radius") String radius //default : 250
    );
}