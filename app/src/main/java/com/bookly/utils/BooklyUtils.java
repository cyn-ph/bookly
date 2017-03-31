package com.bookly.utils;

import java.util.List;

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
}
