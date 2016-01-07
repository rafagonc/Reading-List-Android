package goncalves.com.readinglist.Factories.Concrete;

import com.google.inject.Inject;

import java.util.List;

import goncalves.com.readinglist.DAOs.Abstract.BookDataAccessObject;
import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.Factories.Abstract.BookFactory;
import goncalves.com.readinglist.Interfaces.BookAddChainOfResponsibility;

/**
 * Created by rafagonc on 1/5/16.
 */
public class BookFactoryImpl implements BookFactory {

    @Inject BookDataAccessObject bookDataAccessObject;

    @Override
    public Book newBook(List<BookAddChainOfResponsibility> processors) throws Exception {
        Book newBook = (Book)this.bookDataAccessObject.insert();
        for (BookAddChainOfResponsibility processor : processors) {
            processor.processBook(newBook);
        }
        return newBook;
    }
}
