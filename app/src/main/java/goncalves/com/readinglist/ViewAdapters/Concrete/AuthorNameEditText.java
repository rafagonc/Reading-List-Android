package goncalves.com.readinglist.ViewAdapters.Concrete;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import goncalves.com.readinglist.Entities.Abstract.Author;
import goncalves.com.readinglist.Exceptions.InvalidAuthorException;
import goncalves.com.readinglist.Interfaces.BookAddChainOfResponsibility;
import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.ViewAdapters.Delegates.AuthorNameEditTextDelegate;

/**
 * Created by rafagonc on 1/5/16.
 */
public class AuthorNameEditText extends EditText implements BookAddChainOfResponsibility {

    private Author author;
    private AuthorNameEditTextDelegate delegate;

    //region Constructor
    public AuthorNameEditText(Context context) {
        super(context);
        setCallback();
    }
    public AuthorNameEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCallback();
    }
    public AuthorNameEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCallback();
    }
    //endregion

    //region Chain Of Responsibility
    @Override
    public void processBook(Book book) throws Exception {
        if (this.author == null) {
            throw new InvalidAuthorException();
        }
        book.setAuthor(this.author);
    }
    //endregion

    //region Getters And Setters
    public void setCallback() {
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (delegate != null) {
                    delegate.authorNameEditTextWantsToOpenAuthorActivity();
                }
            }
        });
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
        setText(author.getName());
    }
    public AuthorNameEditTextDelegate getDelegate() {
        return delegate;
    }
    public void setDelegate(AuthorNameEditTextDelegate delegate) {
        this.delegate = delegate;
    }
    //endregion

}
