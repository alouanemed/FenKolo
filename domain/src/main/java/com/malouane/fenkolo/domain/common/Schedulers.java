package com.malouane.fenkolo.domain.common;

import io.reactivex.Scheduler;

interface Schedulers {
  Scheduler subscribeOn();

  Scheduler observeOn();
}