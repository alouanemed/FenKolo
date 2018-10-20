package com.malouane.fenkolo.common.util.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import com.malouane.fenkolo.features.details.tips.TipsAdapter;
import com.malouane.fenkolo.features.list.RestaurantListAdapter;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RecyclerViewBindingAdapter {
  @BindingAdapter(requireAll = false, value = { "restaurantAdapter", "restaurantCallback" })
  public static void setVenueAdapter(@NotNull RecyclerView recyclerView, @Nullable List items,
      @Nullable RestaurantListAdapter.RestaurantCallback restaurantCallback) {

    if (items != null) {
      recyclerView.setHasFixedSize(true);
      recyclerView.setAdapter(
          (RecyclerView.Adapter) (new RestaurantListAdapter(items, restaurantCallback)));
    }
  }

  @BindingAdapter(requireAll = false, value = { "tipsAdapter" })
  public static void setTipsAdapter(@NotNull RecyclerView recyclerView, @Nullable List items) {

    if (items != null) {
      recyclerView.setHasFixedSize(true);
      recyclerView.setAdapter(
          (RecyclerView.Adapter) (new TipsAdapter(items)));
    }
  }
}
