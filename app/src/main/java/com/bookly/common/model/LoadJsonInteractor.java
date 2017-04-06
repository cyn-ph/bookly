package com.bookly.common.model;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bookly.common.beans.Book;
import com.bookly.common.beans.BookElement;
import com.bookly.common.beans.Category;
import com.github.dkharrat.nexusdata.core.ObjectContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by cyn on 04/05/2017.
 */

public class LoadJsonInteractor {

  private Context context;
  private ObjectContext objectContext;

  public LoadJsonInteractor(Context context,
      ObjectContext objectContext) {
    this.context = context;
    this.objectContext = objectContext;
  }

  protected String loadJSONFromAsset(String jsonName) {
    String json = null;
    try {
      InputStream is = context.getAssets().open(jsonName);
      int size = is.available();
      byte[] buffer = new byte[size];
      is.read(buffer);
      is.close();
      json = new String(buffer, "UTF-8");
    } catch (IOException ex) {
      ex.printStackTrace();
      return null;
    }
    return json;
  }

  @NonNull
  protected Book getBook(BookElement bookElement) {
    // Converting each category
    Book book = objectContext.newObject(Book.class);
    book.setId(bookElement.getId());
    book.setName(bookElement.getName());
    book.setAuthor(bookElement.getAuthor());
    book.setDescription(bookElement.getDescription());
    book.setCategories(getCategoriesFromList(bookElement.getCategories()));
    book.setRating(bookElement.getRating());
    book.setUrlPicture(bookElement.getUrlPicture());
    return book;
  }

  @NonNull
  protected Set<Category> getCategoriesFromList(List<String> categoriesList) {
    Set<Category> categories = new HashSet<>();
    for (String categoryElement : categoriesList) {
      Category category = objectContext.newObject(Category.class);
      category.setName(categoryElement);
      categories.add(category);
    }
    return categories;
  }
}
