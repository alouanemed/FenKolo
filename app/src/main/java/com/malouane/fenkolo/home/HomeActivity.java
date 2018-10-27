package com.malouane.fenkolo.home;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.Trigger;
import com.malouane.fenkolo.FenKoloApp;
import com.malouane.fenkolo.R;
import com.malouane.fenkolo.databinding.ActivityHomeBinding;
import com.malouane.fenkolo.features.categories.CategoriesViewModel;
import com.malouane.fenkolo.features.location.ScheduledJobService;
import dagger.android.support.DaggerAppCompatActivity;
import javax.inject.Inject;

public class HomeActivity extends DaggerAppCompatActivity implements View.OnClickListener {
  @Inject ViewModelProvider.Factory viewModelFactory;

  ActivityHomeBinding binder;
  CategoriesViewModel viewModel;

  public static Job createLocationJob(FirebaseJobDispatcher dispatcher) {
    return dispatcher.newJobBuilder()
        .setLifetime(Lifetime.FOREVER)
        .setService(ScheduledJobService.class)
        .setTag("LocationJob")
        .setRecurring(true)
        .setTrigger(Trigger.executionWindow(10, 30))
        .setConstraints(Constraint.ON_ANY_NETWORK)
        .build();
  }

  @Override public void onClick(View view) {

  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putInt("tabState", binder.tabs.getSelectedTabPosition());
  }

  @Override protected void onCreate(@Nullable Bundle bundle) {
    super.onCreate(bundle);
    binder = DataBindingUtil.setContentView(this, R.layout.activity_home);
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(CategoriesViewModel.class);
    setSupportActionBar(binder.toolbar);
    String userLatLon = "";

    if (getIntent() != null) {
      userLatLon = getIntent().getStringExtra("latLon");
    }

    SharedPreferences prefs = getSharedPreferences(FenKoloApp.FEN_KOLO_PRES, MODE_PRIVATE);
    String restoredUserLatLon = prefs.getString(FenKoloApp.KEY_LOCATION, null);
    if (restoredUserLatLon != null) {
      userLatLon = prefs.getString(FenKoloApp.KEY_LOCATION, "");
    }

    binder.setUserLatLon(userLatLon);
    binder.setViewModel(viewModel);
    binder.setFabClick(this);
    viewModel.loadCategoriesList();

    if (bundle != null) {
      binder.viewPager.setCurrentItem(bundle.getInt("tabState"));
    }
    createLocationJob(new FirebaseJobDispatcher(new GooglePlayDriver(this)));
  }
}