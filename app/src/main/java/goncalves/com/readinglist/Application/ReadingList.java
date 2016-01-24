package goncalves.com.readinglist.Application;

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;
import com.orm.SugarContext;

import goncalves.com.readinglist.Factories.Entities.Concrete.StaticDataFactoryImpl;
import io.fabric.sdk.android.Fabric;

/**
 * Created by rafagonc on 1/7/16.
 */
public class ReadingList extends Application {

    StaticDataFactoryImpl staticDataFactory;
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        context = getApplicationContext();
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
