package com.bookly.wishlist.di;

import com.bookly.di.ActivityScope;
import com.bookly.wishlist.presenter.WishListPresenter;

import dagger.Subcomponent;

/**
 * Created by cyn on 03/31/2017.
 */
@ActivityScope
@Subcomponent(modules = {WishListModule.class})
public interface WishListComponent {
  WishListPresenter getWishListPresenter();
}
