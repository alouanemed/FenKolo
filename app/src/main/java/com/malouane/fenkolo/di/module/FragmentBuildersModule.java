package com.malouane.fenkolo.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module public abstract class FragmentBuildersModule {
  @ContributesAndroidInjector abstract VenuesListFragment listFragment();
}