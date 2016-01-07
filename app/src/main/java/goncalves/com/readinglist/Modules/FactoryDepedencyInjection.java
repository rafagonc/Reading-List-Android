package goncalves.com.readinglist.Modules;

import com.google.inject.AbstractModule;
import goncalves.com.readinglist.Factories.Abstract.AuthorFactory;
import goncalves.com.readinglist.Factories.Abstract.BookFactory;
import goncalves.com.readinglist.Factories.Abstract.CategoryFactory;
import goncalves.com.readinglist.Factories.Concrete.AuthorFactoryImpl;
import goncalves.com.readinglist.Factories.Concrete.BookFactoryImpl;
import goncalves.com.readinglist.Factories.Concrete.CategoryFactoryImpl;

/**
 * Created by rafagonc on 1/5/16.
 */
public class FactoryDepedencyInjection extends AbstractModule {

    //region Injections
    @Override
    protected void configure() {
        bind(BookFactory.class).to(BookFactoryImpl.class);
        bind(AuthorFactory.class).to(AuthorFactoryImpl.class);
        bind(CategoryFactory.class).to(CategoryFactoryImpl.class);
    }
    //endregion

}
