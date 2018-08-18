package com.malouane.fenkolo.home;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
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

  ActivityHomeBinding binder = DataBindingUtil.setContentView(this, R.layout.activity_home);

  CategoriesViewModel viewModel =
      ViewModelProviders.of(this, viewModelFactory).get(CategoriesViewModel.class);

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AndroidInjection.inject(this);

    setSupportActionBar(binder.toolbar);

    binder.setViewModel(viewModel);
    binder.setFabClick(this);

    viewModel.loadCategoriesList();

  }

  @Override public void onClick(View view) {
    Snackbar.make(binder.getRoot(), "on fab click", Snackbar.LENGTH_LONG).show();
  }
}