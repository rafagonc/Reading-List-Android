package goncalves.com.readinglist.Entities.Abstract;

import android.app.Activity;
import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by rafagonc on 3/12/16.
 */
public interface TransientBook extends Serializable {

    public String getName();
    public String getImageURL();
    public String getSnippet();
    public String getAuthorString();
    public void setName(String name);
    public void setAuthorString(String author);
    public void setBitmap(Bitmap bitmap);
    public Bitmap getBitmap();

    public String createFilenameForSavedCoverImage(Activity activity) throws IllegalStateException;
}
