package com.bookly.common.view;

import android.support.annotation.LayoutRes;
import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cyn on 03/31/2017.
 */

public abstract class BaseRecyclerAdapter<T extends RecyclerView.ViewHolder, S> extends
    RecyclerView.Adapter<T> {

  private List<S> itemList;
  private int layout;

  public BaseRecyclerAdapter(List<S> itemList, @LayoutRes int layout) {
    super();
    this.itemList = itemList;
    this.layout = layout;
  }

  public void add(S item) {
    itemList.add(item);
  }

  public void addWithAnimation(S item) {
    add(item);
    //In order to trigger add animation
    notifyItemInserted(itemList.size());
  }

  @Override
  public T onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = getLayoutInflater(parent);
    View convertView = inflater.inflate(layout, parent, false);
    return createViewHolder(convertView);
  }

  @Override
  public void onBindViewHolder(T holder, int position) {
    bindViewHolder(holder, itemList.get(position));
  }

  @Override
  public int getItemCount() {
    return itemList.size();
  }

  public void updateItemListWithAnimation(List<S> newItemList) {
    this.itemList = new LinkedList<>();
    for (S s : newItemList) {
      addWithAnimation(s);
    }
  }

  public void appendItemList(List<S> newItemList) {
    if (!itemList.isEmpty()) {
      for (S item : newItemList) {
        addWithAnimation(item);
      }
    } else {
      updateItemListWithAnimation(newItemList);
    }
  }

  protected abstract T createViewHolder(View convertView);

  protected abstract void bindViewHolder(T holder, S item);

  @VisibleForTesting
  protected LayoutInflater getLayoutInflater(ViewGroup parent) {
    return LayoutInflater.from(parent.getContext());
  }
}
