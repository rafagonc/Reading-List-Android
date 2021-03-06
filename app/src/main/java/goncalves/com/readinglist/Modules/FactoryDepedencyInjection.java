package goncalves.com.readinglist.Modules;

import com.google.inject.AbstractModule;

import goncalves.com.readinglist.Factories.Entities.Abstract.AuthorFactory;
import goncalves.com.readinglist.Factories.Entities.Abstract.BookFactory;
import goncalves.com.readinglist.Factories.Entities.Abstract.CategoryFactory;
import goncalves.com.readinglist.Factories.Entities.Abstract.LogFactory;
import goncalves.com.readinglist.Factories.Entities.Abstract.StaticDataFactory;
import goncalves.com.readinglist.Factories.Entities.Concrete.AuthorFactoryImpl;
import goncalves.com.readinglist.Factories.Entities.Concrete.BookFactoryImpl;
import goncalves.com.readinglist.Factories.Entities.Concrete.CategoryFactoryImpl;
import goncalves.com.readinglist.Factories.Entities.Concrete.LogFactoryImpl;
import goncalves.com.readinglist.Factories.Entities.Concrete.StaticDataFactoryImpl;
import goncalves.com.readinglist.Factories.Fragment.Abstract.MainPagerFragmentFactory;
import goncalves.com.readinglist.Factories.Fragment.Concrete.MainPagerFragmentFactoryImpl;
import goncalves.com.readinglist.Factories.Response.Abstract.GoogleBooksResponseFactory;
import goncalves.com.readinglist.Factories.Response.Abstract.GoogleCoverResponseFactory;
import goncalves.com.readinglist.Factories.Response.Concrete.GoogleBooksResponseFactoryImpl;
import goncalves.com.readinglist.Factories.Response.Concrete.GoogleCoverResponseFactoryImpl;
import goncalves.com.readinglist.Factories.Server.Abstract.ServiceCallFactory;
import goncalves.com.readinglist.Factories.Server.Concrete.ServiceCallFactoryImpl;

/**
 * Created by rafagonc on 1/5/16.
 */
public class FactoryDepedencyInjection extends AbstractModule {

    //region Injections
    @Override
    protected void configure() {
        bind(LogFactory.class).to(LogFactoryImpl.class);
        bind(BookFactory.class).to(BookFactoryImpl.class);
        bind(AuthorFactory.class).to(AuthorFactoryImpl.class);
        bind(CategoryFactory.class).to(CategoryFactoryImpl.class);
        bind(StaticDataFactory.class).to(StaticDataFactoryImpl.class);
        bind(ServiceCallFactory.class).to(ServiceCallFactoryImpl.class);
        bind(MainPagerFragmentFactory.class).to(MainPagerFragmentFactoryImpl.class);
        bind(GoogleCoverResponseFactory.class).to(GoogleCoverResponseFactoryImpl.class);
        bind(GoogleBooksResponseFactory.class).to(GoogleBooksResponseFactoryImpl.class);
    }
    //endregion

}
