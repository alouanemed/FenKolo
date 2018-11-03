package com.malouane.fenkolo;

import android.app.Activity;
import android.content.Context;
import android.support.multidex.MultiDex;
import com.facebook.stetho.Stetho;
import com.orhanobut.hawk.Hawk;
import dagger.android.DispatchingAndroidInjector;
import io.reactivex.plugins.RxJavaPlugins;
import javax.inject.Inject;
import timber.log.Timber;

public class FenKoloApp extends DaggerApp {

  @Inject DispatchingAndroidInjector<Activity> activityDispatchingInjector;

  public static final String FEN_KOLO_PRES = "FEN_KOLO_PRES";
  public static final String KEY_LOCATION = "KEY_LOCATION";

  @Override public void attachBaseContext(Context context) {
    super.attachBaseContext(context);
    MultiDex.install(this);
  }

  @Override public void onCreate() {
    super.onCreate();

    Timber.plant(new Timber.DebugTree());

    Stetho.initializeWithDefaults(this);

    RxJavaPlugins.setErrorHandler(Timber::e);

    Hawk.init(this).build();
  }
}