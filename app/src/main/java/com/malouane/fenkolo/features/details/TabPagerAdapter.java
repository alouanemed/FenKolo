package com.malouane.fenkolo.features.details;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.malouane.fenkolo.features.details.tips.TipsFragment;

public class TabPagerAdapter extends FragmentStatePagerAdapter {
  private final String venueId;

  public TabPagerAdapter(FragmentManager fm, String venueId) {
    super(fm);
    this.venueId = venueId;
  }

  @Override
  public String getPageTitle(int position) {
    String title = "";
    switch (position) {
      case 0:
        title = "Tips";
        break;
      case 1:
        title = "Photos";
        break;
    }

    return title;
  }

  public int getCount() {
    return 2;
  }

  @Override
  public Fragment getItem(int position) {
    switch (position) {
      case 0:
        TipsFragment.newInstance(venueId);
        break;
      case 1:
        TipsFragment.newInstance(venueId);
        break;
    }
    return null;
  }
}
