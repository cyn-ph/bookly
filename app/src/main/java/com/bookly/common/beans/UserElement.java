package com.bookly.common.beans;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by cyn on 03/31/2017.
 */

public class UserElement {
  @SerializedName("name")
  private String name;
  @SerializedName("preferences")
  private List<String> preferences;
  @SerializedName("member_since")
  private Date memberSince;
  @SerializedName("profile_picture")
  private String urlProfilePicture;
  @SerializedName("books")
  private List<BookElement> myBooks;

  public String getName() {
    return name;
  }

  public List<String> getPreferences() {
    return preferences;
  }

  public Date getMemberSince() {
    return memberSince;
  }

  public String getUrlProfilePicture() {
    return urlProfilePicture;
  }

  public List<BookElement> getMyBooks() {
    return myBooks;
  }
}
