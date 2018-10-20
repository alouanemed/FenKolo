package com.malouane.fenkolo.domain.interactor;

import com.malouane.fenkolo.domain.common.MissingParamsException;
import com.malouane.fenkolo.domain.common.Schedulers;
import com.malouane.fenkolo.domain.common.UseCase;
import com.malouane.fenkolo.domain.entity.VenueTip;
import com.malouane.fenkolo.domain.gateway.FenKoloDataGateway;
import io.reactivex.Observable;
import java.util.List;

public class VenueGetTipsUseCase extends UseCase<CustomPair, List<VenueTip>> {
  private FenKoloDataGateway gateway;

  public VenueGetTipsUseCase(FenKoloDataGateway gateway, Schedulers schedulers) {
    super(schedulers);
    this.gateway = gateway;
  }

  @Override public Observable<List<VenueTip>> buildObservable(CustomPair input) {
    if (input == null) throw new MissingParamsException(VenueGetTipsUseCase.class);
    return gateway.getVenueTips(input.getId(), input.isSecond());
  }
}