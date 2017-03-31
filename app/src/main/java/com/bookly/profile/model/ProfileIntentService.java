package com.bookly.profile.model;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.bookly.BooklyApplication;
import com.bookly.common.BusEvent;
import com.bookly.common.beans.UserElement;
import com.google.gson.Gson;
import com.squareup.otto.Bus;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by cyn on 03/31/2017.
 */

public class ProfileIntentService extends IntentService {

  @Inject
  Bus bus;
  @Inject
  Gson gson;

  public ProfileIntentService() {
    super("ProfileIntentService");
  }

  @Override
  public void onCreate() {
    super.onCreate();
    ((BooklyApplication) getApplication()).getAliadaComponent().inject(this);
  }

  @Override
  protected void onHandleIntent(@Nullable Intent intent) {
    final UserElement userElement = gson.fromJson(loadJSONFromAsset(), UserElement.class);
    // Send an event to the bus
    ProfileLoadedEvent event = new ProfileLoadedEvent();
    event.setPayload(userElement);
    bus.post(event);
  }

  private String loadJSONFromAsset() {
    String json = null;
    try {
      InputStream is = getApplicationContext().getAssets().open("profile.json");
      int size = is.available();
      byte[] buffer = new byte[size];
      is.read(buffer);
      is.close();
      json = new String(buffer, "UTF-8");
    } catch (IOException ex) {
      ex.printStackTrace();
      return null;
    }
    return json;
  }

  // Static class representing when all the notifications have been fetched
  public static class ProfileLoadedEvent extends BusEvent<UserElement> {
  }
}
