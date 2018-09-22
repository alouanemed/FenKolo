package com.malouane.fenkolo.features.list;

import android.app.Application;
import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import com.malouane.fenkolo.R;
import com.malouane.fenkolo.common.BaseAndroidViewModel;
import com.malouane.fenkolo.domain.entity.Venue;
import com.malouane.fenkolo.domain.interactor.CustomPair;
import com.malouane.fenkolo.domain.interactor.VenueGetByTypeUseCase;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

public class RestaurantListViewModel extends BaseAndroidViewModel {

  private ObservableBoolean loading;
  private VenueMapper mapper;
  private ObservableArrayList<VenueModel> result;
  private ObservableBoolean empty;
  private ObservableField<String> error;
  private VenueGetByTypeUseCase useCase;

  private Context context;
  private String type;
  private String userLatLon;

  public RestaurantListViewModel(Context context, VenueGetByTypeUseCase useCase) {
    super((Application) context.getApplicationContext());
    this.context = context;
    this.loading = new ObservableBoolean();
    this.result = new ObservableArrayList<VenueModel>();
    this.empty = new ObservableBoolean();
    this.error = new ObservableField<String>();
    this.useCase = useCase;
    this.mapper = new VenueMapper();
  }

  public void loadRestaurantList(String userLatLon, String type, Boolean refresh) {
    this.type = type;
    this.userLatLon = userLatLon;
    addDisposable(findRestaurantsByType(type, refresh));
  }

  public void refresh() {
    loadRestaurantList(userLatLon, type, true);
  }

  private Disposable findRestaurantsByType(String type, Boolean refresh) {
    CustomPair input = new CustomPair(userLatLon, type);//"40.7128,-74.0060"
    return useCase.perform(input).subscribeWith(new DisposableObserver<List<Venue>>() {
      @Override public void onStart() {
        loading.set(true);
        empty.set(false);
      }

      @Override public void onNext(List<Venue> venuesList) {
        loading.set(false);
        result.clear();
        List<VenueModel> outputList = new ArrayList<VenueModel>();
        for (Venue item : venuesList) {
          outputList.add(mapper.toLocal(item));
        }
        result.addAll(outputList);
        empty.set(venuesList.isEmpty());
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
}
