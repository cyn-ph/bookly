package com.bookly.wishlist.model;

import com.bookly.common.beans.Book;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by cyn on 03/31/2017.
 */

public interface WishListInteractor {
  Observable<List<Book>> loadWishList();
}
