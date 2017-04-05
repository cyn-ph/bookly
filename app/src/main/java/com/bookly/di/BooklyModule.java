package com.bookly.di;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Main App Module for Dependency Injection. Singleton definition is provided here
 * Created by cyn on 03/30/2017.
 */
@Module
public class BooklyModule {

  private Context context;

  public BooklyModule(Context context) {
    this.context = context;
  }

  @Provides
  @Singleton
  Context provideContext() {
    return context;
  }

  @Provides
  @Singleton
  Gson provideGson() {
    return new GsonBuilder().setPrettyPrinting().create();
  }

}
