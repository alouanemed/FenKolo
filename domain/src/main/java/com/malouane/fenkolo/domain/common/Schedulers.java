package com.malouane.fenkolo.domain.common;

import io.reactivex.Scheduler;

public interface Schedulers {
  Scheduler subscribeOn();

  Scheduler observeOn();
}