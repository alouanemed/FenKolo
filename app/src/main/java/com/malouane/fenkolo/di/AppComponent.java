package com.malouane.fenkolo.di;

import com.malouane.fenkolo.DaggerApp;
import com.malouane.fenkolo.di.module.AppModule;
import com.malouane.fenkolo.di.module.DataModule;
import com.malouane.fenkolo.di.module.DomainModule;
import com.malouane.fenkolo.di.module.FragmentBuildersModule;
import com.malouane.fenkolo.di.module.PresentationModule;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Singleton;

@Singleton @Component(modules = {
    AndroidSupportInjectionModule.class, ActivityBuilderModule.class, FragmentBuildersModule.class,
    AppModule.class, PresentationModule.class, DomainModule.class, DataModule.class
}) public interface AppComponent extends AndroidInjector<DaggerApp> {

  @Component.Builder abstract class Builder extends AndroidInjector.Builder<DaggerApp> {
  }
}
