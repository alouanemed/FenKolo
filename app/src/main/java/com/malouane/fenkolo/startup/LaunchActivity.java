package com.malouane.fenkolo.startup;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import com.malouane.fenkolo.AppNavigator;
import com.malouane.fenkolo.common.util.databinding.ViewBindingAdapters;
import com.malouane.fenkolo.di.ViewModelFactory;
import dagger.android.AndroidInjection;
import javax.inject.Inject;

public class LaunchActivity extends AppCompatActivity {
  @Inject ViewModelFactory viewModelFactory;
  @Inject AppNavigator navigator;

  LaunchViewModel viewModel =
      ViewModelProviders.of(this, viewModelFactory).get(LaunchViewModel.class);

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AndroidInjection.inject(this);

    viewModel.getResult().observe(this, o -> {
      navigator.navigateToHome(this);
    });

    viewModel.getError().observe(this, error -> {
      ViewBindingAdapters.showLongMessage(getWindow().getDecorView(), error,
          new BaseTransientBottomBar.BaseCallback<Snackbar>() {
            @Override public void onDismissed(Snackbar transientBottomBar, int event) {
              LaunchActivity.this.finish();
            }
          });

      viewModel.startup();
    });
  }
}