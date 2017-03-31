package com.bookly.home.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import com.bookly.R;
import com.bookly.profile.view.ProfileFragment;

/**
 * Created by cyn on 03/30/2017.
 */

public class HomeActivity extends AppCompatActivity {

  public static final int SECTION_COUNT = 3;
  public static final int SECTION_PROFILE = 0;
  public static final int SECTION_WISH_LIST = 1;
  public static final int SECTION_FEED = 2;
  public static final int DURATION = 800;

  private ImageSwitcher imgHeader;
  private ImageView imgSectionIcon;
  private View overlay;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);

    FrameLayout container = (FrameLayout) findViewById(R.id.container);

    if (savedInstanceState == null) {
      FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

      fragmentTransaction.replace(R.id.container,
          ProfileFragment.newInstance());
      fragmentTransaction.commit();
    }
  }
}
