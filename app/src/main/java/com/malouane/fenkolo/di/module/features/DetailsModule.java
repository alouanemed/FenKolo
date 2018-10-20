package com.malouane.fenkolo.di.module.features;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;
import com.malouane.fenkolo.di.scope.VenueScope;
import com.malouane.fenkolo.domain.common.Schedulers;
import com.malouane.fenkolo.domain.gateway.FenKoloDataGateway;
import com.malouane.fenkolo.domain.interactor.VenueGetDetailsUseCase;
import com.malouane.fenkolo.features.details.RestaurantDetailsViewModel;
import dagger.Module;
import dagger.Provides;

@Module public class DetailsModule {
  //@ContributesAndroidInjector abstract TipsFragment tipsFragment();


  @VenueScope @Provides
  public VenueGetDetailsUseCase provideVenueGetDetailsUseCase(FenKoloDataGateway gateway,
      Schedulers schedulers) {
    return new VenueGetDetailsUseCase(gateway, schedulers);
  }

  @VenueScope @Provides
  public final ViewModelProvider.Factory provideViewModelFactory(Context context,
      VenueGetDetailsUseCase useCase) {
    return (ViewModelProvider.Factory) (new ViewModelProvider.Factory() {
      @NonNull @Override public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(RestaurantDetailsViewModel.class)) {
          return (T) new RestaurantDetailsViewModel(context, useCase);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
      }
    });
  }
}
