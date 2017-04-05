package com.bookly.profile.presenter;

import com.bookly.common.beans.UserElement;
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
    final Observable<UserElement> observable = profileInteractor.loadProfile();
    observable.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<UserElement>() {
          @Override
          public void accept(UserElement userElement) throws Exception {
            onProfileFetched(userElement);
          }
        });
  }

  private void onProfileFetched(UserElement userElement) {
    getView().hideProgressBar();
    getView().fillProfileInformation(userElement);
  }
}
