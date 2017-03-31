package com.bookly.profile.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bookly.BooklyApplication;
import com.bookly.R;
import com.bookly.common.beans.BookElement;
import com.bookly.common.beans.UserElement;
import com.bookly.common.decorators.BaseItemDecoration;
import com.bookly.common.view.MvpBaseFragment;
import com.bookly.di.BooklyComponent;
import com.bookly.profile.di.ProfileModule;
import com.bookly.profile.presenter.ProfilePresenter;
import com.bookly.utils.BooklyUtils;

import java.util.LinkedList;

/**
 * Created by cyn on 03/31/2017.
 */

public class ProfileFragment extends MvpBaseFragment<ProfilePresenter, ProfileView> {

  private MyBooksAdapter myBooksAdapter;
  private ProgressBar progressBar;
  private ImageView imgProfilePicture;
  private TextView txtUserName;
  private TextView txtPreferences;
  private TextView txtMemberSince;
  private ProfileView profileView = new ProfileView() {
    @Override
    public void showProgressBar() {
      progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
      progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void fillProfileInformation(UserElement user) {
      txtUserName.setText(user.getName());
      txtPreferences.setText(BooklyUtils.getStringFromList(user.getPreferences()));
      txtMemberSince.setText(user.getMemberSince().toString());
      myBooksAdapter.appendItemList(user.getMyBooks());
    }
  };

  public static ProfileFragment newInstance() {
    return new ProfileFragment();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_profile, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    // Profile image
    imgProfilePicture = (ImageView) view.findViewById(R.id.img_profile_picture);
    // User name
    txtUserName = (TextView) view.findViewById(R.id.txt_user_name);
    //Preferences
    txtPreferences = (TextView) view.findViewById(R.id.txt_preferences);
    //Preferences
    txtMemberSince = (TextView) view.findViewById(R.id.txt_member_since);
    // Recycler view
    RecyclerView bookList = (RecyclerView) view.findViewById(R.id.recycler_my_books);
    // Use this setting to improve performance if you know that changes
    // in content do not change the layout size of the RecyclerView
    bookList.setHasFixedSize(true);
    bookList.setLayoutManager(new LinearLayoutManager(getContext(),
        LinearLayoutManager.VERTICAL, false));
    // Add an item decorator to draw the dividers
    bookList.addItemDecoration(new BaseItemDecoration(getContext(),
        R.drawable.item_decorator));

    // Create and sets the adapter
    myBooksAdapter = new MyBooksAdapter(new
        LinkedList<BookElement>(), R.layout.item_book);
    bookList.setAdapter(myBooksAdapter);

    // Progress bar
    progressBar = (ProgressBar) view.findViewById(R.id.progress);
  }

  @Override
  public void onResume() {
    super.onResume();
    // Using the presenter instance we load the json file
    getPresenter().getProfile();
  }

  @Override
  protected ProfilePresenter createPresenter() {
    BooklyComponent booklyComponent = ((BooklyApplication) getActivity().getApplication())
        .getAliadaComponent();
    // Once we get the AliadaComponent we can get the presenter
    return booklyComponent.plus(new ProfileModule()).getProfilePresenter();
  }

  @Override
  protected ProfileView getMvpView() {
    return profileView;
  }

}
