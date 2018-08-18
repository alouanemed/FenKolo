package com.malouane.fenkolo.domain.interactor;

import com.malouane.fenkolo.domain.common.MissingParamsException;
import com.malouane.fenkolo.domain.common.Schedulers;
import com.malouane.fenkolo.domain.common.UseCase;
import com.malouane.fenkolo.domain.entity.Venue;
import com.malouane.fenkolo.domain.gateway.FenKoloDataGateway;
import io.reactivex.Observable;
import java.util.List;

public class VenueGetByTypeUseCase extends UseCase<CustomPair, List<Venue>> {
  private FenKoloDataGateway gateway;

  public VenueGetByTypeUseCase(FenKoloDataGateway gateway, Schedulers schedulers) {
    super(schedulers);
    this.gateway = gateway;
  }

  @Override public Observable<List<Venue>> buildObservable(CustomPair input) {
    if (input == null) throw new MissingParamsException(VenueGetByTypeUseCase.class);
    return gateway.getVenues(input.getLocationLatLong(), input.getCatId(), input.getQuery(),
        "", input.isSecond());
  }
}