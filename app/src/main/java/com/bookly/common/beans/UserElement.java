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

  public void setName(String name) {
    this.name = name;
  }

  public void setPreferences(List<String> preferences) {
    this.preferences = preferences;
  }

  public void setMemberSince(Date memberSince) {
    this.memberSince = memberSince;
  }

  public void setUrlProfilePicture(String urlProfilePicture) {
    this.urlProfilePicture = urlProfilePicture;
  }

  public void setMyBooks(List<BookElement> myBooks) {
    this.myBooks = myBooks;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserElement)) {
      return false;
    }

    UserElement that = (UserElement) o;

    if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) {
      return false;
    }
    if (getPreferences() != null ? !getPreferences().equals(that.getPreferences()) : that
        .getPreferences() != null) {
      return false;
    }
    if (getMemberSince() != null ? !getMemberSince().equals(that.getMemberSince()) : that
        .getMemberSince() != null) {
      return false;
    }
    if (getUrlProfilePicture() != null ? !getUrlProfilePicture().equals(that.getUrlProfilePicture
        ()) : that.getUrlProfilePicture() != null) {
      return false;
    }
    return getMyBooks() != null ? getMyBooks().equals(that.getMyBooks()) : that.getMyBooks() ==
        null;

  }

  @Override
  public int hashCode() {
    int result = getName() != null ? getName().hashCode() : 0;
    result = 31 * result + (getPreferences() != null ? getPreferences().hashCode() : 0);
    result = 31 * result + (getMemberSince() != null ? getMemberSince().hashCode() : 0);
    result = 31 * result + (getUrlProfilePicture() != null ? getUrlProfilePicture().hashCode() : 0);
    result = 31 * result + (getMyBooks() != null ? getMyBooks().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "UserElement{" +
        "name='" + name + '\'' +
        ", preferences=" + preferences +
        ", memberSince=" + memberSince +
        ", urlProfilePicture='" + urlProfilePicture + '\'' +
        ", myBooks=" + myBooks +
        '}';
  }
}
