package goncalves.com.readinglist.GeneralClasses.NotificationPreseter.Abstract;

import android.app.Activity;
import android.content.Context;

/**
 * Created by rafagonc on 1/19/16.
 */
public interface NotificationPresenter {

    public void showError(String text, Context applicationContext, Activity activity);

}
