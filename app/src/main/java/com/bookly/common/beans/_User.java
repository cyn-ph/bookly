// THIS IS AN AUTO-GENERATED CLASS FILE. DO NOT EDIT DIRECTLY.

package com.bookly.common.beans;

import com.github.dkharrat.nexusdata.core.ManagedObject;

import java.util.Date;
import java.util.Set;

abstract class _User extends ManagedObject {

  public interface Property {
    String NAME = "name";
    String MEMBER_SINCE = "memberSince";
    String URL_PICTURE = "urlPicture";
    String BOOKS = "books";
    String PREFERENCES = "preferences";
  }


  public String getName() {
    return (String) getValue(Property.NAME);
  }

  public void setName(String name) {
    setValue(Property.NAME, name);
  }

  public Date getMemberSince() {
    return (Date) getValue(Property.MEMBER_SINCE);
  }

  public void setMemberSince(Date memberSince) {
    setValue(Property.MEMBER_SINCE, memberSince);
  }

  public String getUrlPicture() {
    return (String) getValue(Property.URL_PICTURE);
  }

  public void setUrlPicture(String urlPicture) {
    setValue(Property.URL_PICTURE, urlPicture);
  }


  @SuppressWarnings("unchecked")
  public Set<Book> getBooks() {
    return (Set<Book>) getValue(Property.BOOKS);
  }

  public void setBooks(Set<Book> books) {
    setValue(Property.BOOKS, books);
  }

  public void addBook(Book book) {
    getBooks().add(book);
  }

  @SuppressWarnings("unchecked")
  public Set<Category> getPreferences() {
    return (Set<Category>) getValue(Property.PREFERENCES);
  }

  public void setPreferences(Set<Category> preferences) {
    setValue(Property.PREFERENCES, preferences);
  }

  public void addPreference(Category preference) {
    getPreferences().add(preference);
  }
}
