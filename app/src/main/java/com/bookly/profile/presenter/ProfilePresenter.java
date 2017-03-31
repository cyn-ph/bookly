package com.bookly.profile.presenter;

import com.bookly.common.presenter.BasePresenter;
import com.bookly.profile.view.ProfileView;
import com.squareup.otto.Bus;

/**
 * Created by cyn on 03/31/2017.
 */

public abstract class ProfilePresenter extends BasePresenter<ProfileView> {

  public ProfilePresenter(Bus bus) {
    super(bus);
  }

  public abstract void getProfile();
}
