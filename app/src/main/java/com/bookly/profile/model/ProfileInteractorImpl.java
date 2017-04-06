package com.bookly.profile.model;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bookly.common.beans.Book;
import com.bookly.common.beans.BookElement;
import com.bookly.common.beans.Category;
import com.bookly.common.beans.User;
import com.bookly.common.beans.UserElement;
import com.bookly.common.model.LoadJsonInteractor;
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

public class ProfileInteractorImpl extends LoadJsonInteractor implements ProfileInteractor {

  private final static String TAG = "ProfileInteractorImpl";
  Gson gson;
  ObjectContext objectContext;

  @Inject
  public ProfileInteractorImpl(Context context, Gson gson,
      ObjectContext objectContext) {
    super(context, objectContext);
    this.gson = gson;
    this.objectContext = objectContext;
  }

  @Override
  public Observable<User> loadProfile() {
    return Observable.fromCallable(new Callable<User>() {
      @Override
      public User call() throws Exception {
        final List<User> users = objectContext.findAll(User.class);
        User user;
        if (users.isEmpty()) {
          UserElement userElement = loadProfileFromJson();
          user = convertToNexusDataModel(userElement);
          objectContext.save();
        } else {
          user = users.get(0);
        }
        return user;
      }
    });
  }

  @NonNull
  private User convertToNexusDataModel(UserElement userElement) {

    //Converting preferences
    Set<Category> preferences = getCategoriesFromList(userElement.getPreferences());

    //Converting each book
    Set<Book> books = new HashSet<>();
    for (BookElement bookElement : userElement.getMyBooks()) {
      Book book = getBook(bookElement);
      books.add(book);
    }

    // Create  main object
    User user = objectContext.newObject(User.class);
    user.setName(userElement.getName());
    user.setPreferences(preferences);
    user.setMemberSince(userElement.getMemberSince());
    user.setUrlPicture(userElement.getUrlProfilePicture());
    user.setBooks(books);

    return user;
  }

  @NonNull
  private UserElement loadProfileFromJson() {
    UserElement userElement = gson.fromJson(loadJSONFromAsset("profile.json"),
        UserElement.class);
    if (userElement == null) {
      userElement = new UserElement();
    }
    return userElement;
  }

}
