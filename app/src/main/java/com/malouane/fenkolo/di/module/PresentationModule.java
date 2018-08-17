package com.malouane.fenkolo.di.module;

import android.content.Context;
import com.malouane.fenkolo.AppNavigator;
import com.malouane.fenkolo.di.ViewModelFactory;
import com.malouane.fenkolo.domain.interactor.VenueGetByTypeUseCase;
import com.malouane.fenkolo.domain.interactor.VenueTypeGetAllUseCase;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module public class PresentationModule {

  @Provides @Singleton private AppNavigator provideNavigator() {
    return new AppNavigator();
  }

  @Provides @Singleton
  private ViewModelFactory ViewModelFactory(VenueTypeGetAllUseCase typeGetAllUseCase,
      VenueGetByTypeUseCase byTypeUseCase, Context context) {
    return new ViewModelFactory(typeGetAllUseCase, byTypeUseCase, context);
  }
}
