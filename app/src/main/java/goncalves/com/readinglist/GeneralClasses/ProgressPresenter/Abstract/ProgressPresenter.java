package goncalves.com.readinglist.GeneralClasses.ProgressPresenter.Abstract;

import android.app.Activity;

/**
 * Created by rafagonc on 1/19/16.
 */
public interface ProgressPresenter {

    public void showProgress(String message, Activity activity);
    public void stop();

}
