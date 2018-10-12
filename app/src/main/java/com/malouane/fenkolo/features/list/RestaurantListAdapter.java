package com.malouane.fenkolo.features.list;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.malouane.fenkolo.R;
import com.malouane.fenkolo.databinding.ItemRestaurentCardBinding;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RestaurantListAdapter extends RecyclerView.Adapter {
  private final List<VenueModel> items;
  private final RestaurantCallback restaurantCallback;

  public RestaurantListAdapter(@NotNull List<VenueModel> items,
      @Nullable RestaurantListAdapter.RestaurantCallback restaurantCallback) {
    this.items = items;
    this.restaurantCallback = restaurantCallback;
  }

  @NotNull public RestaurantViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    ItemRestaurentCardBinding binding =
        DataBindingUtil.inflate(inflater, R.layout.item_restaurent_card, parent, false);
    return new RestaurantViewHolder(binding);
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    RestaurantViewHolder vh = (RestaurantViewHolder) holder;

    vh.getBinding().setRestaurant(this.items.get(position));
    vh.getBinding().executePendingBindings();
  }

  @Override public int getItemCount() {
    return items.size();
  }

  public interface RestaurantCallback {
    void onItemClick(@NotNull View var1, @NotNull VenueModel venueModel);
  }

  public class RestaurantViewHolder extends RecyclerView.ViewHolder {
    @NotNull

    private final ItemRestaurentCardBinding binding;

    public RestaurantViewHolder(@NotNull ItemRestaurentCardBinding binding) {
      super(binding.getRoot());

      this.binding = binding;

      binding.amRestaurantListItemContainerCl.setOnClickListener(it -> {
        restaurantCallback.onItemClick(it, items.get(getAdapterPosition()));
      });

      binding.amRestaurantListItemNavigateBtn.setOnClickListener(it -> {
        restaurantCallback.onItemClick(it, items.get(getAdapterPosition()));
      });
    }

    @NotNull public final ItemRestaurentCardBinding getBinding() {
      return this.binding;
    }
  }
}
