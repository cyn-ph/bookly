package com.bookly.profile.presenter;

import com.bookly.common.beans.User;
import com.bookly.profile.model.ProfileInteractor;
import com.bookly.profile.view.ProfileView;

import org.junit.Before;
import org.junit.Test;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by cyn on 04/07/2017.
 */
public class ProfilePresenterImplTest {

  ProfilePresenterImpl subject;
  ProfileInteractor interactor;
  private ProfileView view;

  @Before
  public void setUp() {
    view = mock(ProfileView.class);
    interactor = mock(ProfileInteractor.class);
    subject = new ProfilePresenterImplTestClass(interactor);
    subject.setView(view);
  }

  @Test
  public void getProfile() {
    User mockUser = mock(User.class);
    Observable<User> mockObservable = Observable.just(mockUser);
    when(interactor.loadProfile()).thenReturn(mockObservable);

    subject.getProfile();

    verify(view).showProgressBar();
    verify(view).hideProgressBar();
    verify(view).fillProfileInformation(mockUser);
  }

  @Test
  public void getProfile_Error() {
    final Observable<User> mockObservable = Observable.error(mock(Throwable.class));
    when(interactor.loadProfile()).thenReturn(mockObservable);

    subject.getProfile();

    verify(view).hideProgressBar();
    verify(view).showError();
  }

  class ProfilePresenterImplTestClass extends ProfilePresenterImpl {

    public ProfilePresenterImplTestClass(ProfileInteractor profileInteractor) {
      super(profileInteractor);
    }

    @Override
    protected Scheduler getSubscribeOn() {
      return Schedulers.trampoline();
    }

    @Override
    protected Scheduler getObserveOn() {
      return Schedulers.trampoline();
    }
  }

}