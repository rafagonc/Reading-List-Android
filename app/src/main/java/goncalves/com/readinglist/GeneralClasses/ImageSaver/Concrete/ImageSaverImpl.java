package goncalves.com.readinglist.GeneralClasses.ImageSaver.Concrete;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

import goncalves.com.readinglist.GeneralClasses.ImageSaver.Abstract.ImageSaver;

/**
 * Created by rafagonc on 1/19/16.
 */
public class ImageSaverImpl implements ImageSaver {

    @Override
    public String fileNameForSavedDrawable(Bitmap bitmap, Activity activity) {
        String filename = UUID.randomUUID().toString();
        try {
            FileOutputStream stream = activity.openFileOutput(filename, Context.MODE_PRIVATE);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filename;
    }

    @Override
    public Bitmap getImageWithFilename(String filename, Context context) {
        try {
            InputStream is = context.openFileInput(filename);
            Bitmap b = BitmapFactory.decodeStream(is);
            return b;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
