package com.malouane.fenkolo.features.details;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.malouane.fenkolo.AppNavigator;
import com.malouane.fenkolo.R;
import com.malouane.fenkolo.databinding.ActivityDetailsBinding;
import dagger.android.support.DaggerAppCompatActivity;
import java.util.Objects;
import javax.inject.Inject;

public class RestaurantDetailsActivity extends DaggerAppCompatActivity {
  @Inject ViewModelProvider.Factory viewModelFactory;
  @Inject AppNavigator navigator;
  RestaurantDetailsViewModel viewModel;
  ActivityDetailsBinding binder;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binder = DataBindingUtil.setContentView(this, R.layout.activity_details);
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(RestaurantDetailsViewModel.class);
    supportPostponeEnterTransition();
    setSupportActionBar(binder.toolbar);
    Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    binder.setRestaurantDetailsViewModel(viewModel);

    String eventId = getIntent().getStringExtra(AppNavigator.EXTRA_VENUE_ID);
    if (!eventId.isEmpty()) viewModel.loadRestaurantDetails(eventId, false);

    viewModel.getVenueDetails()
        .addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
          @Override public void onPropertyChanged(Observable sender, int propertyId) {
            View decor = (ViewGroup) getWindow().getDecorView();
            decor.getViewTreeObserver()
                .addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                  @Override public boolean onPreDraw() {
                    decor.getViewTreeObserver().removeOnPreDrawListener(this);
                    supportStartPostponedEnterTransition();
                    return true;
                  }
                });
          }
        });

    viewModel.getError()
        .addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
          @Override public void onPropertyChanged(Observable sender, int propertyId) {
            getWindow().setSharedElementReturnTransition(null);
            getWindow().setSharedElementReenterTransition(null);
          }
        });
  }

  @Override public Intent getParentActivityIntent() {
    return super.getParentActivityIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
  }

}