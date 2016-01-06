package goncalves.com.readinglist.Modules;

import com.google.inject.AbstractModule;
import goncalves.com.readinglist.DAOs.Abstract.AuthorDataAccessObject;
import goncalves.com.readinglist.DAOs.Abstract.BookDataAccessObject;
import goncalves.com.readinglist.DAOs.Abstract.CategoryDataAccessObject;
import goncalves.com.readinglist.DAOs.Concrete.AuthorDataAccessObjectImpl;
import goncalves.com.readinglist.DAOs.Concrete.BookDataAccessObjectImpl;
import goncalves.com.readinglist.DAOs.Concrete.CategoryDataAccessObjectImpl;

/**
 * Created by rafagonc on 1/5/16.
 */
public abstract class DAODependencyInjection  extends AbstractModule {

    //region Injections
    public void bind() {
        bind(BookDataAccessObject.class).to(BookDataAccessObjectImpl.class);
        bind(AuthorDataAccessObject.class).to(AuthorDataAccessObjectImpl.class);
        bind(CategoryDataAccessObject.class).to(CategoryDataAccessObjectImpl.class);
    }
    //endregion

}
