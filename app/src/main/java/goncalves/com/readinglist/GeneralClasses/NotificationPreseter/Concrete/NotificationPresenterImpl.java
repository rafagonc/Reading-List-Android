package goncalves.com.readinglist.GeneralClasses.NotificationPreseter.Concrete;

import android.app.Activity;
import android.content.Context;

import com.nispok.snackbar.Snackbar;

import goncalves.com.readinglist.GeneralClasses.NotificationPreseter.Abstract.NotificationPresenter;
import goncalves.com.readinglist.R;

/**
 * Created by rafagonc on 1/6/16.
 */
public class NotificationPresenterImpl implements NotificationPresenter {

    public void showError(String text, Context applicationContext, Activity activity) {
        Snackbar.with(applicationContext)
                .colorResource(R.color.red)
                .text(text)
                .show(activity);

    }

}
