package com.bookly.wishlist.presenter;

import com.bookly.common.beans.BookElement;
import com.bookly.common.beans.WishListElement;
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
    final Observable<WishListElement> wishListElementObservable = wishListInteractor.loadWishList();
    wishListElementObservable.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<WishListElement>() {
          @Override
          public void accept(WishListElement wishListElement) throws Exception {
            onWishListLoaded(wishListElement.getBooks());
          }
        });
  }

  private void onWishListLoaded(List<BookElement> books) {
    getView().hideProgressBar();
    getView().fillWishList(books);
  }
}
