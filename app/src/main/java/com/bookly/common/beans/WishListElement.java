package com.bookly.common.beans;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by cyn on 03/31/2017.
 */

public class WishListElement {
  @SerializedName("wish_list")
  private List<BookElement> books;

  public List<BookElement> getBooks() {
    return books;
  }
}
