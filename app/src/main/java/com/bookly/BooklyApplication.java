package com.bookly;

import android.app.Application;
import android.util.Log;

import com.bookly.di.BooklyComponent;
import com.bookly.di.BooklyModule;
import com.bookly.di.DaggerBooklyComponent;
import com.github.dkharrat.nexusdata.core.ObjectContext;
import com.github.dkharrat.nexusdata.core.PersistentStore;
import com.github.dkharrat.nexusdata.core.PersistentStoreCoordinator;
import com.github.dkharrat.nexusdata.metamodel.ObjectModel;
import com.github.dkharrat.nexusdata.store.AndroidSqlPersistentStore;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by cyn on 03/30/2017.
 */

public class BooklyApplication extends Application {

  private final static String TAG = "BooklyApplication";
  private BooklyComponent booklyComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    // NexusData
    // create an ObjectModel that describes the meta model
    ObjectModel model = null;
    try {

      final InputStream open = getApplicationContext().getAssets().open("bookly.model.json");
      model = new ObjectModel(open);
    } catch (IOException e) {
      Log.e(TAG, "onCreate: ", e);
    }

    // create the persistent store coordinator and its associated store
    PersistentStoreCoordinator storeCoordinator = new PersistentStoreCoordinator(model);
    PersistentStore cacheStore = new AndroidSqlPersistentStore(getApplicationContext(),
        getApplicationContext().getDatabasePath("bookly"));
    storeCoordinator.addStore(cacheStore);

    // create an ObjectContext that will be used to retrieve or save our objects
    ObjectContext mainObjectContext = new ObjectContext(storeCoordinator);

    // Dagger
    booklyComponent = DaggerBooklyComponent
        .builder()
        .booklyModule(new BooklyModule(this, mainObjectContext))
        .build();

  }

  public BooklyComponent getBooklyComponent() {
    return booklyComponent;
  }
}
