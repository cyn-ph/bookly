package com.bookly.common.beans;

import java.util.Date;
import java.util.Set;

public class User extends _User {

  public User() {
  }

  @Override
  public void setName(String name) {
    super.setName(name);
  }

  @Override
  public void setPreferences(Set<Category> preferences) {
    super.setPreferences(preferences);
  }

  @Override
  public void setMemberSince(Date memberSince) {
    super.setMemberSince(memberSince);
  }

  @Override
  public void setUrlPicture(String urlPicture) {
    super.setUrlPicture(urlPicture);
  }

  @Override
  public void setBooks(Set<Book> books) {
    super.setBooks(books);
  }
}
