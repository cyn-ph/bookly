package com.bookly.wishlist.model;

import com.bookly.common.beans.BookElement;
import com.bookly.common.beans.WishListElement;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by cyn on 03/31/2017.
 */

public interface WishListInteractor {
  Observable<WishListElement> loadWishList();
}
