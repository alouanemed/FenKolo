package com.malouane.fenkolo.common.util.databinding;

import android.databinding.BindingAdapter;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import com.malouane.fenkolo.domain.entity.VenueType;
import com.malouane.fenkolo.features.categories.CategoriesPagerAdapter;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ViewPagerBindingAdapter {

  @BindingAdapter({ "setupWithViewPager" })
  public static void setupWithViewPager(@NotNull TabLayout tabLayout,
      @NotNull ViewPager viewPager) {
    tabLayout.setupWithViewPager(viewPager);
  }

  @BindingAdapter({ "pageMargin" })
  public static void setPageMargin(@NotNull ViewPager viewPager, float margin) {
    viewPager.setPageMargin((int) margin);
  }

  @BindingAdapter(value = { "venueTypeAdapter", "userLatLon" })
  public static void setVenueTypeAdapter(@NotNull ViewPager viewPager,
      @Nullable List<VenueType> items, @Nullable String userLatLon) {

    if (items != null) {
      FragmentManager fm = ((FragmentActivity) viewPager.getContext()).getSupportFragmentManager();
      viewPager.setAdapter((PagerAdapter) (new CategoriesPagerAdapter(fm, items, userLatLon)));
    }
  }
}
