package com.malouane.fenkolo.common;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Context;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseAndroidViewModel extends AndroidViewModel {

  @SuppressLint("StaticFieldLeak") private Context context;
  private CompositeDisposable disposables;

  public BaseAndroidViewModel(Application context) {
    super(context);
    this.context = context;
    disposables = new CompositeDisposable();
  }

  public void addDisposable(Disposable disposable) {
    this.disposables.add(disposable);
  }

  @Override public void onCleared() {
    disposables.dispose();
  }
}

