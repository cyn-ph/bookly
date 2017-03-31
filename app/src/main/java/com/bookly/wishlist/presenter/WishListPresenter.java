package com.bookly.wishlist.presenter;

import com.bookly.common.presenter.BasePresenter;
import com.bookly.wishlist.view.WishListView;
import com.squareup.otto.Bus;

/**
 * Created by cyn on 03/31/2017.
 */

public abstract class WishListPresenter extends BasePresenter<WishListView> {

  public WishListPresenter(Bus bus) {
    super(bus);
  }

  public abstract void getWishList();
}
