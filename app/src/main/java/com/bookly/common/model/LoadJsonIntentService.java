package com.bookly.common.model;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by cyn on 03/31/2017.
 */

public class LoadJsonIntentService extends IntentService {

  public LoadJsonIntentService(String name) {
    super(name);
  }

  @Override
  protected void onHandleIntent(@Nullable Intent intent) {

  }

  protected String loadJSONFromAsset(String jsonName) {
    String json = null;
    try {
      InputStream is = getApplicationContext().getAssets().open(jsonName);
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
}
