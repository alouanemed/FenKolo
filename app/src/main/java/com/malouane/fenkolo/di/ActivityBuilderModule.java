package com.malouane.fenkolo.di;

import com.malouane.fenkolo.di.module.features.DetailsModule;
import com.malouane.fenkolo.di.module.features.HomeModule;
import com.malouane.fenkolo.di.module.features.StartupModule;
import com.malouane.fenkolo.di.scope.HomeScope;
import com.malouane.fenkolo.di.scope.StartupScope;
import com.malouane.fenkolo.di.scope.VenueScope;
import com.malouane.fenkolo.features.details.RestaurantDetailsActivity;
import com.malouane.fenkolo.home.HomeActivity;
import com.malouane.fenkolo.startup.LaunchActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module abstract class ActivityBuilderModule {

  @StartupScope @ContributesAndroidInjector(modules = StartupModule.class)
  abstract LaunchActivity launchActivity();

  @HomeScope @ContributesAndroidInjector(modules = HomeModule.class)
  abstract HomeActivity homeActivity();

  @VenueScope @ContributesAndroidInjector(modules = DetailsModule.class)
  abstract RestaurantDetailsActivity restaurantDetailsActivity();
}
