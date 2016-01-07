package goncalves.com.readinglist.Factories.Abstract;

import java.util.List;

import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.Interfaces.BookAddChainOfResponsibility;

/**
 * Created by rafagonc on 1/5/16.
 */
public interface BookFactory {

    public Book newBook(List<BookAddChainOfResponsibility> processors) throws Exception;

}
