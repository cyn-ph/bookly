package com.bookly.common.beans;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Locale;

/**
 * Created by cyn on 03/31/2017.
 */

public class BookElement {
  @SerializedName("id")
  private int id;
  @SerializedName("name")
  private String name;
  @SerializedName("author")
  private String author;
  @SerializedName("description")
  private String description;
  @SerializedName("categories")
  private List<String> categories;
  @SerializedName("rating")
  private float rating;
  @SerializedName("pic_url")
  private String urlPicture;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAuthor() {
    return author;
  }

  public String getDescription() {
    return description;
  }

  public List<String> getCategories() {
    return categories;
  }

  public float getRating() {
    return rating;
  }

  public String getUrlPicture() {
    return urlPicture;
  }
}
