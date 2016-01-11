package goncalves.com.readinglist.Factories.Abstract;

import android.content.Context;

/**
 * Created by rafagonc on 1/9/16.
 */
public interface StaticDataFactory {

    public static final String STATIC_DATA_ALREADY_CREATED = "STATIC_DATA_ALREADY_CREATED";

    public void createStaticData(Context context);

}
