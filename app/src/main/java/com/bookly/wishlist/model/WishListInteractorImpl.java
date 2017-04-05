package com.bookly.wishlist.model;

import android.content.Context;

import com.bookly.common.beans.WishListElement;
import com.bookly.common.model.LoadJsonInteractor;
import com.google.gson.Gson;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by cyn on 03/31/2017.
 */

public class WishListInteractorImpl extends LoadJsonInteractor implements WishListInteractor {

  private Gson gson;

  @Inject
  public WishListInteractorImpl(Context context, Gson gson) {
    super(context);
    this.gson = gson;
  }

  @Override
  public Observable<WishListElement> loadWishList() {
    // TODO: 03/31/2017 Add logic to read from DB instead of always load the json
    return Observable.fromCallable(new Callable<WishListElement>() {
      @Override
      public WishListElement call() throws Exception {
        WishListElement wishList;
        wishList = gson.fromJson(loadJSONFromAsset("wish_list.json"),
            WishListElement.class);
        if (wishList == null) {
          wishList = new WishListElement();
        }
        return wishList;
      }
    });
  }

}
