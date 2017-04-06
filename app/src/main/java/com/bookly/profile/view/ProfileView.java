package com.bookly.profile.view;

import com.bookly.common.beans.User;
import com.bookly.common.view.BaseView;

/**
 * Created by cyn on 03/31/2017.
 */

public interface ProfileView extends BaseView {
  void showProgressBar();

  void hideProgressBar();

  void fillProfileInformation(User user);

  void showError();
}
