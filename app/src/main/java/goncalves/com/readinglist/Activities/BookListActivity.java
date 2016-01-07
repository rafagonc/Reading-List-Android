package goncalves.com.readinglist.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import goncalves.com.readinglist.Customizers.ActionBarCustomizer;
import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.Entities.Concrete.BookImpl;
import goncalves.com.readinglist.R;
import goncalves.com.readinglist.ViewAdapters.Concrete.BookListView;
import goncalves.com.readinglist.ViewAdapters.Delegates.BookListViewDelegate;
import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.InjectView;


public class BookListActivity extends RoboActionBarActivity implements BookListViewDelegate {

    //region UI Properties
    @InjectView(R.id.bookListView) BookListView bookListView;
    //endregion

    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        BookImpl book1 = new BookImpl();
        book1.setName("Rafael");
        BookImpl book2 = new BookImpl();
        book2.setName("Gonçalves");
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(book1);
        books.add(book2);
        this.bookListView.setBooks(books);
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
        startActivity(bookAddIntent);
    }
    //endregion

}
