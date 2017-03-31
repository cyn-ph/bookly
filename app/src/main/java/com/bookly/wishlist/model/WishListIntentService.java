package com.bookly.wishlist.model;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.bookly.BooklyApplication;
import com.bookly.common.BusEvent;
import com.bookly.common.beans.BookElement;
import com.bookly.common.beans.UserElement;
import com.bookly.common.beans.WishListElement;
import com.bookly.common.model.LoadJsonIntentService;
import com.bookly.profile.model.ProfileIntentService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.otto.Bus;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by cyn on 03/31/2017.
 */

public class WishListIntentService extends LoadJsonIntentService {

  @Inject
  Bus bus;
  @Inject
  Gson gson;

  public WishListIntentService() {
    super("WishListIntentService");
  }

  @Override
  public void onCreate() {
    super.onCreate();
    ((BooklyApplication) getApplication()).getAliadaComponent().inject(this);
  }

  @Override
  protected void onHandleIntent(@Nullable Intent intent) {
    final WishListElement wishList = gson.fromJson(loadJSONFromAsset("wish_list.json"),
        WishListElement.class);
    // Send an event to the bus
    WishListLoadedEvent event = new WishListLoadedEvent();
    event.setPayload(wishList.getBooks());
    bus.post(event);
  }

  // Static class representing when all the notifications have been fetched
  public static class WishListLoadedEvent extends BusEvent<List<BookElement>> {
  }
}
