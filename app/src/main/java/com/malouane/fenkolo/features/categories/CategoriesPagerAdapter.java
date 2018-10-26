package com.malouane.fenkolo.features.categories;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.malouane.fenkolo.domain.entity.VenueType;
import com.malouane.fenkolo.features.list.RestaurantListFragment;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CategoriesPagerAdapter extends FragmentStatePagerAdapter {

  private List<VenueType> items;
  private String userLatLon;

  public CategoriesPagerAdapter(FragmentManager fm, List<VenueType> items,
      @Nullable String userLatLon) {
    super(fm);
    this.items = items;
    this.userLatLon = userLatLon;
  }

  @NotNull public Fragment getItem(int position) {
    return RestaurantListFragment.newInstance((this.items.get(position)).getId(), userLatLon);
  }

  public int getCount() {
    return this.items.size();
  }

  @NotNull public String getPageTitle(int position) {
    return this.items.get(position).getName();
  }
}
