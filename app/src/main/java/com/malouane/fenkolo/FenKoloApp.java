package com.malouane.fenkolo;

import android.app.Activity;
import android.content.Context;
import android.support.multidex.MultiDex;
import com.facebook.stetho.Stetho;
import dagger.android.DispatchingAndroidInjector;
import io.reactivex.plugins.RxJavaPlugins;
import javax.inject.Inject;
import timber.log.Timber;

public class FenKoloApp extends DaggerApp {

  @Inject DispatchingAndroidInjector<Activity> activityDispatchingInjector;

  @Override public void attachBaseContext(Context context) {
    super.attachBaseContext(context);
    MultiDex.install(this);
  }


  @Override public void onCreate() {
    super.onCreate();

    Stetho.initializeWithDefaults(this);

    RxJavaPlugins.setErrorHandler(Timber::e);
  }
}