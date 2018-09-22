package com.malouane.fenkolo.startup;

import android.Manifest;
import android.arch.lifecycle.ViewModelProviders;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.malouane.fenkolo.AppNavigator;
import com.malouane.fenkolo.R;
import com.malouane.fenkolo.common.util.databinding.ViewBindingAdapters;
import com.malouane.fenkolo.di.ViewModelFactory;
import dagger.android.AndroidInjection;
import java.text.DecimalFormat;
import javax.inject.Inject;

public class LaunchActivity extends AppCompatActivity {
  @Inject ViewModelFactory viewModelFactory;
  @Inject AppNavigator navigator;

  LaunchViewModel viewModel;
  private final int PERMISSION_ACCESS_COARSE_LOCATION = 1;
  private AlertDialog errorDialog;
  private FusedLocationProviderClient fusedLocationClient;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AndroidInjection.inject(this);
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(LaunchViewModel.class);

    viewModel.getResult().observe(this, o -> {

    });

    errorDialog = new AlertDialog.Builder(this).setTitle("Location")
        .setMessage(getString(R.string.am__error_location))
        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
        .create();

    viewModel.getError().observe(this, error -> {
      ViewBindingAdapters.showLongMessage(getWindow().getDecorView(), error,
          new BaseTransientBottomBar.BaseCallback<Snackbar>() {
            @Override public void onDismissed(Snackbar transientBottomBar, int event) {
              LaunchActivity.this.finish();
            }
          });
    });

    //viewModel.startup();

    fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
        != PackageManager.PERMISSION_GRANTED) {
      showPermissionInfoDialog();
    } else {
      fusedLocationClient.getLastLocation().addOnSuccessListener(this, location -> {
        if (location != null) {
          String lat = new DecimalFormat("##.##").format(location.getLatitude());
          String lon = new DecimalFormat("##.##").format(location.getLongitude());

          navigator.navigateToHome(this, lat + "," + lon);
        } else {
          errorDialog.show();
        }
      });
    }
  }

  @Override protected void onStart() {
    super.onStart();
    errorDialog.dismiss();
  }

  @Override protected void onStop() {
    errorDialog.dismiss();
    super.onStop();
  }

  private void showPermissionInfoDialog() {
    new AlertDialog.Builder(this).setTitle("Location")
        .setMessage("We need your permission to use your location")
        .setPositiveButton("Permit", (dialog, which) -> {
          ActivityCompat.requestPermissions(this,
              new String[] { Manifest.permission.ACCESS_COARSE_LOCATION },
              PERMISSION_ACCESS_COARSE_LOCATION);
        })
        .setNegativeButton("Cancel",
            (dialog, which) -> Log.d("MainActivity", "Aborting mission..."))
        .show();
  }
}