package goncalves.com.readinglist.GeneralClasses.ProgressPresenter.Concrete;

import android.app.Activity;
import android.app.ProgressDialog;

import goncalves.com.readinglist.GeneralClasses.ProgressPresenter.Abstract.ProgressPresenter;

/**
 * Created by rafagonc on 1/17/16.
 */
public class ProgressPresenterImpl implements ProgressPresenter {

    static ProgressDialog progress;

    public void showProgress(String message, Activity activity) {
        progress = ProgressDialog.show(activity, "", message);
    }

    public void stop() {
        progress.dismiss();
    }

}
