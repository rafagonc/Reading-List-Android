package goncalves.com.readinglist.Factories.Entities.Abstract;

import goncalves.com.readinglist.Entities.Abstract.Author;

/**
 * Created by rafagonc on 1/5/16.
 */
public interface AuthorFactory {

    public Author newAuthor(String name);

}
