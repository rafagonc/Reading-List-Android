package goncalves.com.readinglist.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import goncalves.com.readinglist.Customizers.ActionBarCustomizer;
import goncalves.com.readinglist.DAOs.Abstract.BookDataAccessObject;
import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.R;
import goncalves.com.readinglist.ViewAdapters.Concrete.BookListView;
import goncalves.com.readinglist.ViewAdapters.Delegates.BookListViewDelegate;
import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.InjectView;


public class BookListActivity extends RoboActionBarActivity implements BookListViewDelegate {

    //region UI Properties
    @InjectView(R.id.bookListView) BookListView bookListView;
    //endregion

    //region Properties
    @Inject BookDataAccessObject bookDataAccessObject;
    //endregion

    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        this.bookListView.setBooks(bookDataAccessObject.findAll());
        bookListView.setDelegate(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_book_list, menu);
        ActionBarCustomizer.customizeActionBar(getSupportActionBar());
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actions_add) {
            Intent addBookIntent = new Intent(this, BookAddActivity.class);
            startActivity(addBookIntent);
        }
        return super.onOptionsItemSelected(item);
    }
    //endregion

    //region Delegates
    @Override
    public void wantsToOpenBookDetail(Book book) {
        Intent bookAddIntent = new Intent(this, BookAddActivity.class);
        Log.i("ID", book.getId().toString());
        bookAddIntent.putExtra(BookAddActivity.BOOK_DATA_ID, book.getId());
        startActivity(bookAddIntent);
    }
    //endregion

}
