package com.bookly.wishlist.di;

import com.bookly.di.ActivityScope;
import com.bookly.wishlist.model.WishListInteractor;
import com.bookly.wishlist.model.WishListInteractorImpl;
import com.bookly.wishlist.presenter.WishListPresenter;
import com.bookly.wishlist.presenter.WishListPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cyn on 03/31/2017.
 */
@Module
public class WishListModule {
  @Provides
  @ActivityScope
  WishListInteractor providesWishListInteractor(WishListInteractorImpl interactor) {
    return interactor;
  }

  @Provides
  @ActivityScope
  WishListPresenter provideProfilePresenter(WishListPresenterImpl presenter) {
    return presenter;
  }
}
