package com.bookly.common.model;

import android.support.annotation.NonNull;

import com.bookly.common.beans.Book;
import com.bookly.common.beans.BookElement;
import com.bookly.common.beans.Category;
import com.github.dkharrat.nexusdata.core.ObjectContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by cyn on 04/06/2017.
 */

public class NexusDataHelper {
  private ObjectContext objectContext;

  public NexusDataHelper(ObjectContext objectContext) {
    this.objectContext = objectContext;
  }

  @NonNull
  public Book getBook(BookElement bookElement) {
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
  public Set<Category> getCategoriesFromList(List<String> categoriesList) {
    Set<Category> categories = new HashSet<>();
    for (String categoryElement : categoriesList) {
      Category category = objectContext.newObject(Category.class);
      category.setName(categoryElement);
      categories.add(category);
    }
    return categories;
  }

}
