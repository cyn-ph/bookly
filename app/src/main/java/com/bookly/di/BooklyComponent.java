package com.bookly.di;

import com.bookly.profile.di.ProfileComponent;
import com.bookly.profile.di.ProfileModule;
import com.bookly.profile.model.ProfileIntentService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Main Dependency Injection Component, i. e. Injector Class
 * Created by cyn on 03/30/2017.
 */
@Singleton
@Component(modules = {BooklyModule.class})
public interface BooklyComponent {
  ProfileComponent plus(ProfileModule module);

  void inject(ProfileIntentService service);
}
