package goncalves.com.readinglist.Activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.inject.Inject;

import goncalves.com.readinglist.DAOs.Abstract.BookDataAccessObject;
import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.R;
import goncalves.com.readinglist.ViewAdapters.Concrete.BookListView;
import goncalves.com.readinglist.ViewAdapters.Delegates.BookListViewDelegate;
import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.InjectView;

public class BookChooseActivity extends RoboActionBarActivity implements BookListViewDelegate {

    //region Constants
    public static final Integer BOOK_CHOOSE_RESULT = 1249;
    public static final String BOOK_CHOOSE_ID = "BOOK_CHOOSE_ID";

    //endregion

    //region Properties
    @Inject BookDataAccessObject bookDataAccessObject;
    //endregion

    //region UI
    @InjectView(R.id.bookChooseListView) BookListView bookListView;
    //endregion

    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_choose);
        bookListView.setBooks(bookDataAccessObject.findAll());
        bookListView.setDelegate(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_book_choose, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //endregion

    //region Delegate
    @Override
    public void wantsToOpenBookDetail(Book book) {
        getIntent().putExtra(BOOK_CHOOSE_ID, book.getId());
        setResult(BOOK_CHOOSE_RESULT, getIntent());
        finish();
    }
    //endregion
}
