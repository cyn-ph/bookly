// THIS IS AN AUTO-GENERATED CLASS FILE. DO NOT EDIT DIRECTLY.

package com.bookly.common.beans;

import com.github.dkharrat.nexusdata.core.ManagedObject;

import java.util.Set;

abstract class _WishList extends ManagedObject {

  public interface Property {
    String WISHES = "wishes";
  }


  @SuppressWarnings("unchecked")
  public Set<Book> getWishes() {
    return (Set<Book>) getValue(Property.WISHES);
  }

  public void setWishes(Set<Book> wishes) {
    setValue(Property.WISHES, wishes);
  }

  public void addWish(Book wish) {
    getWishes().add(wish);
  }
}
