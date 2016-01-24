package goncalves.com.readinglist.DAOs.Abstract;

import java.util.List;

import goncalves.com.readinglist.Entities.Abstract.Book;

/**
 * Created by rafagonc on 1/5/16.
 */
public interface BookDataAccessObject extends DataAccessObject {

    public List<Book> findAll();

}
