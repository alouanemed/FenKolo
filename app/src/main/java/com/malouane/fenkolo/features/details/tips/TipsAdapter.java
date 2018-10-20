package com.malouane.fenkolo.features.details.tips;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.malouane.fenkolo.R;
import com.malouane.fenkolo.databinding.ItemTipCardBinding;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class TipsAdapter extends RecyclerView.Adapter {
  private final List<TipModel> items;

  public TipsAdapter(@NotNull List<TipModel> items) {
    this.items = items;
  }

  @NotNull public TipViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    ItemTipCardBinding binding =
        DataBindingUtil.inflate(inflater, R.layout.item_tip_card, parent, false);
    return new TipViewHolder(binding);
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    TipViewHolder vh = (TipViewHolder) holder;

    vh.getBinding().setTip(items.get(position));
    vh.getBinding().executePendingBindings();
  }

  @Override public int getItemCount() {
    return items.size();
  }

  public class TipViewHolder extends RecyclerView.ViewHolder {
    @NotNull

    private final ItemTipCardBinding binding;

    public TipViewHolder(@NotNull ItemTipCardBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    @NotNull public final ItemTipCardBinding getBinding() {
      return this.binding;
    }
  }
}
