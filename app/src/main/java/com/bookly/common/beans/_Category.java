// THIS IS AN AUTO-GENERATED CLASS FILE. DO NOT EDIT DIRECTLY.

package com.bookly.common.beans;

import java.util.Date;
import java.util.Set;
import com.github.dkharrat.nexusdata.core.ManagedObject;

abstract class _Category extends ManagedObject {

    public interface Property {
        String NAME = "name";
        String ASSIGNED_TO = "assignedTo";
        String CHOOSEN_BY = "choosenBy";
    }


    public String getName() {
        return (String)getValue(Property.NAME);
    }

    public void setName(String name) {
        setValue(Property.NAME, name);
    }


    public Book getAssignedTo() {
        return (Book)getValue(Property.ASSIGNED_TO);
    }

    public void setAssignedTo(Book assignedTo) {
        setValue(Property.ASSIGNED_TO, assignedTo);
    }

    public User getChoosenBy() {
        return (User)getValue(Property.CHOOSEN_BY);
    }

    public void setChoosenBy(User choosenBy) {
        setValue(Property.CHOOSEN_BY, choosenBy);
    }

}
