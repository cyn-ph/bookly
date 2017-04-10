package com.bookly.wishlist.presenter;

import com.bookly.common.beans.Book;
import com.bookly.wishlist.model.WishListInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by cyn on 03/31/2017.
 */

public class WishListPresenterImpl extends WishListPresenter {

  private WishListInteractor wishListInteractor;

  @Inject
  public WishListPresenterImpl(WishListInteractor wishListInteractor) {
    this.wishListInteractor = wishListInteractor;
  }

  @Override
  public void getWishList() {
    getView().showProgressBar();
    final Observable<List<Book>> wishListElementObservable = wishListInteractor.loadWishList();
    wishListElementObservable.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<List<Book>>() {
          @Override
          public void accept(List<Book> books) throws Exception {
            onWishListLoaded(books);
          }
        });
  }

  private void onWishListLoaded(List<Book> books) {
    getView().hideProgressBar();
    getView().fillWishList(books);
  }
}
