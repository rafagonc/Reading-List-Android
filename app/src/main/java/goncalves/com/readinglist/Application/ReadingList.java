package goncalves.com.readinglist.Application;

import android.app.Application;

import com.orm.SugarContext;

/**
 * Created by rafagonc on 1/7/16.
 */
public class ReadingList extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
