package com.malouane.fenkolo;

import android.app.Activity;
import android.content.Intent;
import com.malouane.fenkolo.home.HomeActivity;

public class AppNavigator {

  public void navigateToHome(Activity activity, String latLon) {
    Intent intent = new Intent(activity, HomeActivity.class);
    intent.putExtra("latLon", latLon);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
    activity.startActivity(intent);
  }
}
