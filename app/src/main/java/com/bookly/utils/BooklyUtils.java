package com.bookly.utils;

import com.bookly.common.beans.Book;
import com.bookly.common.beans.Category;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by cyn on 03/31/2017.
 */

public class BooklyUtils {

  public static String getStringFromList(List<String> list) {
    String text = "";
    for (String s : list) {
      text += s + ", ";
    }
    return text;
  }

  public static String getStringFromSet(Set<Category> set) {
    String text = "";
    for (Category category : set) {
      text += category.getName() + ", ";
    }
    return text;
  }

  public static List<Book> getListBookFromSet(Set<Book> bookSet) {
    return new LinkedList<>(bookSet);

  }
}
