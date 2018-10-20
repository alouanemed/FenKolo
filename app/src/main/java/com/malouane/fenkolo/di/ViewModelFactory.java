package com.malouane.fenkolo.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;
import com.malouane.fenkolo.domain.interactor.VenueGetByTypeUseCase;
import com.malouane.fenkolo.domain.interactor.VenueGetDetailsUseCase;
import com.malouane.fenkolo.domain.interactor.VenueGetTipsUseCase;
import com.malouane.fenkolo.domain.interactor.VenueTypeGetAllUseCase;
import com.malouane.fenkolo.features.categories.CategoriesViewModel;
import com.malouane.fenkolo.features.details.RestaurantDetailsViewModel;
import com.malouane.fenkolo.features.details.tips.TipsViewModel;
import com.malouane.fenkolo.features.list.RestaurantListViewModel;
import com.malouane.fenkolo.startup.LaunchViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

  private VenueTypeGetAllUseCase typeGetAllUseCase;
  private VenueGetByTypeUseCase byTypeUseCase;
  private VenueGetDetailsUseCase detailsUseCase;
  private VenueGetTipsUseCase venueGetTipsUseCase;
  private Context context;

  public ViewModelFactory(VenueTypeGetAllUseCase typeGetAllUseCase,
      VenueGetByTypeUseCase byTypeUseCase, VenueGetDetailsUseCase detailsUseCase,
      VenueGetTipsUseCase venueGetTipsUseCase, Context context) {
    this.typeGetAllUseCase = typeGetAllUseCase;
    this.byTypeUseCase = byTypeUseCase;
    this.detailsUseCase = detailsUseCase;
    this.venueGetTipsUseCase = venueGetTipsUseCase;
    this.context = context;
  }

  @Override public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
    if (modelClass == LaunchViewModel.class) {
      return (T) new LaunchViewModel(context, typeGetAllUseCase);
    } else if (modelClass == CategoriesViewModel.class) {
      return (T) new CategoriesViewModel(context, typeGetAllUseCase);
    } else if (modelClass == RestaurantListViewModel.class) {
      return (T) new RestaurantListViewModel(context, byTypeUseCase);
    } else if (modelClass == RestaurantDetailsViewModel.class) {
      return (T) new RestaurantDetailsViewModel(context, detailsUseCase);
    } else if (modelClass == TipsViewModel.class) {
      return (T) new TipsViewModel(context, venueGetTipsUseCase);
    }

    return null;
  }
}