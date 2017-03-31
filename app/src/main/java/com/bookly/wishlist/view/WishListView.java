package com.bookly.wishlist.view;

import com.bookly.common.beans.BookElement;
import com.bookly.common.view.BaseView;

import java.util.List;

/**
 * Created by cyn on 03/31/2017.
 */

public interface WishListView extends BaseView {
  void hideProgressBar();

  void showProgressBar();

  void fillWishList(List<BookElement> books);
}
