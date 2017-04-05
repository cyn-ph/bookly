package com.bookly.common.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.bookly.common.presenter.BasePresenter;

/**
 * Created by cyn on 03/30/2017.
 */

public abstract class MvpBaseFragment<T extends BasePresenter<V>, V extends BaseView>
    extends Fragment {

  private T presenter;

  protected T getPresenter() {
    return presenter;
  }

  protected abstract T createPresenter();

  protected abstract V getMvpView();

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    presenter = createPresenter();
    if (savedInstanceState != null) {
      presenter.onRestoreInstanceState(savedInstanceState);
    }
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    presenter.setView(getMvpView());
    presenter.onViewAttached();
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    presenter.onSaveInstanceState(outState);
  }

  @Override
  public void onDestroy() {
    presenter.onDestroy();
    super.onDestroy();
  }
}
