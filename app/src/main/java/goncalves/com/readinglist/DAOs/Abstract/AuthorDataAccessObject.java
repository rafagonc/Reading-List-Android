package goncalves.com.readinglist.DAOs.Abstract;

import goncalves.com.readinglist.Entities.Abstract.Author;

/**
 * Created by rafagonc on 1/5/16.
 */
public interface AuthorDataAccessObject extends DataAccessObject {

    public Author findByName(String name);

}
