package com.bookly.common.presenter;

import android.os.Bundle;
import android.support.annotation.CallSuper;

import com.bookly.common.view.BaseView;

/**
 * Created by cyn on 03/30/2017.
 */

public class BasePresenter<T extends BaseView> {

  private T view;

  public void setView(T view) {
    this.view = view;
  }

  public T getView() {
    return view;
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
