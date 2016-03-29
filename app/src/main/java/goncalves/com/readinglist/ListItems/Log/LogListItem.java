package goncalves.com.readinglist.ListItems.Log;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rafagonc on 3/26/16.
 */
public class LogListItem {

    //region UI
    private ImageView imageView;
    private TextView textView;
    //endregion

    //region Getters and Setters
    public ImageView getImageView() {
        return imageView;
    }
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
    public TextView getTextView() {
        return textView;
    }
    public void setTextView(TextView textView) {
        this.textView = textView;
    }
    //endregion
}
