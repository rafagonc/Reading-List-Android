package goncalves.com.readinglist.ViewAdapters.Concrete;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.Interfaces.BookAddChainOfResponsibility;

/**
 * Created by rafagonc on 1/6/16.
 */
public class PagesEditText extends EditText implements BookAddChainOfResponsibility {

    //region Constructors
    public PagesEditText(Context context) {
        super(context);
    }

    public PagesEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PagesEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //endregion

    //region Chain Of Responsibility
    @Override
    public void processBook(Book book) throws Exception {
        Integer pages = Integer.parseInt(this.getText().toString());
        book.setPages(pages);
    }
    //endregion
}
