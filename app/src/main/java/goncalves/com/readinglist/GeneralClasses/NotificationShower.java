package goncalves.com.readinglist.GeneralClasses;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.nispok.snackbar.Snackbar;

import goncalves.com.readinglist.R;

/**
 * Created by rafagonc on 1/6/16.
 */
public class NotificationShower {

    public static void showError(String text, Context applicationContext, Activity activity) {
        Snackbar.with(applicationContext)
                .colorResource(R.color.red)
                .text(text)
                .show(activity);

    }

}
