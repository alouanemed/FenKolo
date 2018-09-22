package com.malouane.fenkolo.di.module;

import com.malouane.fenkolo.features.list.RestaurantListFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module public abstract class FragmentBuildersModule {
  @ContributesAndroidInjector abstract RestaurantListFragment listFragment();
}