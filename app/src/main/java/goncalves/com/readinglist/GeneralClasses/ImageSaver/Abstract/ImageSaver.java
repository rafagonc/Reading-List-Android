package goncalves.com.readinglist.GeneralClasses.ImageSaver.Abstract;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;

/**
 * Created by rafagonc on 1/19/16.
 */
public interface ImageSaver {

    public String fileNameForSavedDrawable(Bitmap bitmap, Activity activity);
    public Bitmap getImageWithFilename(String filename, Context context);

}
