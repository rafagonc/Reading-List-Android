package goncalves.com.readinglist.ViewAdapters.Concrete;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import goncalves.com.readinglist.Exceptions.InvalidNameException;
import goncalves.com.readinglist.Interfaces.BookAddChainOfResponsibility;
import goncalves.com.readinglist.Entities.Abstract.Book;

/**
 * Created by rafagonc on 1/5/16.
 */
public class BookNameEditText extends EditText  implements BookAddChainOfResponsibility {

    //region Constructor
    public BookNameEditText(Context context) {
        super(context);
    }

    public BookNameEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BookNameEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //endregion

    //region Chain Of Responsibility
    @Override
    public void processBook(Book book) throws Exception {
        String bookName = this.getText().toString();
        if (bookName.length() == 0) {
            throw new InvalidNameException();
        }
        book.setName(bookName);
    }
    //endregion
}
