package goncalves.com.readinglist.Application;

import android.app.Application;

import com.orm.SugarContext;

import goncalves.com.readinglist.Factories.Concrete.StaticDataFactoryImpl;

/**
 * Created by rafagonc on 1/7/16.
 */
public class ReadingList extends Application {

    StaticDataFactoryImpl staticDataFactory;

    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(getApplicationContext());
        staticDataFactory = new StaticDataFactoryImpl();
        staticDataFactory.createStaticData(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
