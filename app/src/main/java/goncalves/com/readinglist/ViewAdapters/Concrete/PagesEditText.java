package goncalves.com.readinglist.ViewAdapters.Concrete;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.Entities.Abstract.Log;
import goncalves.com.readinglist.Exceptions.InvalidPagesException;
import goncalves.com.readinglist.Interfaces.BookAddChainOfResponsibility;
import goncalves.com.readinglist.Interfaces.LogAddChainOfResponsibility;
import goncalves.com.readinglist.ViewAdapters.Delegates.PagesEditTextDelegate;

/**
 * Created by rafagonc on 1/6/16.
 */
public class PagesEditText extends EditText implements BookAddChainOfResponsibility, LogAddChainOfResponsibility {

    //region Properties
    private PagesEditTextDelegate delegate;
    private Integer pages;
    //endregion

    //region Constructors
    public PagesEditText(Context context) {
        super(context);
        onConstruct();
    }
    public PagesEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        onConstruct();
    }
    public PagesEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onConstruct();
    }
    private void onConstruct() {
        setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    if (delegate != null) {
                        delegate.userDidSetBookPages(getPagesOnTextEdit());
                    }
                    return true;
                }
                return false;
            }
        });
    }
    //endregion

    //region Chain Of Responsibility
    @Override
    public void processBook(Book book) throws Exception {
        if (this.getText().length() > 0 ) {
            Integer pages = Integer.parseInt(this.getText().toString());
            book.setPages(pages);
        }
    }
    @Override
    public void processLog(Log log) throws Exception {
        if (this.getText().length() > 0) {
            log.setPages(Integer.parseInt(getText().toString()));
        } else {
            throw new InvalidPagesException();
        }

    }
    //endregion

    //region Getters and Setters
    public PagesEditTextDelegate getDelegate() {
        return delegate;
    }
    public void setDelegate(PagesEditTextDelegate delegate) {
        this.delegate = delegate;
    }
    private Integer getPagesOnTextEdit() {
        return Integer.parseInt(getText().toString());
    }
    public Integer getPages() {
        return pages;
    }
    public void setPages(Integer pages) {
        this.pages = pages;
        if (pages != null) setText(pages.toString());
    }
    //endregion

}
