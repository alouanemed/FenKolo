package com.malouane.fenkolo.common.util;

import android.databinding.BindingAdapter;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.malouane.fenkolo.domain.entity.VenueType;
import com.malouane.fenkolo.features.categories.CategoriesPagerAdapter;
import java.util.List;

public class ViewBindingAdapters {
  @BindingAdapter(requireAll = false, value = { "showLongMessage", "callback" })
  public static void showLongMessage(View view, String text,
      BaseTransientBottomBar.BaseCallback callback) {
    if (text != null) {
      Snackbar snackbar = Snackbar.make(view, (CharSequence) text, 0);
      if (callback != null) {
        snackbar.addCallback(callback);
      }
      snackbar.show();
    }
  }

  @BindingAdapter({ "venueTypeAdapter" })
  public static void setEventTypeAdapter(ViewPager viewPager, List<VenueType> items) {
    if (items != null) {
      FragmentManager fm = ((FragmentActivity) viewPager.getContext()).getSupportFragmentManager();
      viewPager.setAdapter((PagerAdapter) (new CategoriesPagerAdapter(fm, items)));
    }
  }
}
