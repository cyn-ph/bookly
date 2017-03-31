package com.bookly;

import android.app.Application;

import com.bookly.di.BooklyComponent;
import com.bookly.di.BooklyModule;
import com.bookly.di.DaggerBooklyComponent;

/**
 * Created by cyn on 03/30/2017.
 */

public class BooklyApplication extends Application {

  private BooklyComponent booklyComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    // Dagger
    booklyComponent = DaggerBooklyComponent
        .builder()
        .booklyModule(new BooklyModule(this))
        .build();

  }

  public BooklyComponent getBooklyComponent() {
    return booklyComponent;
  }
}
