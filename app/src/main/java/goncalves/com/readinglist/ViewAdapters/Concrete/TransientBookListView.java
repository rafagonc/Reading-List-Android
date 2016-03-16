package goncalves.com.readinglist.ViewAdapters.Concrete;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import goncalves.com.readinglist.Entities.Abstract.TransientBook;
import goncalves.com.readinglist.ListItems.TransientBook.TransientBookAdapter;
import goncalves.com.readinglist.ViewAdapters.Delegates.TransientBookListViewDelegate;

/**
 * Created by rafagonc on 3/12/16.
 */
public class TransientBookListView extends ListView {

    private List<TransientBook> books;
    private TransientBookAdapter transientBookAdapter;
    private TransientBookListViewDelegate delegate;

    //region Constructor
    public TransientBookListView(Context context) {
        super(context);
        onConstruct();
    }

    public TransientBookListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        onConstruct();
    }

    public TransientBookListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onConstruct();
    }
    private void onConstruct() {
        transientBookAdapter = new TransientBookAdapter(getContext());
        setAdapter(transientBookAdapter);
        setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (delegate != null) {
                    delegate.transientListViewWantsToAddTransientBook(books.get(position));
                }
            }
        });

    }
    //endregion


    //region Setters and getters
    public List<TransientBook> getBooks() {
        return books;
    }
    public void setBooks(List<TransientBook> books) {
        this.books = books;
        transientBookAdapter.setTransientBooks(books);
        transientBookAdapter.notifyDataSetChanged();
    }
    public TransientBookListViewDelegate getDelegate() {
        return delegate;
    }
    public void setDelegate(TransientBookListViewDelegate delegate) {
        this.delegate = delegate;
    }
    //endregion
}
