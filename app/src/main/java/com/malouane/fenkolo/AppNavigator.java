package com.malouane.fenkolo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import com.malouane.fenkolo.home.HomeActivity;

public class AppNavigator {

  public static final String EXTRA_VENUE_ID = "EXTRA_VENUE_ID";

  public void navigateToHome(Activity activity, String latLon) {
    Intent intent = new Intent(activity, HomeActivity.class);
    intent.putExtra("latLon", latLon);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
    activity.startActivity(intent);
  }

  public void navigateToDetails(Activity activity, String id, Pair... sharedElements) {
    Intent intent = new Intent(activity, HomeActivity.class);
    intent.putExtra(EXTRA_VENUE_ID, id);

    Bundle options =
        ActivityOptionsCompat.makeSceneTransitionAnimation(activity, sharedElements).toBundle();
    ActivityCompat.startActivity(activity, intent, options);
  }
}
