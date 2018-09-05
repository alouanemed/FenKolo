package com.malouane.fenkolo.di.module.features;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;
import com.malouane.fenkolo.di.scope.StartupScope;
import com.malouane.fenkolo.domain.common.Schedulers;
import com.malouane.fenkolo.domain.gateway.FenKoloDataGateway;
import com.malouane.fenkolo.domain.interactor.VenueTypeGetAllUseCase;
import com.malouane.fenkolo.features.categories.CategoriesViewModel;
import com.malouane.fenkolo.startup.LaunchViewModel;
import dagger.Module;
import dagger.Provides;

@Module public class StartupModule {

  @StartupScope @Provides
  public VenueTypeGetAllUseCase provideVenueTypeGetAllUseCase(FenKoloDataGateway gateway,
      Schedulers schedulers) {
    return new VenueTypeGetAllUseCase(gateway, schedulers);
  }

  @Provides public final ViewModelProvider.Factory provideViewModelFactory(Context context,
      VenueTypeGetAllUseCase useCase) {
    return (ViewModelProvider.Factory) (new ViewModelProvider.Factory() {
      @NonNull @Override public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LaunchViewModel.class)) {
          return (T) new LaunchViewModel(context, useCase);
        }
        if (!modelClass.isAssignableFrom(CategoriesViewModel.class)) {
          return (T) (new CategoriesViewModel(context, useCase));
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
      }
    });
  }
}
