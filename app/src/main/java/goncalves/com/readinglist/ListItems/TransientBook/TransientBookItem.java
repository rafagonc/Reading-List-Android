package goncalves.com.readinglist.ListItems.TransientBook;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import goncalves.com.readinglist.Entities.Abstract.TransientBook;
import goncalves.com.readinglist.R;

/**
 * Created by rafagonc on 3/12/16.
 */
public class TransientBookItem {

    //region Properties
    private TextView bookNameTextView;
    private ImageView imageView;
    private TransientBook book;
    //endregion

    //region Setters and Getters
    public TextView getBookNameTextView() {
        return bookNameTextView;
    }
    public void setBookNameTextView(TextView bookNameTextView) {
        this.bookNameTextView = bookNameTextView;
    }
    public ImageView getImageView() {
        return imageView;
    }
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
    public TransientBook getBook() {
        return book;
    }
    public void setBook(final TransientBook book, Context context) {
        this.book = book;
        getBookNameTextView().setText(book.getName());
        Picasso.with(context).load(book.getImageURL()).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                getImageView().setImageBitmap(bitmap);
                book.setBitmap(bitmap);
            }
            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }
            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                getImageView().setImageResource(R.drawable.loading_cover);
            }
        });
    }
    //endregion

}
