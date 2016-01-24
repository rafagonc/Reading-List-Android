package goncalves.com.readinglist.ViewAdapters.Concrete;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.Button;

import com.google.inject.Inject;

import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.GeneralClasses.ImageSaver.Abstract.ImageSaver;
import goncalves.com.readinglist.Interfaces.BookAddChainOfResponsibility;
import roboguice.RoboGuice;

/**
 * Created by rafagonc on 1/19/16.
 */
public class CoverButton extends Button implements BookAddChainOfResponsibility {

    //region Properties
    private String filename;
    @Inject ImageSaver imageSaver;
    //endregion

    //region Constructor
    public CoverButton(Context context) {
        super(context);
        onConstruct();
    }
    public CoverButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        onConstruct();
    }
    public CoverButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onConstruct();
    }
    private void onConstruct() {
        RoboGuice.getInjector(getContext()).injectMembers(this);
    }
    //endregion

    //region Chain Of Responsibility
    @Override
    public void processBook(Book book) throws Exception {
        if (this.filename != null) {
            book.setFilename(this.filename);
        }
    }
    //endregion

    //region Getters and Setters
    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
        if (filename != null) {
            setBackground(new BitmapDrawable(imageSaver.getImageWithFilename(filename, getContext())));
            setText("");
        }
    }
    //endregion
}
