package com.malouane.fenkolo.di;

import com.malouane.fenkolo.home.HomeActivity;
import com.malouane.fenkolo.startup.LaunchActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module public abstract class ActivityBuilderModule {
  @ContributesAndroidInjector() abstract LaunchActivity launchActivity();

  @ContributesAndroidInjector() abstract HomeActivity homeActivity();

  //@ContributesAndroidInjector() abstract MainActivity mainActivity();
}
