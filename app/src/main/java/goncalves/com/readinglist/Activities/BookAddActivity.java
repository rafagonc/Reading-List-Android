package goncalves.com.readinglist.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import goncalves.com.readinglist.Customizers.ActionBarCustomizer;
import goncalves.com.readinglist.DAOs.Abstract.AuthorDataAccessObject;
import goncalves.com.readinglist.Entities.Abstract.Author;
import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.Factories.Abstract.BookFactory;
import goncalves.com.readinglist.GeneralClasses.NotificationShower;
import goncalves.com.readinglist.Interfaces.BookAddChainOfResponsibility;
import goncalves.com.readinglist.R;
import goncalves.com.readinglist.ViewAdapters.Concrete.AuthorNameEditText;
import goncalves.com.readinglist.ViewAdapters.Concrete.BookNameEditText;
import goncalves.com.readinglist.ViewAdapters.Concrete.CategoryNameEditText;
import goncalves.com.readinglist.ViewAdapters.Concrete.PagesEditText;
import goncalves.com.readinglist.ViewAdapters.Concrete.ProgessPagesSeekBar;
import goncalves.com.readinglist.ViewAdapters.Delegates.AuthorNameEditTextDelegate;
import goncalves.com.readinglist.ViewAdapters.Delegates.CategoryNameEditTextDelegate;
import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.InjectView;

public class BookAddActivity extends RoboActionBarActivity implements AuthorNameEditTextDelegate, CategoryNameEditTextDelegate {

    //region Constants
    public static final String BOOK_INTENT_GET_NAME = "BOOK_INTENT_GET_NAME";
    //endregion

    //region Properties
    @InjectView(R.id.bookNameEditText) BookNameEditText bookNameEditText;
    @InjectView(R.id.authorEditText) AuthorNameEditText authorEditText;
    @InjectView(R.id.categoryEditTextView) CategoryNameEditText categoryEditText;
    @InjectView(R.id.totalPagesEditTextView) PagesEditText pagesEditText;
    @InjectView(R.id.progessSeekBar) ProgessPagesSeekBar progessPagesSeekBar;
    @Inject BookFactory bookFactory;
    @Inject AuthorDataAccessObject authorDataAccessObject;
    private Book book;
    //endregion

    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_add);
        setActivityTitle();

        //set delegates
        authorEditText.setDelegate(this);
        categoryEditText.setDelegate(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_book_add, menu);
        ActionBarCustomizer.customizeActionBar(getSupportActionBar());
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            authorEditText.setAuthor((Author)authorDataAccessObject.findById(data.getExtras().getLong(AuthorChooseActivity.AUTHOR_DATA_ID)));
        }
    }
    //endregion

    //region Getters And Setters
    public void setBook(Book book) {
        this.book = book;
        this.bookNameEditText.setText(book.getName());
    }
    private void setActivityTitle() {
        Book possibleEditBook = (Book) getIntent().getSerializableExtra(BOOK_INTENT_GET_NAME);
        if (possibleEditBook != null) {
            setTitle("EditBook");
        } else {
            setTitle("Add Book");
        }
    }
    //endregion

    //region Delegates
    @Override
    public void authorNameEditTextWantsToOpenAuthorActivity() {
        Intent authorActivityIntent = new Intent(this, AuthorChooseActivity.class);
        startActivityForResult(authorActivityIntent, RESULT_OK);
    }
    @Override
    public void categoryEditTextWantsToOpenCategoryActivity() {
        Intent categoryActivityIntent = new Intent(this, CategoryChooseActivity.class);
        startActivity(categoryActivityIntent);

    }
    //endregion

    //region Actions
    public void onCoverClick(View view) {
        Intent coverSearchIntent = new Intent(this, CoverSearchActivity.class);
        startActivity(coverSearchIntent);
    }
    public void onSaveClick(View view) {
        List<BookAddChainOfResponsibility> processors = new ArrayList<BookAddChainOfResponsibility>();
        processors.add(bookNameEditText);
        processors.add(authorEditText);
        processors.add(categoryEditText);
        processors.add(pagesEditText);
        processors.add(progessPagesSeekBar);
        try {
            Book newBook = bookFactory.newBook(processors);
        } catch (Exception e) {
            NotificationShower.showError(e.getMessage(), getApplicationContext(), this);
        }



    }
    //endregion

}
