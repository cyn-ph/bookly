package com.bookly.common.beans;

import com.google.gson.annotations.SerializedName;

import java.util.List;

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

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setCategories(List<String> categories) {
    this.categories = categories;
  }

  public void setRating(float rating) {
    this.rating = rating;
  }

  public void setUrlPicture(String urlPicture) {
    this.urlPicture = urlPicture;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BookElement)) {
      return false;
    }

    BookElement that = (BookElement) o;

    if (getId() != that.getId()) {
      return false;
    }
    if (Float.compare(that.getRating(), getRating()) != 0) {
      return false;
    }
    if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) {
      return false;
    }
    if (getAuthor() != null ? !getAuthor().equals(that.getAuthor()) : that.getAuthor() != null) {
      return false;
    }
    if (getDescription() != null ? !getDescription().equals(that.getDescription()) : that
        .getDescription() != null) {
      return false;
    }
    if (getCategories() != null ? !getCategories().equals(that.getCategories()) : that
        .getCategories() != null) {
      return false;
    }
    return getUrlPicture() != null ? getUrlPicture().equals(that.getUrlPicture()) : that
        .getUrlPicture() == null;

  }

  @Override
  public int hashCode() {
    int result = getId();
    result = 31 * result + (getName() != null ? getName().hashCode() : 0);
    result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
    result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
    result = 31 * result + (getCategories() != null ? getCategories().hashCode() : 0);
    result = 31 * result + (getRating() != +0.0f ? Float.floatToIntBits(getRating()) : 0);
    result = 31 * result + (getUrlPicture() != null ? getUrlPicture().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "BookElement{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", author='" + author + '\'' +
        ", description='" + description + '\'' +
        ", categories=" + categories +
        ", rating=" + rating +
        ", urlPicture='" + urlPicture + '\'' +
        '}';
  }
}
