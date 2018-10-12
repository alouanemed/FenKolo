package com.malouane.fenkolo.features.details;

import android.app.Application;
import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import com.malouane.fenkolo.R;
import com.malouane.fenkolo.common.BaseAndroidViewModel;
import com.malouane.fenkolo.domain.entity.VenueDetails;
import com.malouane.fenkolo.domain.interactor.CustomPair;
import com.malouane.fenkolo.domain.interactor.VenueGetDetailsUseCase;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

public class RestaurantDetailsViewModel extends BaseAndroidViewModel {

  private ObservableBoolean loading;
  private VenueDetailsMapper mapper;
  private ObservableField<VenueDetailsModel> venueDetails;
  private ObservableBoolean empty;
  private ObservableField<String> error;
  private VenueGetDetailsUseCase useCase;

  private Context context;
  private String id;

  public RestaurantDetailsViewModel(Context context, VenueGetDetailsUseCase useCase) {
    super((Application) context.getApplicationContext());
    this.context = context;
    this.loading = new ObservableBoolean();
    this.empty = new ObservableBoolean();
    this.error = new ObservableField<String>();
    this.useCase = useCase;
    this.mapper = new VenueDetailsMapper();
    this.venueDetails = new ObservableField<VenueDetailsModel>();
  }

  void loadRestaurantDetails(String id, Boolean refresh) {
    this.id = id;
    addDisposable(getRestaurantDetails(id, refresh));
  }

  public void refresh() {
    loadRestaurantDetails(id, true);
  }

  private Disposable getRestaurantDetails(String id, Boolean refresh) {
    CustomPair input = new CustomPair(id);
    return useCase.perform(input).subscribeWith(new DisposableObserver<VenueDetails>() {
      @Override public void onStart() {
        loading.set(true);
        empty.set(false);
      }

      @Override public void onNext(VenueDetails v) {
        loading.set(false);
        venueDetails.set(mapper.toLocal(v));
        empty.set(venueDetails.get() == null);
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

  @NotNull public final ObservableBoolean getEmpty() {
    return this.empty;
  }

  @NotNull public final ObservableField getError() {
    return this.error;
  }

  public ObservableField<VenueDetailsModel> getVenueDetails() {
    return venueDetails;
  }
}
