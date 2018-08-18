package com.malouane.fenkolo.startup;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import com.malouane.fenkolo.common.BaseAndroidViewModel;
import com.malouane.fenkolo.domain.entity.VenueType;
import com.malouane.fenkolo.domain.interactor.VenueTypeGetAllUseCase;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import java.util.List;

public class LaunchViewModel extends BaseAndroidViewModel {

  private MutableLiveData<Boolean> resultLiveData;
  private MutableLiveData<String> errorLiveData;

  private MutableLiveData<Boolean> result;
  private MutableLiveData<String> error;

  private VenueTypeGetAllUseCase getAllUseCase;
  private Context context;

  public LaunchViewModel(Application context, VenueTypeGetAllUseCase getAllUseCase) {
    super((Application) context.getApplicationContext());
    this.getAllUseCase = getAllUseCase;
    this.context = context;
    resultLiveData = new MutableLiveData<>();
    errorLiveData = new MutableLiveData<>();

    error = errorLiveData;
    result = resultLiveData;
  }

  public void startup() {
    addDisposable(getAllVenueCategories());
  }

  private Disposable getAllVenueCategories() {
    return getAllUseCase.perform(null).subscribeWith(new DisposableObserver<List<VenueType>>() {
      @Override public void onNext(List<VenueType> venueTypes) {
        result.setValue(true);
      }

      @Override public void onError(Throwable e) {
        error.setValue(e.getLocalizedMessage().isEmpty() ? context.getString(R.string.unknown_error)
            : e.getMessage());
      }

      @Override public void onComplete() {

      }
    });
  }

  public MutableLiveData<Boolean> getResult() {
    return result;
  }

  public MutableLiveData<String> getError() {
    return error;
  }
}
