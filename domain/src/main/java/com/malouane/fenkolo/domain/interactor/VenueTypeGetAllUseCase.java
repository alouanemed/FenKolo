package com.malouane.fenkolo.domain.interactor;

import com.malouane.fenkolo.domain.common.Schedulers;
import com.malouane.fenkolo.domain.common.UseCase;
import com.malouane.fenkolo.domain.entity.VenueType;
import com.malouane.fenkolo.domain.gateway.FenKoloDataGateway;
import io.reactivex.Observable;
import java.util.List;

public class VenueTypeGetAllUseCase extends UseCase<Void, List<VenueType>> {
  private FenKoloDataGateway gateway;

  public VenueTypeGetAllUseCase(FenKoloDataGateway gateway, Schedulers schedulers) {
    super(schedulers);
    this.gateway = gateway;
  }

  @Override public Observable<List<VenueType>> buildObservable(Void input) {
    return gateway.getVenueTypes();
  }
}