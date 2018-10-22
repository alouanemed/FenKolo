package com.malouane.fenkolo.di.module.features;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;
import com.malouane.fenkolo.di.scope.VenueScope;
import com.malouane.fenkolo.domain.common.Schedulers;
import com.malouane.fenkolo.domain.gateway.FenKoloDataGateway;
import com.malouane.fenkolo.domain.interactor.VenueGetDetailsUseCase;
import com.malouane.fenkolo.domain.interactor.VenueGetTipsUseCase;
import com.malouane.fenkolo.features.details.RestaurantDetailsViewModel;
import com.malouane.fenkolo.features.details.tips.TipsViewModel;
import dagger.Module;
import dagger.Provides;

@Module public class DetailsModule {
  @VenueScope @Provides
  public VenueGetDetailsUseCase provideVenueGetDetailsUseCase(FenKoloDataGateway gateway,
      Schedulers schedulers) {
    return new VenueGetDetailsUseCase(gateway, schedulers);
  }

  @VenueScope @Provides
  public VenueGetTipsUseCase provideVenueGetTipsUseCase(FenKoloDataGateway gateway,
      Schedulers schedulers) {
    return new VenueGetTipsUseCase(gateway, schedulers);
  }

  @VenueScope @Provides
  public final ViewModelProvider.Factory provideViewModelFactory(Context context,
      VenueGetDetailsUseCase useCase, VenueGetTipsUseCase tipsUseCase) {
    return (ViewModelProvider.Factory) (new ViewModelProvider.Factory() {
      @NonNull @Override public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(RestaurantDetailsViewModel.class)) {
          return (T) new RestaurantDetailsViewModel(context, useCase);
        }
        if (modelClass.isAssignableFrom(TipsViewModel.class)) {
          return (T) new TipsViewModel(context, tipsUseCase);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
      }
    });
  }
}
