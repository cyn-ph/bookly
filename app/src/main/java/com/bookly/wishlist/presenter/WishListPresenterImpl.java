package com.bookly.wishlist.presenter;

import android.util.Log;

import com.bookly.wishlist.model.WishListIntentService;
import com.bookly.wishlist.model.WishListInteractor;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

/**
 * Created by cyn on 03/31/2017.
 */

public class WishListPresenterImpl extends WishListPresenter {

  private WishListInteractor wishListInteractor;

  @Inject
  public WishListPresenterImpl(Bus bus, WishListInteractor wishListInteractor) {
    super(bus);
    this.wishListInteractor = wishListInteractor;
  }

  @Override
  public void getWishList() {
    getView().showProgressBar();
    wishListInteractor.loadProfile();
  }

  @Subscribe
  public void onProfileLoaded(WishListIntentService.WishListLoadedEvent event) {
    getView().hideProgressBar();
    getView().fillWishList(event.getPayload());
  }
}
