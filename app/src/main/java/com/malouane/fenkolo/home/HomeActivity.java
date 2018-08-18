package com.malouane.fenkolo.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.malouane.fenkolo.common.util.ViewBindingAdapters;
import com.malouane.fenkolo.di.ViewModelFactory;
import dagger.android.AndroidInjection;
import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
  @Inject ViewModelFactory viewModelFactory;

  ActivityHomeBinding binder = DataBindingUtil.setContentView(this, R.layout.activity_home);

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AndroidInjection.inject(this);

    viewModel.getResult().observe(this, o -> {
      navigator.navigateToHome(this);
    });

    viewModel.getError().observe(this, error -> {
      ViewBindingAdapters.showLongMessage(getWindow().getDecorView(), error,
          new BaseTransientBottomBar.BaseCallback<Snackbar>() {
            @Override public void onDismissed(Snackbar transientBottomBar, int event) {
              HomeActivity.this.finish();
            }
          });

      viewModel.startup();
    });
  }

  @Override public void onClick(View view) {

  }
}