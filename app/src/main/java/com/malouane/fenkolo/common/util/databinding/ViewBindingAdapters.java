package com.malouane.fenkolo.common.util.databinding;

import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.malouane.fenkolo.features.details.TabPagerAdapter;

public class ViewBindingAdapters {
  @BindingAdapter(requireAll = false, value = { "showLongMessage", "callback" })
  public static void showLongMessage(View view, String text,
      BaseTransientBottomBar.BaseCallback callback) {
    if (text != null) {
      Snackbar snackbar = Snackbar.make(view, text, 0);
      if (callback != null) {
        snackbar.addCallback(callback);
      }
      snackbar.show();
    }
  }

  @BindingAdapter("fadeView") public static void fadeView(View view, Boolean show) {
    view.setVisibility(show ? View.VISIBLE : View.GONE);
  }

  @BindingAdapter("tabAdapter")
  public static void setupTabAdapter(ViewPager viewPager, String venueId) {
    FragmentManager fragmentManager =
        ((FragmentActivity) viewPager.getContext()).getSupportFragmentManager();
    viewPager.setAdapter(new TabPagerAdapter(fragmentManager, venueId));
  }

  @BindingAdapter("loadUrl") public static void loadUrl(ImageView imageView, String url) {

    Glide.with(imageView.getContext())
        .load(url)
        .apply(new RequestOptions()
            .placeholder(new ColorDrawable(Color.DKGRAY))
            .error(new ColorDrawable(Color.RED))
            .centerCrop()
            .fitCenter())
        .into(imageView);
  }

}
