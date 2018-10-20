package com.malouane.fenkolo.startup;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.malouane.fenkolo.AppNavigator;
import com.malouane.fenkolo.R;
import com.malouane.fenkolo.di.ViewModelFactory;
import dagger.android.AndroidInjection;
import java.text.DecimalFormat;
import javax.inject.Inject;

public class LaunchActivity extends AppCompatActivity {
  @Inject ViewModelFactory viewModelFactory;
  @Inject AppNavigator navigator;

  private final int PERMISSION_ACCESS_COARSE_LOCATION = 1;
  private AlertDialog errorDialog;
  private ProgressDialog progressDialog;
  private FusedLocationProviderClient fusedLocationClient;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AndroidInjection.inject(this);


    errorDialog = new AlertDialog.Builder(this).setTitle("Location")
        .setMessage(getString(R.string.am__permission_location_loading))
        .create();

    progressDialog = ProgressDialog.show(this, "",
        "Loading. Please wait...", true);

    //viewModel.startup();

    fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    getLocation();
  }

  private void getLocation() {
    progressDialog.show();

    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
        != PackageManager.PERMISSION_GRANTED) {
      showPermissionInfoDialog();
    } else {
      fusedLocationClient.getLastLocation().addOnSuccessListener(this, location -> {
        if (location != null) {
           String lat = new DecimalFormat("##.##").format(location.getLatitude());
          String lon = new DecimalFormat("##.##").format(location.getLongitude());
          progressDialog.dismiss();

          navigator.navigateToHome(this, lat + "," + lon);
        } else {
           errorDialog.show();
        }
      }).addOnFailureListener(e -> {
        e.printStackTrace();
        progressDialog.dismiss();
        errorDialog.show();
      });


     /* LocationCallback locationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
          super.onLocationResult(locationResult);
          Location currentLocation = locationResult.getLastLocation();
          if (currentLocation != null) {
            progressDialog.dismiss();
            String lat = new DecimalFormat("##.##").format(currentLocation.getLatitude());
            String lon = new DecimalFormat("##.##").format(currentLocation.getLongitude());
            navigator.navigateToHome(LaunchActivity.this, lat + "," + lon);
            finish();
          }
        }
      };
      LocationRequest mLocationRequest = new LocationRequest();
      mLocationRequest.setInterval(2000);
      mLocationRequest.setFastestInterval(2000);
      mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

      fusedLocationClient.requestLocationUpdates(mLocationRequest, locationCallback,
          Looper.myLooper());*/
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
    new AlertDialog.Builder(this).setTitle(getString(R.string.am__permission_location_title))
        .setMessage(getString(R.string.am__permission_location))
        .setPositiveButton(getString(R.string.am__permission_title), (dialog, which) -> {
          ActivityCompat.requestPermissions(this,
              new String[] {
                  Manifest.permission.ACCESS_COARSE_LOCATION,
                  Manifest.permission.ACCESS_FINE_LOCATION
              },
              PERMISSION_ACCESS_COARSE_LOCATION);
        })
        .setNegativeButton(getString(R.string.am__permission_cancel),
            (dialog, which) -> Log.d("MainActivity", "Aborting mission..."))
        .show();
  }
}