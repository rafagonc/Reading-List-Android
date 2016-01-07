package goncalves.com.readinglist.Factories.Concrete;

import com.google.inject.Inject;

import goncalves.com.readinglist.DAOs.Abstract.AuthorDataAccessObject;
import goncalves.com.readinglist.Entities.Abstract.Author;
import goncalves.com.readinglist.Factories.Abstract.AuthorFactory;

/**
 * Created by rafagonc on 1/5/16.
 */
public class AuthorFactoryImpl implements AuthorFactory {

    @Inject AuthorDataAccessObject authorDataAccessObject;

    @Override
    public Author newAuthor(String name) {
        Author newAuthor = (Author)authorDataAccessObject.insert();
        newAuthor.setName(name);
        return newAuthor;
    }
}
