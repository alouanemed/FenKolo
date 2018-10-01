package com.malouane.fenkolo.features.details;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.malouane.fenkolo.AppNavigator;
import com.malouane.fenkolo.R;
import com.malouane.fenkolo.databinding.ActivityDetailsBinding;
import com.malouane.fenkolo.di.ViewModelFactory;
import com.malouane.fenkolo.features.list.RestaurantListAdapter;
import com.malouane.fenkolo.features.list.VenueModel;
import dagger.android.AndroidInjection;
import java.util.Objects;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;

public class RestaurantDetailsActivity extends AppCompatActivity
    implements RestaurantListAdapter.RestaurantCallback {
  @Inject ViewModelFactory viewModelFactory;
  @Inject AppNavigator navigator;
  RestaurantDetailsViewModel viewModel;
  ActivityDetailsBinding binder;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AndroidInjection.inject(this);
    supportPostponeEnterTransition();
    setSupportActionBar(binder.toolbar);
    Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    binder = DataBindingUtil.setContentView(this, R.layout.activity_details);
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(RestaurantDetailsViewModel.class);
    binder.setVenueDetailViewModel(viewModel);
    viewModel.getVenueDetails();

    String eventId = getIntent().getStringExtra(AppNavigator.EXTRA_VENUE_ID);
    if (!eventId.isEmpty()) viewModel.loadRestaurantDetails(eventId, false);

    viewModel.venueDetails.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
      @Override public void onPropertyChanged(Observable sender, int propertyId) {

        getWindow().getDecorView(.doOnPreDraw {
          supportStartPostponedEnterTransition()
        }
      })
    }

    @Override public void onItemClick (@NotNull View v, @NotNull VenueModel venueModel){

    }
  }