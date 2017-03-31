package com.bookly;

import android.app.Application;

import com.bookly.di.BooklyComponent;
import com.bookly.di.BooklyModule;
import com.bookly.di.DaggerBooklyComponent;

import io.realm.Realm;
import io.realm.RealmConfiguration;

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
//     Realm
//    RealmConfiguration configuration = new RealmConfiguration.Builder(this)
    // this wipes the db when a model change is detected
//        .deleteRealmIfMigrationNeeded()
//        .build();
//    Realm.setDefaultConfiguration(configuration);
  }

  public BooklyComponent getAliadaComponent() {
    return booklyComponent;
  }
}
