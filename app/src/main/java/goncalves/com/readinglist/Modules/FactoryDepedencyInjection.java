package goncalves.com.readinglist.Modules;

import com.google.inject.AbstractModule;

import goncalves.com.readinglist.Factories.Abstract.AuthorFactory;
import goncalves.com.readinglist.Factories.Abstract.BookFactory;
import goncalves.com.readinglist.Factories.Abstract.CategoryFactory;
import goncalves.com.readinglist.Factories.Abstract.ServiceCallFactory;
import goncalves.com.readinglist.Factories.Abstract.StaticDataFactory;
import goncalves.com.readinglist.Factories.Concrete.AuthorFactoryImpl;
import goncalves.com.readinglist.Factories.Concrete.BookFactoryImpl;
import goncalves.com.readinglist.Factories.Concrete.CategoryFactoryImpl;
import goncalves.com.readinglist.Factories.Concrete.ServiceCallFactoryImpl;
import goncalves.com.readinglist.Factories.Concrete.StaticDataFactoryImpl;

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
        bind(StaticDataFactory.class).to(StaticDataFactoryImpl.class);
        bind(ServiceCallFactory.class).to(ServiceCallFactoryImpl.class);
    }
    //endregion

}
