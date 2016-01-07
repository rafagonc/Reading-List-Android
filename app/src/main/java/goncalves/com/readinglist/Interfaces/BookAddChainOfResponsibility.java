package goncalves.com.readinglist.Interfaces;

import goncalves.com.readinglist.Entities.Abstract.Book;

/**
 * Created by rafagonc on 1/5/16.
 */
public interface BookAddChainOfResponsibility {

    public void processBook(Book book) throws Exception;

}
