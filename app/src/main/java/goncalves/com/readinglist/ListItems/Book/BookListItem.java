package goncalves.com.readinglist.ListItems.Book;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rafagonc on 1/6/16.
 */
public class BookListItem {

    //region UI Properties
    private TextView bookTextView;
    private ImageView coverImageView;
    private TextView progressTextView;
    private ImageView completedImageView;
    //endregion

    //region Getters And Setters

    public TextView getBookTextView() {
        return bookTextView;
    }

    public void setBookTextView(TextView bookTextView) {
        this.bookTextView = bookTextView;
    }

    public ImageView getCoverImageView() {
        return coverImageView;
    }

    public void setCoverImageView(ImageView coverImageView) {
        this.coverImageView = coverImageView;
    }

    public TextView getProgressTextView() {
        return progressTextView;
    }

    public void setProgressTextView(TextView progressTextView) {
        this.progressTextView = progressTextView;
    }

    public ImageView getCompletedImageView() {
        return completedImageView;
    }

    public void setCompletedImageView(ImageView completedImageView) {
        this.completedImageView = completedImageView;
    }
    //endregion
}
