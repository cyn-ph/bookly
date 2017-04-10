package com.bookly.profile.model;

import android.content.Context;

import com.bookly.common.beans.BookElement;
import com.bookly.common.beans.Category;
import com.bookly.common.beans.User;
import com.bookly.common.beans.UserElement;
import com.bookly.common.model.NexusDataHelper;
import com.github.dkharrat.nexusdata.core.ObjectContext;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anySet;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by cyn on 04/06/2017.
 */
public class ProfileInteractorImplTest {

  private Context context;
  private ObjectContext objContext;
  private Gson gson;
  private ProfileInteractorImpl subject;

  @Before
  public void setUp() throws Exception {
    context = mock(Context.class);
    objContext = mock(ObjectContext.class);
    gson = new GsonBuilder().create();
    subject = new ProfileInteractorImpl(context, gson, objContext);
  }

  @Test
  public void loadProfile() throws Exception {
    // Setup up
    final User expectedResult = mock(User.class);
    subject = spy(subject);
    doReturn(expectedResult).when(subject).getUser();
    //Execution
    final Observable<User> userObservable = subject.loadProfile();
    userObservable.blockingSubscribe(new Consumer<User>() {
      @Override
      public void accept(User user) throws Exception {
        // Verification
        Assert.assertEquals(expectedResult, user);
      }
    });
    // Verification
    verify(subject).getUser();
  }

  @Test
  public void getUser() {
    final UserElement mockUserElement = mock(UserElement.class);
    final User expectedResult = mock(User.class);
    List<User> users = new LinkedList<>();
    when(objContext.findAll(User.class)).thenReturn(users);
    subject = spy(subject);
    doReturn(mockUserElement).when(subject).loadProfileFromJson();
    doReturn(expectedResult).when(subject).convertToNexusDataModel(mockUserElement);

    final User actualResult = subject.getUser();
    verify(objContext).save();
    Assert.assertEquals(expectedResult, actualResult);
  }

  @Test
  public void getUser_NotEmptyList() {
    final User expectedResult = mock(User.class);
    List<User> users = new LinkedList<>();
    users.add(expectedResult);
    when(objContext.findAll(User.class)).thenReturn(users);

    final User actualResult = subject.getUser();
    Assert.assertEquals(expectedResult, actualResult);
  }

  @Test
  public void convertToNexusDataModel() {

    User expectedResult = mock(User.class);

    List<BookElement> bookList = new LinkedList<>();
    bookList.add(mock(BookElement.class));
    bookList.add(mock(BookElement.class));
    bookList.add(mock(BookElement.class));
    List<String> preferenceList = new LinkedList<>();
    preferenceList.add("Preference1");
    preferenceList.add("Preference2");
    preferenceList.add("Preference3");
    Set<Category> preferences = new HashSet<>();
    preferences.add(mock(Category.class));
    preferences.add(mock(Category.class));
    preferences.add(mock(Category.class));

    UserElement mockUserElement = mock(UserElement.class);
    when(mockUserElement.getMyBooks()).thenReturn(bookList);
    when(mockUserElement.getPreferences()).thenReturn(preferenceList);

    NexusDataHelper nexusDataHelper = mock(NexusDataHelper.class);
    when(nexusDataHelper.getCategoriesFromList(mockUserElement.getPreferences()))
        .thenReturn(preferences);

    when(objContext.newObject(User.class)).thenReturn(expectedResult);
    doNothing().when(expectedResult).setName(anyString());

    subject.setNexusDataHelper(nexusDataHelper);

    subject.convertToNexusDataModel(mockUserElement);

    verify(nexusDataHelper, times(bookList.size())).getBook(any(BookElement.class));
    verify(objContext).newObject(User.class);
    verify(expectedResult).setName(anyString());
    verify(expectedResult).setPreferences(preferences);
    verify(expectedResult).setMemberSince(any(Date.class));
    verify(expectedResult).setUrlPicture(anyString());
    verify(expectedResult).setBooks(anySet());
  }

  @Test
  public void loadProfileFromJson() {
    String json = "{\n" +
        "  \"name\": \"Cynthia Palma\",\n" +
        "  \"preferences\": [\n" +
        "    \"Arts & Photography\",\n" +
        "    \"Computers & Technology\"\n" +
        "  ],\n" +
        "  \"member_since\": \"2014-09-25\",\n" +
        "  \"profile_picture\": \"https://unsplash.it/800/400?image=1062\",\n" +
        "  \"books\": [\n" +
        "    {\n" +
        "      \"id\": 1537,\n" +
        "      \"name\": \"The Code Book: The Science of Secrecy from Ancient Egypt to Quantum " +
        "Cryptography\",\n" +
        "      \"author\": \"Simon Singh\",\n" +
        "      \"description\":\"In his first book\",\n" +
        "      \"categories\": [\n" +
        "        \"Computers & Technology\"\n" +
        "      ],\n" +
        "      \"rating\": 4.3,\n" +
        "      \"pic_url\": \"https://images-na.ssl-images-amazon.com/images/I/51S0aQLkDCL" +
        ".jpg\"\n" +
        "    }\n" +
        "  ]\n" +
        "}";
    UserElement expectedResult = new UserElement();
    expectedResult.setName("Cynthia Palma");
    List<String> preferences = new LinkedList<>();
    preferences.add("Arts & Photography");
    preferences.add("Computers & Technology");
    expectedResult.setPreferences(preferences);
    expectedResult.setMemberSince(new Date(1411596000000L));
    expectedResult.setUrlProfilePicture("https://unsplash.it/800/400?image=1062");
    BookElement bookElement = new BookElement();
    bookElement.setId(1537);
    bookElement.setName("The Code Book: The Science of Secrecy from Ancient Egypt to Quantum " +
        "Cryptography");
    bookElement.setAuthor("Simon Singh");
    List<String> categories = new LinkedList<>();
    categories.add("Computers & Technology");
    bookElement.setCategories(categories);
    bookElement.setRating(4.3f);
    bookElement.setUrlPicture("https://images-na.ssl-images-amazon.com/images/I/51S0aQLkDCL.jpg");
    bookElement.setDescription("In his first book");
    List<BookElement> books = new LinkedList<>();
    books.add(bookElement);
    expectedResult.setMyBooks(books);
    subject = spy(subject);
    doReturn(json).when(subject).loadJSONFromAsset(anyString());
    final UserElement actualResult = subject.loadProfileFromJson();
    Assert.assertEquals(expectedResult, actualResult);
  }
}