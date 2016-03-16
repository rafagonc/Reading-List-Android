package goncalves.com.readinglist.Factories.Entities.Abstract;

import android.app.Activity;

import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.Entities.Abstract.TransientBook;

/**
 * Created by rafagonc on 1/5/16.
 */
public interface BookFactory {

    public Book newBook();
    public Book newBookFromTransientBook(TransientBook transientBook, Activity activity);

}
