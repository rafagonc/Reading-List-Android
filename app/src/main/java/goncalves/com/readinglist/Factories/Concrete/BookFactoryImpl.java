package goncalves.com.readinglist.Factories.Concrete;

import com.google.inject.Inject;

import goncalves.com.readinglist.DAOs.Abstract.BookDataAccessObject;
import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.Factories.Abstract.BookFactory;

/**
 * Created by rafagonc on 1/5/16.
 */
public class BookFactoryImpl implements BookFactory {

    @Inject BookDataAccessObject bookDataAccessObject;

    @Override
    public Book newBook() {
        Book newBook = (Book)this.bookDataAccessObject.insert();
        return newBook;
    }
}
