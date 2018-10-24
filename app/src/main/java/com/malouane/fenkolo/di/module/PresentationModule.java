package com.malouane.fenkolo.di.module;

import com.malouane.fenkolo.AppNavigator;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module public class PresentationModule {

  @Provides @Singleton public AppNavigator provideNavigator() {
    return new AppNavigator();
  }

}