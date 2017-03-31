package com.bookly.wishlist.model;

import android.content.Context;
import android.content.Intent;

import com.bookly.profile.model.ProfileIntentService;

import javax.inject.Inject;

/**
 * Created by cyn on 03/31/2017.
 */

public class WishListInteractorImpl implements WishListInteractor {

  private Context context;

  @Inject
  public WishListInteractorImpl(Context context) {
    this.context = context;
  }

  @Override
  public void loadProfile() {
    // TODO: 03/31/2017 Add logic to read from DB instead of always load the json
    Intent intent = new Intent(context, WishListIntentService.class);
    context.startService(intent);
  }
}
