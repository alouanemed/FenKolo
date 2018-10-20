package com.malouane.fenkolo.features.details.tips;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.malouane.fenkolo.AppNavigator;
import com.malouane.fenkolo.R;
import com.malouane.fenkolo.databinding.FragmentTipListBinding;
import com.malouane.fenkolo.di.ViewModelFactory;
import com.malouane.fenkolo.features.list.RestaurantListAdapter;
import com.malouane.fenkolo.features.list.VenueModel;
import dagger.android.support.AndroidSupportInjection;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;

public class TipsFragment extends Fragment
    implements RestaurantListAdapter.RestaurantCallback {
  private static final String ARG_REST_ID = "id";
  @Inject ViewModelFactory viewModelFactory;
  @Inject AppNavigator navigator;
  TipsViewModel viewModel;
  FragmentTipListBinding binder;

  public static TipsFragment newInstance(String venueId) {
    TipsFragment fragment = new TipsFragment();
    Bundle args = new Bundle();
    args.putSerializable(ARG_REST_ID, venueId);
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AndroidSupportInjection.inject(this);
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(TipsViewModel.class);
  }

  @Override public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    binder = DataBindingUtil.inflate(inflater, R.layout.fragment_tip_list, container, false);
    binder.setViewModel(viewModel);
    return binder.getRoot();
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    Bundle bundle = this.getArguments();
    String restaurantId = null;

    if (bundle != null) {
      restaurantId = bundle.getString(ARG_REST_ID);
    }

    if (restaurantId != null && viewModel != null) {
      viewModel.loadRestaurantTips(restaurantId, false);
    }
  }

  @Override public void onItemClick(@NotNull View v, @NotNull VenueModel venueModel) {

  }

}