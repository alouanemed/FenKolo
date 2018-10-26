package com.malouane.fenkolo.startup;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.arch.lifecycle.ViewModelProvider;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.malouane.fenkolo.AppNavigator;
import com.malouane.fenkolo.R;
import dagger.android.AndroidInjection;
import java.text.DecimalFormat;
import javax.inject.Inject;

public class LaunchActivity extends AppCompatActivity {
  @Inject ViewModelProvider.Factory viewModelFactory;
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

    fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    getLocation();
  }

  private void getLocation() {

    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
        != PackageManager.PERMISSION_GRANTED) {
      showPermissionInfoDialog();
    } else {
      performGetLocation();
    }
  }

  @SuppressLint("MissingPermission") private void performGetLocation() {
    progressDialog = ProgressDialog.show(this, getString(R.string.am__permission_location_title),
        getString(R.string.am__permission_location_loading), true);
    fusedLocationClient.getLastLocation().addOnSuccessListener(this, location -> {
      if (location != null) {
        String lat = new DecimalFormat("##.##").format(location.getLatitude());
        String lon = new DecimalFormat("##.##").format(location.getLongitude());
        progressDialog.dismiss();

        navigator.navigateToHome(this, lat + "," + lon);
      } else {
        progressDialog.dismiss();
        errorDialog.show();
      }
    }).addOnFailureListener(e -> {
      e.printStackTrace();
      progressDialog.dismiss();
      errorDialog.show();
    });
  }

  @Override
  public void onRequestPermissionsResult(
      int requestCode,
      @NonNull String permissions[],
      @NonNull int[] grantResults) {

    if (grantResults.length > 0
        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
      performGetLocation();
      Toast.makeText(this, getString(R.string.am__permission_granted), Toast.LENGTH_SHORT).show();
    } else {
      Toast.makeText(this, getString(R.string.am__permission_denied), Toast.LENGTH_SHORT).show();
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
            (dialog, which) -> errorDialog.show())
        .show();
  }
}