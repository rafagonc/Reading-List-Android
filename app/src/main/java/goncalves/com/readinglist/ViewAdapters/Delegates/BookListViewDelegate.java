package goncalves.com.readinglist.ViewAdapters.Delegates;

import goncalves.com.readinglist.Entities.Abstract.Book;

/**
 * Created by rafagonc on 1/7/16.
 */
public interface BookListViewDelegate {

    public void wantsToOpenBookDetail(Book book);

}
