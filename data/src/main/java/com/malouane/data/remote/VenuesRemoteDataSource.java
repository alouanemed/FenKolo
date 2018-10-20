package com.malouane.data.remote;

import com.malouane.data.remote.api.FenKoloApi;
import com.malouane.data.remote.model.VenueDetailsRemoteModel;
import com.malouane.data.remote.model.VenueRemoteModel;
import com.malouane.data.remote.model.VenueTipRemoteModel;
import io.reactivex.Observable;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class VenuesRemoteDataSource {
    private final FenKoloApi fenKoloApi;

  public Observable<List<VenueRemoteModel>> getVenues(String locationLatLong, String catId,
      String query, String radius) {
        return fenKoloApi.getVenues(locationLatLong, catId, query, radius);
    }

  public Observable<VenueDetailsRemoteModel> getVenueDetailsOf(String id) {
        return fenKoloApi.getVenueById(id);
  }

  public Observable<List<VenueTipRemoteModel>> getVenueTipsOf(String id) {
    return fenKoloApi.getVenueTipsOf(id);
  }

    public VenuesRemoteDataSource(@NotNull FenKoloApi fenKoloApi) {
        this.fenKoloApi = fenKoloApi;
    }
}
