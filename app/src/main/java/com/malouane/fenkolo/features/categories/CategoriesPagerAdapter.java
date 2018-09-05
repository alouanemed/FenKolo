package com.malouane.fenkolo.features.categories;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.malouane.fenkolo.domain.entity.VenueType;
import com.malouane.fenkolo.features.list.CategoriesListFragment;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class CategoriesPagerAdapter extends FragmentStatePagerAdapter {

  private final List<VenueType> items;

  public CategoriesPagerAdapter(FragmentManager fm, List<VenueType> items) {
    super(fm);
    this.items = items;
  }

  @NotNull public Fragment getItem(int position) {
    return CategoriesListFragment.newInstance((this.items.get(position)).getId());
  }

  public int getCount() {
    return this.items.size();
  }

  @NotNull public String getPageTitle(int position) {
    return ((VenueType) this.items.get(position)).getName();
  }
}
