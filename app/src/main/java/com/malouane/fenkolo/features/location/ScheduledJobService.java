package com.malouane.fenkolo.features.location;

import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.malouane.fenkolo.FenKoloApp;

public class ScheduledJobService extends JobService
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
    LocationListener {
  LocationRequest mLocationRequest;
  private GoogleApiClient mGoogleApiClient;

  @Override
  public boolean onStartJob(JobParameters job) {
    Log.d("token", "Start Job Called");
    setUpLocationClientIfNeeded();
    mLocationRequest = LocationRequest.create();
    // Use high accuracy
    mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    mLocationRequest.setInterval(30000);
    return true;
  }

  @Override
  public boolean onStopJob(JobParameters job) {
    Log.d("token", "stopped");
    return true;
  }

  @Override
  public void onConnected(@Nullable Bundle bundle) {
    LocationServices.FusedLocationApi.requestLocationUpdates(this.mGoogleApiClient,
        mLocationRequest, this);
  }

  @Override
  public void onConnectionSuspended(int i) {

  }

  @Override
  public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

  }

  private void setUpLocationClientIfNeeded() {
    if (mGoogleApiClient == null) {
      buildGoogleApiClient();
    }
  }

  protected synchronized void buildGoogleApiClient() {
    this.mGoogleApiClient = new GoogleApiClient.Builder(this)
        .addConnectionCallbacks(this)
        .addOnConnectionFailedListener(this)
        .addApi(LocationServices.API)
        .build();
    this.mGoogleApiClient.connect();
  }

  @Override
  public void onLocationChanged(Location location) {
    Log.d("token", location.getLatitude() + "" + location.getLongitude());
    SharedPreferences.Editor editor =
        getSharedPreferences(FenKoloApp.FEN_KOLO_PRES, MODE_PRIVATE).edit();
    editor.putString(FenKoloApp.KEY_LOCATION,
        location.getLatitude() + "" + location.getLongitude());
    editor.apply();
  }
}