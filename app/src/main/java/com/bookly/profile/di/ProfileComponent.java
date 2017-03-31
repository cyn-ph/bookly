package com.bookly.profile.di;

import com.bookly.di.ActivityScope;
import com.bookly.profile.presenter.ProfilePresenter;

import dagger.Subcomponent;

/**
 * Created by cyn on 03/31/2017.
 */
@ActivityScope
@Subcomponent(modules = {ProfileModule.class})
public interface ProfileComponent {
  ProfilePresenter getProfilePresenter();
}
