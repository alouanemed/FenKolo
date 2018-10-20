package com.malouane.fenkolo.features.details;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.malouane.fenkolo.AppNavigator;
import com.malouane.fenkolo.R;
import com.malouane.fenkolo.databinding.ActivityDetailsBinding;
import com.malouane.fenkolo.di.ViewModelFactory;
import dagger.android.AndroidInjection;
import java.util.Objects;
import javax.inject.Inject;

public class RestaurantDetailsActivity extends AppCompatActivity {
  @Inject ViewModelFactory viewModelFactory;
  @Inject AppNavigator navigator;
  RestaurantDetailsViewModel viewModel;
  ActivityDetailsBinding binder;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AndroidInjection.inject(this);
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
  }
}