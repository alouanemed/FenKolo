package com.malouane.fenkolo.di.module.features;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;
import com.malouane.fenkolo.di.scope.HomeScope;
import com.malouane.fenkolo.domain.common.Schedulers;
import com.malouane.fenkolo.domain.gateway.FenKoloDataGateway;
import com.malouane.fenkolo.domain.interactor.VenueGetByTypeUseCase;
import com.malouane.fenkolo.domain.interactor.VenueTypeGetAllUseCase;
import com.malouane.fenkolo.features.categories.CategoriesViewModel;
import com.malouane.fenkolo.features.list.RestaurantListFragment;
import com.malouane.fenkolo.features.list.RestaurantListViewModel;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module public abstract class HomeModule {
  @HomeScope @Provides
  public static VenueTypeGetAllUseCase provideVenueTypeGetAllUseCase(FenKoloDataGateway gateway,
      Schedulers schedulers) {
    return new VenueTypeGetAllUseCase(gateway, schedulers);
  }

  @HomeScope @Provides
  public static VenueGetByTypeUseCase provideVenueGetByTypeUseCase(FenKoloDataGateway gateway,
      Schedulers schedulers) {
    return new VenueGetByTypeUseCase(gateway, schedulers);
  }

  @HomeScope @Provides
  public static ViewModelProvider.Factory provideViewModelFactory(Context context,
      VenueTypeGetAllUseCase venueTypeGetAllUseCase, VenueGetByTypeUseCase venueGetByTypeUseCase) {
    return (ViewModelProvider.Factory) (new ViewModelProvider.Factory() {
      @NonNull @Override public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CategoriesViewModel.class)) {
          return (T) new CategoriesViewModel(context, venueTypeGetAllUseCase);
        }
        if (modelClass.isAssignableFrom(RestaurantListViewModel.class)) {
          return (T) (new RestaurantListViewModel(context, venueGetByTypeUseCase));
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
      }
    });
  }

  @ContributesAndroidInjector abstract RestaurantListFragment listFragment();
}
