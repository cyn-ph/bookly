// THIS IS AN AUTO-GENERATED CLASS FILE. DO NOT EDIT DIRECTLY.

package com.bookly.common.beans;

import java.util.Date;
import java.util.Set;
import com.github.dkharrat.nexusdata.core.ManagedObject;

abstract class _Book extends ManagedObject {

    public interface Property {
        String ID = "id";
        String NAME = "name";
        String AUTHOR = "author";
        String DESCRIPTION = "description";
        String RATING = "rating";
        String URL_PICTURE = "urlPicture";
        String WISHED_BY = "wishedBy";
        String CATEGORIES = "categories";
        String READ_BY = "readBy";
    }


    public Integer getId() {
        return (Integer)getValue(Property.ID);
    }

    public void setId(Integer id) {
        setValue(Property.ID, id);
    }

    public String getName() {
        return (String)getValue(Property.NAME);
    }

    public void setName(String name) {
        setValue(Property.NAME, name);
    }

    public String getAuthor() {
        return (String)getValue(Property.AUTHOR);
    }

    public void setAuthor(String author) {
        setValue(Property.AUTHOR, author);
    }

    public String getDescription() {
        return (String)getValue(Property.DESCRIPTION);
    }

    public void setDescription(String description) {
        setValue(Property.DESCRIPTION, description);
    }

    public Float getRating() {
        return (Float)getValue(Property.RATING);
    }

    public void setRating(Float rating) {
        setValue(Property.RATING, rating);
    }

    public String getUrlPicture() {
        return (String)getValue(Property.URL_PICTURE);
    }

    public void setUrlPicture(String urlPicture) {
        setValue(Property.URL_PICTURE, urlPicture);
    }


    public WishList getWishedBy() {
        return (WishList)getValue(Property.WISHED_BY);
    }

    public void setWishedBy(WishList wishedBy) {
        setValue(Property.WISHED_BY, wishedBy);
    }

    @SuppressWarnings("unchecked")
    public Set<Category> getCategories() {
        return (Set<Category>)getValue(Property.CATEGORIES);
    }

    public void setCategories(Set<Category> categories) {
        setValue(Property.CATEGORIES, categories);
    }

    public void addCategory(Category category) {
        getCategories().add(category);
    }
    public User getReadBy() {
        return (User)getValue(Property.READ_BY);
    }

    public void setReadBy(User readBy) {
        setValue(Property.READ_BY, readBy);
    }

}
