package com.bookly.profile.view;

import android.support.annotation.LayoutRes;
import android.support.v4.media.RatingCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bookly.R;
import com.bookly.common.beans.BookElement;
import com.bookly.common.view.BaseRecyclerAdapter;

import java.util.List;

/**
 * Created by cyn on 03/31/2017.
 */

public class MyBooksAdapter extends BaseRecyclerAdapter<MyBooksAdapter.BookViewHolder,
    BookElement> {

  public MyBooksAdapter(List<BookElement> itemList, @LayoutRes int layout) {
    super(itemList, layout);
  }

  @Override
  protected BookViewHolder createViewHolder(View convertView) {
    return new BookViewHolder(convertView);
  }

  @Override
  protected void bindViewHolder(BookViewHolder holder, BookElement item) {
    holder.txtName.setText(item.getName());
    holder.txtAuthor.setText(item.getAuthor());
    holder.txtDescription.setText(item.getDescription());
    holder.rating.setRating(item.getRating());
  }

  class BookViewHolder extends RecyclerView.ViewHolder {
    ImageView imgBook;
    TextView txtName;
    TextView txtAuthor;
    TextView txtDescription;
    RatingBar rating;

    BookViewHolder(View view) {
      super(view);
      imgBook = (ImageView) view.findViewById(R.id.img_book);
      txtName = (TextView) view.findViewById(R.id.txt_name);
      txtAuthor = (TextView) view.findViewById(R.id.txt_author);
      txtDescription = (TextView) view.findViewById(R.id.txt_description);
      rating = (RatingBar) view.findViewById(R.id.rating);
    }
  }
}
