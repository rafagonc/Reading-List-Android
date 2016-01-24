package goncalves.com.readinglist.ViewAdapters.Concrete;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.ListItems.Book.BookListViewAdapter;
import goncalves.com.readinglist.R;
import goncalves.com.readinglist.ViewAdapters.Delegates.BookListViewDelegate;

/**
 * Created by rafagonc on 1/6/16.
 */
public class BookListView extends ListView {

    //region Properties
    private BookListViewDelegate delegate;
    private BookListViewAdapter bookListViewAdapter;
    private List<Book> books;
    //endregion

    //region Constructors
    public BookListView(Context context) {
        super(context);
        onConstruct();
    }

    public BookListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        onConstruct();
    }

    public BookListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onConstruct();
    }
    private void onConstruct() {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        addFooterView(layoutInflater.inflate(R.layout.book_list_footer, null));
        this.books = new ArrayList<>();
        this.bookListViewAdapter = new BookListViewAdapter(this.books, this.getContext());
        this.setAdapter(bookListViewAdapter);
        this.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getDelegate().wantsToOpenBookDetail(books.get(position));
            }
        });
    }
    //endregion

    //region Getters And Setters
    public BookListViewDelegate getDelegate() {
        return delegate;
    }

    public void setDelegate(BookListViewDelegate delegate) {
        this.delegate = delegate;
    }
    public BookListViewAdapter getBookListViewAdapter() {
        return bookListViewAdapter;
    }
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
        getBookListViewAdapter().setItens(books);
        getBookListViewAdapter().notifyDataSetChanged();
    }
    //endregion


}
