package com.malouane.fenkolo.di.module;

import com.malouane.fenkolo.domain.common.Schedulers;
import com.malouane.fenkolo.domain.gateway.FenKoloDataGateway;
import com.malouane.fenkolo.domain.interactor.VenueGetByTypeUseCase;
import com.malouane.fenkolo.domain.interactor.VenueGetDetailsUseCase;
import com.malouane.fenkolo.domain.interactor.VenueTypeGetAllUseCase;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module public class DomainModule {

  @Provides @Singleton
  public VenueGetByTypeUseCase provideVenueGetByTypeUseCase(FenKoloDataGateway gateway,
      Schedulers schedulers) {
    return new VenueGetByTypeUseCase(gateway, schedulers);
  }

  @Provides @Singleton
  public VenueTypeGetAllUseCase provideVenueTypeGetAllUseCase(FenKoloDataGateway gateway,
      Schedulers schedulers) {
    return new VenueTypeGetAllUseCase(gateway, schedulers);
  }

  @Provides @Singleton
  public VenueGetDetailsUseCase provideVenueGetDetailsUseCase(FenKoloDataGateway gateway,
      Schedulers schedulers) {
    return new VenueGetDetailsUseCase(gateway, schedulers);
  }
}
