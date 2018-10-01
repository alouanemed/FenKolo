package com.malouane.fenkolo.features.categories;

import android.app.Application;
import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import com.malouane.fenkolo.R;
import com.malouane.fenkolo.common.BaseAndroidViewModel;
import com.malouane.fenkolo.domain.entity.VenueType;
import com.malouane.fenkolo.domain.interactor.VenueTypeGetAllUseCase;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

public class CategoriesViewModel extends BaseAndroidViewModel {
  private final ObservableBoolean loading;
  private final ObservableArrayList<VenueType> result;
  private final ObservableBoolean empty;
  private final ObservableField<String> error;
  private VenueTypeGetAllUseCase getAllUseCase;
  private Context context;

  public CategoriesViewModel(Context context, VenueTypeGetAllUseCase getAllUseCase) {
    super((Application) context.getApplicationContext());
    this.context = context;
    this.loading = new ObservableBoolean();
    this.result = new ObservableArrayList<VenueType>();
    this.empty = new ObservableBoolean();
    this.error = new ObservableField<String>();
    this.getAllUseCase = getAllUseCase;
  }

  private Disposable getAllVenueCategories() {
    return getAllUseCase.perform(null).subscribeWith(new DisposableObserver<List<VenueType>>() {
      @Override public void onStart() {
        loading.set(true);
      }

      @Override public void onNext(List<VenueType> venueTypeList) {
        loading.set(false);
        result.clear();
        empty.set(venueTypeList.isEmpty());
        result.addAll(venueTypeList);
      }

      @Override public void onError(Throwable e) {
        Timber.d(e);
        loading.set(false);
        error.set(e.getLocalizedMessage().isEmpty() ? context.getString(R.string.am__error_unknown)
            : e.getMessage());
      }

      @Override public void onComplete() {

      }
    });
  }

  @NotNull public final ObservableBoolean getLoading() {
    return this.loading;
  }

  @NotNull public final ObservableArrayList getResult() {
    return this.result;
  }

  @NotNull public final ObservableBoolean getEmpty() {
    return this.empty;
  }

  @NotNull public final ObservableField getError() {
    return this.error;
  }

  public void loadCategoriesList() {
    addDisposable(getAllVenueCategories());
  }
}
