package goncalves.com.readinglist.ViewAdapters.Concrete;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import goncalves.com.readinglist.Entities.Abstract.Author;
import goncalves.com.readinglist.ListItems.Author.AuthorListViewAdapter;
import goncalves.com.readinglist.ViewAdapters.Delegates.AuthorListViewDelegate;

/**
 * Created by rafagonc on 1/7/16.
 */
public class AuthorListView extends ListView {

    //region Properties
    private AuthorListViewDelegate delegate;
    private AuthorListViewAdapter authorListViewAdapter;
    private List<Author> authors;
    //endregion

    //region Constructors
    public AuthorListView(Context context) {
        super(context);
        onConstruct();
    }

    public AuthorListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        onConstruct();
    }

    public AuthorListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onConstruct();
    }
    private void onConstruct() {
        this.authors = new ArrayList<>();
        this.authorListViewAdapter = new AuthorListViewAdapter(this.authors, this.getContext());
        this.setAdapter(authorListViewAdapter);
        this.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getDelegate().wantsToSelectAuthor(getAuthors().get(position));
            }
        });
    }
    //endregion

    //region Getters And Setters
    public AuthorListViewDelegate getDelegate() {
        return delegate;
    }
    public void setDelegate(AuthorListViewDelegate delegate) {
        this.delegate = delegate;
    }
    public AuthorListViewAdapter getAuthorListViewAdapter() {
        return authorListViewAdapter;
    }
    public List<Author> getAuthors() {
        return authors;
    }
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
        getAuthorListViewAdapter().setAuthors(authors);
        getAuthorListViewAdapter().notifyDataSetChanged();
    }
    //endregion
}
