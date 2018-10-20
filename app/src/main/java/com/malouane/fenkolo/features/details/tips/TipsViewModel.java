package com.malouane.fenkolo.features.details.tips;

import android.app.Application;
import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import com.malouane.fenkolo.R;
import com.malouane.fenkolo.common.BaseAndroidViewModel;
import com.malouane.fenkolo.domain.entity.VenueTip;
import com.malouane.fenkolo.domain.interactor.CustomPair;
import com.malouane.fenkolo.domain.interactor.VenueGetTipsUseCase;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

public class TipsViewModel extends BaseAndroidViewModel {

  private ObservableBoolean loading;
  private TipMapper mapper;
  private ObservableArrayList<TipModel> result;
  private ObservableBoolean empty;
  private ObservableField<String> error;
  private VenueGetTipsUseCase useCase;

  private Context context;
  private String venueId;

  public TipsViewModel(Context context, VenueGetTipsUseCase useCase) {
    super((Application) context.getApplicationContext());
    this.context = context;
    this.loading = new ObservableBoolean();
    this.result = new ObservableArrayList<TipModel>();
    this.empty = new ObservableBoolean();
    this.error = new ObservableField<String>();
    this.useCase = useCase;
    //this.mapper = new TipMapper();
  }

  public void loadRestaurantTips(String venueId, Boolean refresh) {
    addDisposable(getRestaurentTips(venueId, refresh));
  }

  public void refresh() {
    loadRestaurantTips(venueId, true);
  }

  private Disposable getRestaurentTips(String venueId, Boolean refresh) {
    CustomPair input = new CustomPair(venueId);
    return useCase.perform(input).subscribeWith(new DisposableObserver<List<VenueTip>>() {
      @Override public void onStart() {
        loading.set(true);
        empty.set(false);
      }

      @Override public void onNext(List<VenueTip> tipList) {
        loading.set(false);
        result.clear();
        List<TipModel> outputList = new ArrayList<TipModel>();
        for (VenueTip item : tipList) {
          outputList.add(mapper.toLocal(item));
        }
        result.addAll(outputList);
        empty.set(tipList.isEmpty());
      }

      @Override public void onError(Throwable e) {
        Timber.d(e);
        loading.set(false);
        error.set(e.getLocalizedMessage().isEmpty() ? context.getString(R.string.am__error_server)
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
