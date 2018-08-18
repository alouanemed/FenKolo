package com.malouane.fenkolo.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;
import com.malouane.fenkolo.domain.interactor.VenueGetByTypeUseCase;
import com.malouane.fenkolo.domain.interactor.VenueTypeGetAllUseCase;
import com.malouane.fenkolo.features.categories.CategoriesViewModel;
import com.malouane.fenkolo.startup.LaunchViewModel;
import kotlin.Suppress;

public class ViewModelFactory implements ViewModelProvider.Factory {

  private VenueTypeGetAllUseCase typeGetAllUseCase;
  private VenueGetByTypeUseCase byTypeUseCase;
  private Context context;

  public ViewModelFactory(VenueTypeGetAllUseCase typeGetAllUseCase,
      VenueGetByTypeUseCase byTypeUseCase, Context context) {
    this.typeGetAllUseCase = typeGetAllUseCase;
    this.byTypeUseCase = byTypeUseCase;
    this.context = context;
  }

  @Override public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
    if(modelClass == LaunchViewModel.class)
      return (T) new LaunchViewModel(context, typeGetAllUseCase);
    else if(modelClass == CategoriesViewModel.class)
      return (T) new CategoriesViewModel(context, typeGetAllUseCase);
    return null;
  }
}
