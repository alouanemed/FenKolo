package com.malouane.fenkolo.di.module;

import com.malouane.fenkolo.features.list.CategoriesListFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module public abstract class FragmentBuildersModule {
  @ContributesAndroidInjector abstract CategoriesListFragment listFragment();
}