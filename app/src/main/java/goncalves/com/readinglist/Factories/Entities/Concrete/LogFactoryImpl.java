package goncalves.com.readinglist.Factories.Entities.Concrete;

import com.google.inject.Inject;

import goncalves.com.readinglist.DAOs.Abstract.LogDataAccessObject;
import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.Entities.Abstract.Log;
import goncalves.com.readinglist.Entities.Concrete.LogImpl;
import goncalves.com.readinglist.Factories.Entities.Abstract.LogFactory;

/**
 * Created by rafagonc on 3/25/16.
 */
public class LogFactoryImpl implements LogFactory {

    @Inject LogDataAccessObject logDataAccessObject;

    @Override
    public Log log(Book book) {
        LogImpl log  = (LogImpl)logDataAccessObject.insert();
        log.setBookName(book.getName());
        return log;
    }
}
