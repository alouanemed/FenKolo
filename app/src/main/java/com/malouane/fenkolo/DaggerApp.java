package com.malouane.fenkolo;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;
import javax.inject.Inject;

public abstract class DaggerApp extends Application
    implements HasActivityInjector, HasSupportFragmentInjector {
  @Inject DispatchingAndroidInjector<Activity> activityInjector;
  @Inject DispatchingAndroidInjector<Fragment> fragmentInjector;

  @Override public DispatchingAndroidInjector<Activity> activityInjector() {
    return activityInjector;
  }

  @Override public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
    return fragmentInjector;
  }

  @Override public void onCreate() {
    super.onCreate();
    DaggerApplicationComponent.builder().create(this).inject(this);
  }
}
