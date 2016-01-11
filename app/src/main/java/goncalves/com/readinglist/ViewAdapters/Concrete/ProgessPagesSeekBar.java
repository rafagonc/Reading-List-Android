package goncalves.com.readinglist.ViewAdapters.Concrete;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;

import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.Interfaces.BookAddChainOfResponsibility;
import goncalves.com.readinglist.ViewAdapters.Delegates.ProgressPagesSeekBarDelegate;

/**
 * Created by rafagonc on 1/6/16.
 */
public class ProgessPagesSeekBar extends SeekBar implements BookAddChainOfResponsibility {

    private Integer pages;
    private Integer pagesRead;
    private ProgressPagesSeekBarDelegate delegate;

    //region Constructors
    public ProgessPagesSeekBar(Context context) {
        super(context);
        onConstruct();
    }
    public ProgessPagesSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        onConstruct();
    }
    public ProgessPagesSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onConstruct();
    }
    private void onConstruct() {
        setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (delegate != null) {
                    delegate.pagesProgressSeekBarChanged(getProgress());
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
    //endregion

    //region Chain Of Responsibility
    @Override
    public void processBook(Book book) throws Exception {
        book.setPagesRead(getProgress());
    }
    //endregion

    //region Getters and setters
    public ProgressPagesSeekBarDelegate getDelegate() {
        return delegate;
    }
    public void setDelegate(ProgressPagesSeekBarDelegate delegate) {
        this.delegate = delegate;
    }
    public Integer getPagesRead() {
        return pagesRead;
    }
    public void setPagesRead(Integer pagesRead) {
        this.pagesRead = pagesRead;
        setProgress(pagesRead);
    }
    public Integer getPages() {
        return pages;
    }
    public void setPages(Integer pages) {
        this.pages = pages;
        setMax(pages);
        setProgress(0);
    }
    //endregion
}
