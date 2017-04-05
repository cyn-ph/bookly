package com.bookly.profile.model;

import android.content.Context;

import com.bookly.common.beans.UserElement;
import com.bookly.common.model.LoadJsonInteractor;
import com.google.gson.Gson;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by cyn on 03/31/2017.
 */

public class ProfileInteractorImpl extends LoadJsonInteractor implements ProfileInteractor {

  Gson gson;

  @Inject
  public ProfileInteractorImpl(Context context, Gson gson) {
    super(context);
    this.gson = gson;
  }

  @Override
  public Observable<UserElement> loadProfile() {
    // TODO: 03/31/2017 Add logic to read from DB instead of always load the json
    return Observable.fromCallable(new Callable<UserElement>() {
      @Override
      public UserElement call() throws Exception {
        UserElement userElement = gson.fromJson(loadJSONFromAsset("profile.json"),
            UserElement.class);
        if (userElement == null) {
          userElement = new UserElement();
        }
        return userElement;
      }
    });
  }
}
