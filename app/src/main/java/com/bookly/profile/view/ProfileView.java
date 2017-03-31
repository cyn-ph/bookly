package com.bookly.profile.view;

import com.bookly.common.beans.UserElement;
import com.bookly.common.view.BaseView;

/**
 * Created by cyn on 03/31/2017.
 */

public interface ProfileView extends BaseView {
  public void showProgressBar();

  public void hideProgressBar();

  public void fillProfileInformation(UserElement user);
}
