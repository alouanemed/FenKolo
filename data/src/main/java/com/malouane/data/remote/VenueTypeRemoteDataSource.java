package com.malouane.data.remote;

import com.malouane.data.remote.api.FenKoloApi;
import com.malouane.data.remote.model.VenueTypeRemoteModel;
import io.reactivex.Observable;
import org.jetbrains.annotations.NotNull;

public class VenueTypeRemoteDataSource {
  private final FenKoloApi fenKoloApi;

  public Observable<VenueTypeRemoteModel> getAll() {
    return fenKoloApi.getVenueTypes();
  }

  public VenueTypeRemoteDataSource(@NotNull FenKoloApi fenKoloApi) {
    this.fenKoloApi = fenKoloApi;
  }
}
