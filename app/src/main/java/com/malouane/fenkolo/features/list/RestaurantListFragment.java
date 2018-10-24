package com.malouane.fenkolo.features.list;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.malouane.fenkolo.AppNavigator;
import com.malouane.fenkolo.R;
import com.malouane.fenkolo.databinding.FragmentRestaurentListBinding;
import dagger.android.support.AndroidSupportInjection;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;

public class RestaurantListFragment extends Fragment
    implements RestaurantListAdapter.RestaurantCallback {
  private static final String ARG_TYPE = "type";
  private static final String ARG_LAT_LON = "latLon";
  @Inject ViewModelProvider.Factory viewModelFactory;
  @Inject AppNavigator navigator;
  RestaurantListViewModel viewModel;
  FragmentRestaurentListBinding binder;

  public static RestaurantListFragment newInstance(String type, String userLatLon) {
    RestaurantListFragment fragment = new RestaurantListFragment();
    Bundle args = new Bundle();
    args.putSerializable(ARG_TYPE, type);
    args.putSerializable(ARG_LAT_LON, userLatLon);
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AndroidSupportInjection.inject(this);
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(RestaurantListViewModel.class);
  }

  @Override public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    binder = DataBindingUtil.inflate(inflater, R.layout.fragment_restaurent_list, container, false);
    binder.setViewModel(viewModel);
    binder.setVenueCallbacks(this);
    return binder.getRoot();
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    Bundle bundle = this.getArguments();
    String userLatLon = null;
    String venueType = null;

    if (bundle != null) {
      venueType = bundle.getString(ARG_TYPE);
      userLatLon = bundle.getString(ARG_LAT_LON);
    }

    if (userLatLon != null && venueType != null && viewModel != null) {
      viewModel.loadRestaurantList(userLatLon, venueType, false);
    }
  }

  @Override public void onItemClick(@NotNull View v, @NotNull VenueModel venueModel) {
    switch (v.getId()) {
      case R.id.am__restaurant_list_item_navigate_btn:
        ShowMap(venueModel);
        break;
      case R.id.am__restaurant_list_item_thumbnail_iv:
        showItemDetail(v, venueModel);
        break;
      case R.id.am__restaurant_list_item_name_tv:
        showItemDetail(v, venueModel);
        break;
      case R.id.am__restaurant_list_item_container_cl:
        showItemDetail(v, venueModel);
        break;
    }
  }

  private void showItemDetail(@NotNull View v, VenueModel venueModel) {
    CardView cvVenue = v.findViewById(R.id.am__restaurant_list_item_container_cv);
    ImageView ivVenue = v.findViewById(R.id.am__restaurant_list_item_thumbnail_iv);
    TextView tvVenue = v.findViewById(R.id.am__restaurant_list_item_name_tv);

    Pair<View, String> pair1 = Pair.create(cvVenue, cvVenue.getTransitionName());
    Pair<View, String> pair2 = Pair.create(ivVenue, ivVenue.getTransitionName());
    Pair<View, String> pair3 = Pair.create(tvVenue, tvVenue.getTransitionName());

    navigator.navigateToDetails(getActivity(), venueModel.getId(), pair1, pair2, pair3);
  }

  private void ShowMap(@NotNull VenueModel venueModel) {
    String strUri = "http://maps.google.com/maps?q=loc:"
        + venueModel.getLat()
        + ","
        + venueModel.getLon()
        + " ("
        + venueModel.getName()
        + ")";
    Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
    intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
    startActivity(intent);
  }
}