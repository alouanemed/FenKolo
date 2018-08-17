package com.malouane.fenkolo.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;
import com.malouane.fenkolo.domain.interactor.VenueGetByTypeUseCase;
import com.malouane.fenkolo.domain.interactor.VenueTypeGetAllUseCase;

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

  @NonNull @Override public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
    return null;
  }
}
