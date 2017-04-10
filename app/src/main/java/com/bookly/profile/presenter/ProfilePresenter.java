package com.bookly.profile.presenter;

import com.bookly.common.presenter.BasePresenter;
import com.bookly.profile.view.ProfileView;

/**
 * Created by cyn on 03/31/2017.
 */

public abstract class ProfilePresenter extends BasePresenter<ProfileView> {

  public abstract void getProfile();
}
