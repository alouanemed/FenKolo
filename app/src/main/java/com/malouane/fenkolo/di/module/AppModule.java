package com.malouane.fenkolo.di.module;

import android.content.Context;
import com.malouane.fenkolo.DaggerApp;
import com.malouane.fenkolo.di.AppSchedulers;
import com.malouane.fenkolo.domain.common.Schedulers;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module public class AppModule {

  @Provides @Singleton Context providesContext(DaggerApp application) {
    return application.getApplicationContext();
  }

  @Provides @Singleton Schedulers provideSchedulers() {
    return new AppSchedulers();
  }
}