package com.malouane.fenkolo.domain.interactor;

import com.malouane.fenkolo.domain.common.MissingParamsException;
import com.malouane.fenkolo.domain.common.Schedulers;
import com.malouane.fenkolo.domain.common.UseCase;
import com.malouane.fenkolo.domain.entity.VenueDetails;
import com.malouane.fenkolo.domain.gateway.FenKoloDataGateway;
import io.reactivex.Observable;

public class VenueGetTipsUseCase extends UseCase<CustomPair, VenueDetails> {
  private FenKoloDataGateway gateway;

  public VenueGetTipsUseCase(FenKoloDataGateway gateway, Schedulers schedulers) {
    super(schedulers);
    this.gateway = gateway;
  }

  @Override public Observable<VenueDetails> buildObservable(CustomPair input) {
    if (input == null) throw new MissingParamsException(VenueGetTipsUseCase.class);
    return gateway.getVenueDetails(input.getId(), input.isSecond());
  }
}