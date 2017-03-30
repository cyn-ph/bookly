package com.bookly;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;

/**
 * * Custom Android bus, will handle main thread post by default
 * source (https://github.com/square/otto/issues/38)
 * Created by cyn on 03/30/2017.
 */
public class AndroidBus extends Bus {
  private final Handler mainThread = new Handler(Looper.getMainLooper());

  @Override
  public void post(final Object event) {
    mainThread.post(new Runnable() {
      @Override
      public void run() {
        AndroidBus.super.post(event);
      }
    });
  }
}
