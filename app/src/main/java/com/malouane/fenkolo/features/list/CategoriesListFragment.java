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
import dagger.android.AndroidInjection;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public class CategoriesListFragment extends Fragment
    implements RestaurantListAdapter.RestaurantCallback {
  private static final String ARG_TYPE = "type";
  @Inject ViewModelFactory viewModelFactory;
  @Inject AppNavigator navigator;
  CategoriesListViewModel viewModel;
  private FragmentRestaurentListBinding binder;

  public static CategoriesListFragment newInstance(String type) {
    CategoriesListFragment fragment = new CategoriesListFragment();
    Bundle args = new Bundle();
    args.putSerializable(ARG_TYPE, type);
    fragment.setArguments(args);
    return fragment;
  }

  public void onCreate(@org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AndroidInjection.inject(getActivity());
  }

  public View onCreateView(@NotNull LayoutInflater inflater,
      @org.jetbrains.annotations.Nullable ViewGroup container,
      @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
    binder = DataBindingUtil.inflate(inflater, R.layout.fragment_restaurent_list, container, false);

    binder.setViewModel(viewModel);
    binder.setVenueCallbacks(this);
    return binder.getRoot();
  }

  public void onActivityCreated(@org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(CategoriesListViewModel.class);

    Bundle bundle = this.getArguments();
    String eventType = bundle != null ? bundle.getString("type") : null;
    if (eventType != null) {
      Intrinsics.throwNpe();
      viewModel.loadRestaurantList(eventType, false);
    }
  }

  @Override public void onItemClick(@NotNull View var1, @NotNull VenueModel venueModel) {

  }
}