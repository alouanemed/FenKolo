package com.malouane.fenkolo.common.util.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import com.malouane.fenkolo.features.list.RestaurantListAdapter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RecyclerViewBindingAdapter {
  @BindingAdapter(requireAll = false, value = { "restaurantAdapter", "restaurantCallback" })
  public static void setEventAdapter(@NotNull RecyclerView recyclerView, @Nullable List items,
      @Nullable RestaurantListAdapter.RestaurantCallback restaurantCallback) {
    Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
    if (items != null) {
      recyclerView.setHasFixedSize(true);
      recyclerView.setAdapter(
          (RecyclerView.Adapter) (new RestaurantListAdapter(items, restaurantCallback)));
    }
  }
}
