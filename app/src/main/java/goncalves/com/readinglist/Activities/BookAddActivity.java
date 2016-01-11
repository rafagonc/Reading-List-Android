package goncalves.com.readinglist.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import goncalves.com.readinglist.Customizers.ActionBarCustomizer;
import goncalves.com.readinglist.DAOs.Abstract.AuthorDataAccessObject;
import goncalves.com.readinglist.DAOs.Abstract.BookDataAccessObject;
import goncalves.com.readinglist.DAOs.Abstract.CategoryDataAccessObject;
import goncalves.com.readinglist.Entities.Abstract.Author;
import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.Entities.Abstract.Category;
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
import goncalves.com.readinglist.ViewAdapters.Delegates.PagesEditTextDelegate;
import goncalves.com.readinglist.ViewAdapters.Delegates.ProgressPagesSeekBarDelegate;
import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.InjectView;

public class BookAddActivity extends RoboActionBarActivity implements AuthorNameEditTextDelegate, CategoryNameEditTextDelegate, PagesEditTextDelegate, ProgressPagesSeekBarDelegate {

    //region Constants
    public static final String BOOK_INTENT_GET_NAME = "BOOK_INTENT_GET_NAME";
    public static final String BOOK_DATA_ID = "BOOK_DATA_ID";
    //endregion

    //region UI Properties
    @InjectView(R.id.bookNameEditText) BookNameEditText bookNameEditText;
    @InjectView(R.id.authorEditText) AuthorNameEditText authorEditText;
    @InjectView(R.id.categoryEditTextView) CategoryNameEditText categoryEditText;
    @InjectView(R.id.totalPagesEditTextView) PagesEditText pagesEditText;
    @InjectView(R.id.progessSeekBar) ProgessPagesSeekBar progessPagesSeekBar;
    @InjectView(R.id.progressTextView) TextView progressTextView;
    //endregion

    //region Properties
    @Inject BookFactory bookFactory;
    @Inject BookDataAccessObject bookDataAccessObject;
    @Inject AuthorDataAccessObject authorDataAccessObject;
    @Inject CategoryDataAccessObject categoryDataAccessObject;
    private Book book;
    //endregion

    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_add);
        Bundle editData = getIntent().getExtras();
        if (editData != null) {
            setBook((Book)bookDataAccessObject.findById(getIntent().getExtras().getLong(BOOK_DATA_ID)));

        }
        setActivityTitle();

        //set delegates
        authorEditText.setDelegate(this);
        categoryEditText.setDelegate(this);
        pagesEditText.setDelegate(this);
        progessPagesSeekBar.setDelegate(this);
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
        if (resultCode == AuthorChooseActivity.AUTHOR_RESULT) {
            authorEditText.setAuthor((Author)authorDataAccessObject.findById(data.getExtras().getLong(AuthorChooseActivity.AUTHOR_DATA_ID)));
        } else if (resultCode == CategoryChooseActivity.CATEGORY_RESULT) {
            categoryEditText.setCategory((Category)categoryDataAccessObject.findById(data.getExtras().getLong(CategoryChooseActivity.CATEGORY_DATA_ID)));
        }
    }
    //endregion

    //region Getters And Setters
    public Book getBook() {
        if (book == null) book = bookFactory.newBook();
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
        bookNameEditText.setText(book.getName());
        authorEditText.setAuthor(book.getAuthor());
        categoryEditText.setCategory(book.getCategory());
        pagesEditText.setPages(book.getPages());
        progessPagesSeekBar.setPages(book.getPages());
        progessPagesSeekBar.setPagesRead(book.getPagesRead());
        if (book.getPages() > 0) {
            double percentage = ((double)book.getPagesRead()/(double)book.getPages()) * 100;
            progressTextView.setText(new Double(percentage).toString() + "%");
        }
    }
    private void setActivityTitle() {
        Book possibleEditBook = (Book) getIntent().getSerializableExtra(BOOK_INTENT_GET_NAME);
        if (possibleEditBook != null) {
            setTitle("Edit Book");
        } else {
            setTitle("Add Book");
        }
    }
    //endregion

    //region Delegates
    public void authorNameEditTextWantsToOpenAuthorActivity() {
        Intent authorActivityIntent = new Intent(this, AuthorChooseActivity.class);
        startActivityForResult(authorActivityIntent, AuthorChooseActivity.AUTHOR_RESULT);
    }
    public void categoryEditTextWantsToOpenCategoryActivity() {
        Intent categoryActivityIntent = new Intent(this, CategoryChooseActivity.class);
        startActivityForResult(categoryActivityIntent, CategoryChooseActivity.CATEGORY_RESULT);
    }
    public void userDidSetBookPages(Integer pages) {
        progessPagesSeekBar.setPages(pages);
        progessPagesSeekBar.setPagesRead(0);
    }
    public void pagesProgressSeekBarChanged(Integer pagesRead) {
        double percentage = ((double)pagesRead/(double)book.getPages()) * 100;
        progressTextView.setText(new Double(percentage).toString() + "%");
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
            for (BookAddChainOfResponsibility processor : processors) processor.processBook(getBook());
            getBook().saveBook();
        } catch (Exception e) {
            NotificationShower.showError(e.getMessage(), getApplicationContext(), this);
        }
    }
    //endregion

}
