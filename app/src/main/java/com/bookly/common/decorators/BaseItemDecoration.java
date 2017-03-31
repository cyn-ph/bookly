package com.bookly.common.decorators;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by cyn on 03/31/2017.
 */

public class BaseItemDecoration extends RecyclerView.ItemDecoration {

  private static final int[] ATTRS = new int[]{android.R.attr.listDivider};

  private Drawable mDivider;

  /**
   * Default divider will be used
   */
  public BaseItemDecoration(Context context) {
    final TypedArray styledAttributes = context.obtainStyledAttributes(ATTRS);
    mDivider = styledAttributes.getDrawable(0);
    styledAttributes.recycle();
  }

  /**
   * Custom divider will be used
   */
  public BaseItemDecoration(Context context, @DrawableRes int resId) {
    mDivider = ContextCompat.getDrawable(context, resId);
  }

  @Override
  public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
    drawItemDecoration(c, parent);
  }

  private void drawItemDecoration(Canvas c, RecyclerView parent) {
    int left = parent.getPaddingLeft();
    int right = parent.getWidth() - parent.getPaddingRight();

    int childCount = parent.getChildCount();
    for (int i = 0; i < childCount; i++) {
      View child = parent.getChildAt(i);
      RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

      int top = child.getBottom() + params.bottomMargin;
      int bottom = top + mDivider.getIntrinsicHeight();

      mDivider.setBounds(left, top, right, bottom);
      mDivider.draw(c);
    }
  }
}
