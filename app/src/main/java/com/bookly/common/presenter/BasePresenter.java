package com.bookly.common.presenter;

import android.os.Bundle;
import android.support.annotation.CallSuper;

import com.bookly.common.view.BaseView;
import com.squareup.otto.Bus;

/**
 * Created by cyn on 03/30/2017.
 */

public class BasePresenter<T extends BaseView> {

  private Bus bus;
  private T view;

  public BasePresenter(Bus bus) {
    this.bus = bus;
  }

  public void setView(T view) {
    this.view = view;
  }

  public T getView() {
    return view;
  }

  @CallSuper
  public void onResume() {
    bus.register(this);
  }

  @CallSuper
  public void onPause() {
    bus.unregister(this);
  }

  @CallSuper
  public void onDestroy() {
    view = null;
  }

  public void onViewAttached() {
    // no impl by default
  }

  public void onSaveInstanceState(Bundle state) {
    // no impl by default
  }

  public void onRestoreInstanceState(Bundle state) {
    // no impl by default
  }
}
