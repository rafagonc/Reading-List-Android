package goncalves.com.readinglist.ViewAdapters.Concrete;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;

import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.Interfaces.BookAddChainOfResponsibility;

/**
 * Created by rafagonc on 1/6/16.
 */
public class ProgessPagesSeekBar extends SeekBar implements BookAddChainOfResponsibility {

    //region Constructors
    public ProgessPagesSeekBar(Context context) {
        super(context);
    }

    public ProgessPagesSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgessPagesSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //endregion

    //region Chain Of Responsibility
    @Override
    public void processBook(Book book) throws Exception {

    }
    //endregion

}
