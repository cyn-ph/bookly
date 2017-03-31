package com.bookly.wishlist.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.bookly.BooklyApplication;
import com.bookly.R;
import com.bookly.common.beans.BookElement;
import com.bookly.common.decorators.BaseItemDecoration;
import com.bookly.common.view.BooksAdapter;
import com.bookly.common.view.MvpBaseFragment;
import com.bookly.di.BooklyComponent;
import com.bookly.profile.di.ProfileModule;
import com.bookly.wishlist.di.WishListModule;
import com.bookly.wishlist.presenter.WishListPresenter;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cyn on 03/31/2017.
 */

public class WishListFragment extends MvpBaseFragment<WishListPresenter, WishListView> {

  private BooksAdapter wishListAdapter;
  private ProgressBar progressBar;
  private WishListView wishListView = new WishListView() {
    @Override
    public void hideProgressBar() {
      progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showProgressBar() {
      progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void fillWishList(List<BookElement> books) {
      wishListAdapter.appendItemList(books);
    }
  };

  public static WishListFragment newInstance() {
    return new WishListFragment();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_wishlist, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    // Recycler view
    RecyclerView bookList = (RecyclerView) view.findViewById(R.id.recycler_wish_list);
    // Use this setting to improve performance if you know that changes
    // in content do not change the layout size of the RecyclerView
    bookList.setHasFixedSize(true);
    bookList.setLayoutManager(new LinearLayoutManager(getContext(),
        LinearLayoutManager.VERTICAL, false));
    // Add an item decorator to draw the dividers
    bookList.addItemDecoration(new BaseItemDecoration(getContext(),
        R.drawable.item_decorator));

    // Create and sets the adapter
    wishListAdapter = new BooksAdapter(new
        LinkedList<BookElement>(), R.layout.item_book);
    bookList.setAdapter(wishListAdapter);

    // Progress bar
    progressBar = (ProgressBar) view.findViewById(R.id.progress);
  }

  @Override
  public void onResume() {
    super.onResume();
    getPresenter().getWishList();
  }

  @Override
  protected WishListPresenter createPresenter() {
    BooklyComponent booklyComponent = ((BooklyApplication) getActivity().getApplication())
        .getAliadaComponent();
    // Once we get the Bookly component we can get the presenter
    return booklyComponent.plus(new WishListModule()).getWishListPresenter();
  }

  @Override
  protected WishListView getMvpView() {
    return wishListView;
  }
}
