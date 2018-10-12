package com.malouane.fenkolo.home;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.malouane.fenkolo.R;
import com.malouane.fenkolo.databinding.ActivityHomeBinding;
import com.malouane.fenkolo.di.ViewModelFactory;
import com.malouane.fenkolo.features.categories.CategoriesViewModel;
import dagger.android.AndroidInjection;
import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
  @Inject ViewModelFactory viewModelFactory;

  ActivityHomeBinding binder;
  CategoriesViewModel viewModel;

  @Override protected void onCreate(@Nullable Bundle bundle) {
    super.onCreate(bundle);
    AndroidInjection.inject(this);
    binder = DataBindingUtil.setContentView(this, R.layout.activity_home);
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(CategoriesViewModel.class);
    setSupportActionBar(binder.toolbar);
    String userLatLon = "";
    if (getIntent() != null) {
      userLatLon = getIntent().getStringExtra("latLon");
    }
    binder.setUserLatLon(userLatLon);
    binder.setViewModel(viewModel);
    binder.setFabClick(this);
    viewModel.loadCategoriesList();
  }

  @Override public void onClick(View view) {

  }
}