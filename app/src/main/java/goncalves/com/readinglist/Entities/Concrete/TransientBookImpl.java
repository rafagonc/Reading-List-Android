package goncalves.com.readinglist.Entities.Concrete;

import android.app.Activity;
import android.graphics.Bitmap;

import java.io.Serializable;

import goncalves.com.readinglist.Entities.Abstract.TransientBook;
import goncalves.com.readinglist.GeneralClasses.ImageSaver.Concrete.ImageSaverImpl;

/**
 * Created by rafagonc on 3/12/16.
 */
public class TransientBookImpl implements TransientBook, Serializable {

    //region Properties
    private String name;
    private String authorString;
    private String snippet;
    private String imageURL;
    private static Bitmap _bitmap;
    //endregion

    //region Getters And Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthorString() {
        return authorString;
    }
    public void setAuthorString(String authorString) {
        this.authorString = authorString;
    }
    public String getSnippet() {
        return snippet;
    }
    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    public Bitmap getBitmap() {
        return _bitmap;
    }
    public void setBitmap(Bitmap bitmap) {
        _bitmap = bitmap;
    }

    //endregion


    @Override
    public String createFilenameForSavedCoverImage(Activity activity) throws IllegalStateException {
        String filename;
        if (_bitmap == null) throw new IllegalStateException("no bitmap");
        ImageSaverImpl imageSaver = new ImageSaverImpl();
        filename = imageSaver.fileNameForSavedDrawable(getBitmap(), activity);
        return filename;
    }
}
