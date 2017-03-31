package com.bookly.profile.di;

import com.bookly.di.ActivityScope;
import com.bookly.profile.model.ProfileInteractor;
import com.bookly.profile.model.ProfileInteractorImpl;
import com.bookly.profile.presenter.ProfilePresenter;
import com.bookly.profile.presenter.ProfilePresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cyn on 03/31/2017.
 */
@Module
public class ProfileModule {
  @Provides
  @ActivityScope
  ProfilePresenter provideProfilePresenter(ProfilePresenterImpl presenter) {
    return presenter;
  }

  @Provides
  @ActivityScope
  ProfileInteractor providesProfileInteractor(ProfileInteractorImpl interactor) {
    return interactor;
  }

}
