package com.bookly.wishlist.model;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bookly.common.beans.Book;
import com.bookly.common.beans.BookElement;
import com.bookly.common.beans.WishList;
import com.bookly.common.beans.WishListElement;
import com.bookly.common.model.LoadJsonInteractor;
import com.bookly.common.model.NexusDataHelper;
import com.bookly.utils.BooklyUtils;
import com.github.dkharrat.nexusdata.core.ObjectContext;
import com.google.gson.Gson;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by cyn on 03/31/2017.
 */

public class WishListInteractorImpl extends LoadJsonInteractor implements WishListInteractor {

  private static final String TAG = "WishListInteractorImpl";
  private Gson gson;
  private ObjectContext objectContext;
  private NexusDataHelper nexusDataHelper;

  @Inject
  public WishListInteractorImpl(Context context, Gson gson,
      ObjectContext objectContext) {
    super(context);
    this.gson = gson;
    this.objectContext = objectContext;
    nexusDataHelper = new NexusDataHelper(objectContext);
  }

  @Override
  public Observable<List<Book>> loadWishList() {
    return Observable.fromCallable(new Callable<List<Book>>() {
      @Override
      public List<Book> call() throws Exception {
        final List<WishList> wishLists = objectContext.findAll(WishList.class);
        WishList wishList;
        if (wishLists.isEmpty()) {
          WishListElement wishListElement = loadWishListFromJson();
          // We need to convert the element to the model manged by NexusData
          wishList = convertToNexusDataModel(wishListElement);
          objectContext.save();
        } else {
          // Get the first ocurrence
          wishList = wishLists.get(0);
        }
        return BooklyUtils.getListBookFromSet(wishList.getWishes());
      }
    });
  }

  @NonNull
  private WishList convertToNexusDataModel(WishListElement wishListElement) {
    //Converting each book
    Set<Book> books = new HashSet<>();
    for (BookElement bookElement : wishListElement.getBooks()) {
      Book book = nexusDataHelper.getBook(bookElement);
      books.add(book);
    }
    // Create the main object
    WishList wishList = objectContext.newObject(WishList.class);
    wishList.setWishes(books);
    return wishList;
  }

  @NonNull
  private WishListElement loadWishListFromJson() {
    // This also could be a network call, for the task we are loading a json from the assets
    WishListElement wishListElement;
    wishListElement = gson.fromJson(loadJSONFromAsset("wish_list.json"),
        WishListElement.class);
    if (wishListElement == null) {
      wishListElement = new WishListElement();
    }
    return wishListElement;
  }

}
