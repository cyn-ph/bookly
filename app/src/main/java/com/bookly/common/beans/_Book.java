// THIS IS AN AUTO-GENERATED CLASS FILE. DO NOT EDIT DIRECTLY.

package com.bookly.common.beans;

import com.github.dkharrat.nexusdata.core.ManagedObject;

import java.util.Set;

abstract class _Book extends ManagedObject {

  public interface Property {
    String NAME = "name";
    String AUTHOR = "author";
    String DESCRIPTION = "description";
    String RATING = "rating";
    String URL_PICTURE = "urlPicture";
    String READ_BY = "readBy";
    String CATEGORIES = "categories";
    String CHOOSEN_BY = "choosenBy";
  }


  public String getName() {
    return (String) getValue(Property.NAME);
  }

  public void setName(String name) {
    setValue(Property.NAME, name);
  }

  public String getAuthor() {
    return (String) getValue(Property.AUTHOR);
  }

  public void setAuthor(String author) {
    setValue(Property.AUTHOR, author);
  }

  public String getDescription() {
    return (String) getValue(Property.DESCRIPTION);
  }

  public void setDescription(String description) {
    setValue(Property.DESCRIPTION, description);
  }

  public Float getRating() {
    return (Float) getValue(Property.RATING);
  }

  public void setRating(Float rating) {
    setValue(Property.RATING, rating);
  }

  public String getUrlPicture() {
    return (String) getValue(Property.URL_PICTURE);
  }

  public void setUrlPicture(String urlPicture) {
    setValue(Property.URL_PICTURE, urlPicture);
  }


  public User getReadBy() {
    return (User) getValue(Property.READ_BY);
  }

  public void setReadBy(User readBy) {
    setValue(Property.READ_BY, readBy);
  }

  @SuppressWarnings("unchecked")
  public Set<Category> getCategories() {
    return (Set<Category>) getValue(Property.CATEGORIES);
  }

  public void setCategories(Set<Category> categories) {
    setValue(Property.CATEGORIES, categories);
  }

  public void addCategory(Category category) {
    getCategories().add(category);
  }

  public User getChoosenBy() {
    return (User) getValue(Property.CHOOSEN_BY);
  }

  public void setChoosenBy(User choosenBy) {
    setValue(Property.CHOOSEN_BY, choosenBy);
  }

}
