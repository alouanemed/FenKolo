package com.malouane.fenkolo.widget;

import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.malouane.fenkolo.R;
import com.malouane.fenkolo.features.details.VenueDetailsModel;
import com.malouane.fenkolo.home.HomeActivity;
import com.orhanobut.hawk.Hawk;

/**
 * Implementation of App Widget functionality.
 */
public class FenKoloWidget extends AppWidgetProvider {

  static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
      int appWidgetId) {

    VenueDetailsModel model = Hawk.get("VenueDetailsModel");

    RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.item_restaurent_wdiget);
    if (model != null && model.getName() != null) {
      views.setTextViewText(R.id.am__restaurant_list_item_name_tv, model.getName());
      Intent appIntent = new Intent(context, HomeActivity.class);

      TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
      stackBuilder.addParentStack(HomeActivity.class);
      stackBuilder.addNextIntent(appIntent);

      PendingIntent appPendingIntent =
          stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

      views.setOnClickPendingIntent(R.id.am__restaurant_list_item_name_tv, appPendingIntent);
    }

    appWidgetManager.updateAppWidget(appWidgetId, views);
  }

  @Override
  public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
    // There may be multiple widgets active, so update all of them
    for (int appWidgetId : appWidgetIds) {
      updateAppWidget(context, appWidgetManager, appWidgetId);
    }
  }

  @Override
  public void onEnabled(Context context) {
    // Enter relevant functionality for when the first widget is created
  }

  @Override
  public void onDisabled(Context context) {
    // Enter relevant functionality for when the last widget is disabled
  }
}

