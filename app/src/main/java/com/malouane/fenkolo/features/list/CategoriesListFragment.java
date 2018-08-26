package com.malouane.fenkolo.features.list;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.malouane.fenkolo.AppNavigator;
import com.malouane.fenkolo.R;
import com.malouane.fenkolo.databinding.FragmentRestaurentListBinding;
import com.malouane.fenkolo.di.ViewModelFactory;
import dagger.android.support.AndroidSupportInjection;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;

public class CategoriesListFragment extends Fragment
    implements RestaurantListAdapter.RestaurantCallback {
  private static final String ARG_TYPE = "type";
  @Inject ViewModelFactory viewModelFactory;
  @Inject AppNavigator navigator;
  CategoriesListViewModel viewModel;
  FragmentRestaurentListBinding binder;

  public static CategoriesListFragment newInstance(String type) {
    CategoriesListFragment fragment = new CategoriesListFragment();
    Bundle args = new Bundle();
    args.putSerializable(ARG_TYPE, type);
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AndroidSupportInjection.inject(this);
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(CategoriesListViewModel.class);
  }

  @Override public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    binder = DataBindingUtil.inflate(inflater, R.layout.fragment_restaurent_list, container, false);
    binder.setViewModel(viewModel);
    binder.setVenueCallbacks(this);
    return binder.getRoot();
  }

  @Override public void onActivityCreated(@org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    Bundle bundle = this.getArguments();
    String eventType = bundle != null ? bundle.getString("type") : null;
    if (eventType != null && viewModel != null) {
      viewModel.loadRestaurantList(eventType, false);
    }
  }

  @Override public void onItemClick(@NotNull View var1, @NotNull VenueModel venueModel) {

  }
}