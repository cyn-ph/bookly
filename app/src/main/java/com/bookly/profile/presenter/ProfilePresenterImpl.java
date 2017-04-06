package com.bookly.profile.presenter;

import com.bookly.common.beans.User;
import com.bookly.profile.model.ProfileInteractor;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by cyn on 03/31/2017.
 */

public class ProfilePresenterImpl extends ProfilePresenter {

  private ProfileInteractor profileInteractor;

  @Inject
  public ProfilePresenterImpl(ProfileInteractor profileInteractor) {
    this.profileInteractor = profileInteractor;
  }

  @Override
  public void getProfile() {
    getView().showProgressBar();
    final Observable<User> observable = profileInteractor.loadProfile();
    observable.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<User>() {
          @Override
          public void accept(User userElement) throws Exception {
            onProfileFetched(userElement);
          }
        }, new Consumer<Throwable>() {
          @Override
          public void accept(Throwable throwable) throws Exception {
            getView().hideProgressBar();
            getView().showError();
          }
        });
  }

  private void onProfileFetched(User userElement) {
    getView().hideProgressBar();
    getView().fillProfileInformation(userElement);
  }
}
