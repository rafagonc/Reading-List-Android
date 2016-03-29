package goncalves.com.readinglist.Factories.Entities.Abstract;

import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.Entities.Abstract.Log;

/**
 * Created by rafagonc on 3/25/16.
 */
public interface LogFactory {

    public Log log(Book book);

}
