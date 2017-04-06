package com.bookly.profile.model;

import com.bookly.common.beans.User;

import io.reactivex.Observable;

/**
 * Created by cyn on 03/31/2017.
 */

public interface ProfileInteractor {

  Observable<User> loadProfile();
}
