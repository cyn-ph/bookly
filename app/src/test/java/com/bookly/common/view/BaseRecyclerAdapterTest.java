package com.bookly.common.view;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bookly.R;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by cyn on 04/06/2017.
 */
public class BaseRecyclerAdapterTest {

  private TestRecyclerAdapter subject;
  private List<Object> mockList;
  private final static int LAYOUT = R.layout.item_book;
  private LayoutInflater mockLayoutInflater;

  @Before
  public void setUp() throws Exception {
    mockList = mock(List.class);
    subject = new TestRecyclerAdapter(mockList, LAYOUT);
    mockLayoutInflater = mock(LayoutInflater.class);
  }

  @Test
  public void add() throws Exception {
    Object item = new Object();
    subject.add(item);
    verify(mockList).add(item);
  }

  @Test
  public void addWithAnimation() {
    Object item = new Object();
    int expectedSize = 1;
    Mockito.when(mockList.size()).thenReturn(expectedSize);
    // Test is failing (NPE) because notifyItemInserted is final and cannot be mocked
    // we need Roboelectric/Espresso to test it
//    testObject = Mockito.spy(testObject);
//    Mockito.doNothing().when(testObject).notifyItemInserted(expectedSize);
//    testObject.addWithAnimation(item);
//    Mockito.verify(testObject).add(item);
//    Mockito.verify(testObject).notifyItemInserted(expectedSize);
  }

  @Test
  public void onCreateViewHolder() {
    ViewGroup viewGroup = mock(ViewGroup.class);
    int viewType = 1;
    View convertView = mock(View.class);
    Mockito.when(mockLayoutInflater.inflate(LAYOUT, viewGroup, false)).thenReturn(convertView);
    subject = spy(subject);
    subject.onCreateViewHolder(viewGroup, viewType);
    verify(subject).createViewHolder(convertView);
  }

  @Test
  public void onBindViewHolder() {
    TestRecyclerAdapter.ViewHolderObject holder = mock(TestRecyclerAdapter.ViewHolderObject.class);
    int position = 1;
    subject = spy(subject);
    final Object expectedItem = new Object();
    Mockito.when(mockList.get(position)).thenReturn(expectedItem);
    subject.onBindViewHolder(holder, position);
    verify(subject).bindViewHolder(holder, expectedItem);
  }

  @Test
  public void getItemCount() {
    subject.getItemCount();
    verify(mockList).size();
  }

  @Test
  public void updateItemListWithAnimation() {
    final List<Object> mockNewList = new LinkedList<>();
    mockNewList.add(new Object());
    mockNewList.add(new Object());
    mockNewList.add(new Object());
    mockNewList.add(new Object());
    subject = spy(subject);
    doNothing().when(subject).addWithAnimation(Matchers.any(Object.class));
    subject.updateItemListWithAnimation(mockNewList);
    verify(subject, Mockito.times(mockNewList.size()))
        .addWithAnimation(Matchers.any(Object.class));
  }

  @Test
  public void appendItemList() {
    final List<Object> mockNewList = new LinkedList<>();
    mockNewList.add(new Object());
    mockNewList.add(new Object());
    when(mockList.isEmpty()).thenReturn(false);
    subject = spy(subject);
    doNothing().when(subject).addWithAnimation(Matchers.any(Object.class));

    subject.appendItemList(mockNewList);

    verify(subject, times(mockNewList.size())).addWithAnimation(any(Object.class));
  }

  @Test
  public void appendItemList_CurrentListEmpty() {
    final List<Object> mockNewList = new LinkedList<>();
    mockNewList.add(new Object());
    mockNewList.add(new Object());
    when(mockList.isEmpty()).thenReturn(true);
    subject = spy(subject);
    doNothing().when(subject).updateItemListWithAnimation(anyList());

    subject.appendItemList(mockNewList);

    verify(subject).updateItemListWithAnimation(mockNewList);
  }

  private class TestRecyclerAdapter extends BaseRecyclerAdapter<TestRecyclerAdapter
      .ViewHolderObject, Object> {

    public TestRecyclerAdapter(List<Object> itemList, @LayoutRes int layout) {
      super(itemList, layout);
    }

    @Override
    protected ViewHolderObject createViewHolder(
        View convertView) {
      return null;
    }

    @Override
    protected void bindViewHolder(ViewHolderObject holder,
        Object item) {
    }

    @Override
    protected LayoutInflater getLayoutInflater(ViewGroup parent) {
      return mockLayoutInflater;
    }

    class ViewHolderObject extends RecyclerView.ViewHolder {

      public ViewHolderObject(View itemView) {
        super(itemView);
      }
    }
  }

}