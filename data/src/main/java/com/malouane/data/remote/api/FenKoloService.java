package com.malouane.data.remote.api;

import com.malouane.data.remote.model.VenueRemoteModel;
import com.malouane.data.remote.model.VenueTypeRemoteModel;
import com.serjltt.moshi.adapters.Wrapped;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface FenKoloService {
  @GET("venues/search") @Wrapped(path = { "response", "venues" })
  Observable<List<VenueRemoteModel>> getVenues(@Query("ll") int locationLatLong,
      @Query("categoryId") String catId, @Query("query") String query,
      @Query("radius") String radius //default : 250
  );

  @GET("venues/search") @Wrapped(path = { "response", "venues" })
  Observable<List<VenueTypeRemoteModel>> getVenueTypes();
}