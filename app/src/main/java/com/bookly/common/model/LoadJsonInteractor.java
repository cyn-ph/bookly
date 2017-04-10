package com.bookly.common.model;

import android.content.Context;
import android.support.annotation.VisibleForTesting;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by cyn on 04/05/2017.
 */

public class LoadJsonInteractor {

  private Context context;


  public LoadJsonInteractor(Context context) {
    this.context = context;
  }

  @VisibleForTesting
  public String loadJSONFromAsset(String jsonName) {
    String json = null;
    try {
      InputStream is = context.getAssets().open(jsonName);
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
