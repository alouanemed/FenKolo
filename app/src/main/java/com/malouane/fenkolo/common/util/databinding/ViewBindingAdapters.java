package com.malouane.fenkolo.common.util.databinding;

import android.databinding.BindingAdapter;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

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

  @BindingAdapter("fadeView") public static void fadeView(View view, Boolean show) {
    view.setVisibility(show ? View.VISIBLE : View.GONE);
  }

  @BindingAdapter("loadUrl") public static void loadUrl(ImageView imageView, String url) {
    Glide.with(imageView.getContext())
        .load(url)
        .apply(RequestOptions.noTransformation())
        .into(imageView);
  }

}
