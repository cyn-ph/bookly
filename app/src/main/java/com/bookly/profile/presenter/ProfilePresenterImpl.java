package com.bookly.profile.presenter;

import com.bookly.profile.model.ProfileIntentService;
import com.bookly.profile.model.ProfileInteractor;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

/**
 * Created by cyn on 03/31/2017.
 */

public class ProfilePresenterImpl extends ProfilePresenter {

  private ProfileInteractor profileInteractor;

  @Inject
  public ProfilePresenterImpl(Bus bus, ProfileInteractor profileInteractor) {
    super(bus);
    this.profileInteractor = profileInteractor;
  }

  @Override
  public void getProfile() {
    getView().showProgressBar();
    profileInteractor.loadProfile();
  }

  @Subscribe
  public void onProfileFetched(ProfileIntentService.ProfileLoadedEvent notificationsFetchedEvent) {
    getView().hideProgressBar();
    getView().fillProfileInformation(notificationsFetchedEvent.getPayload());
  }
}
