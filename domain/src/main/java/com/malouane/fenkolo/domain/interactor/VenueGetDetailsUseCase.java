package com.malouane.fenkolo.domain.interactor;

import com.malouane.fenkolo.domain.common.MissingParamsException;
import com.malouane.fenkolo.domain.common.Schedulers;
import com.malouane.fenkolo.domain.common.UseCase;
import com.malouane.fenkolo.domain.entity.Venue;
import com.malouane.fenkolo.domain.entity.VenueDetails;
import com.malouane.fenkolo.domain.gateway.FenKoloDataGateway;
import io.reactivex.Observable;
import java.util.List;

public class VenueGetDetailsUseCase extends UseCase<CustomPair, VenueDetails> {
  private FenKoloDataGateway gateway;

  public VenueGetDetailsUseCase(FenKoloDataGateway gateway, Schedulers schedulers) {
    super(schedulers);
    this.gateway = gateway;
  }

  @Override public Observable<VenueDetails> buildObservable(CustomPair input) {
    if (input == null) throw new MissingParamsException(VenueGetDetailsUseCase.class);
    return gateway.getVenueDetails(input.getId());
  }
}