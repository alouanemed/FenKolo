package com.malouane.fenkolo.di;

import com.malouane.fenkolo.domain.common.Schedulers;
import io.reactivex.Scheduler;

class AppSchedulers implements Schedulers {
  @Override public Scheduler subscribeOn() {
    return io.reactivex.schedulers.Schedulers.io();
  }

  @Override public Scheduler observeOn() {
    return io.reactivex.android.schedulers.AndroidSchedulers.mainThread();
  }
}
