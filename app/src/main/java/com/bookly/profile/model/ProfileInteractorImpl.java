package com.bookly.profile.model;

import android.content.Context;
import android.content.Intent;

import com.bookly.common.beans.UserElement;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

/**
 * Created by cyn on 03/31/2017.
 */

public class ProfileInteractorImpl implements ProfileInteractor {

  private Context context;

  @Inject
  public ProfileInteractorImpl(Context context) {
    this.context = context;
  }

  @Override
  public void loadProfile() {
    // TODO: 03/31/2017 Add logic to read from DB instead of always load the json
    Intent intent = new Intent(context, ProfileIntentService.class);
    context.startService(intent);
  }


}
