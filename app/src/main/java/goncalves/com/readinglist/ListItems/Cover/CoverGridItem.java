package goncalves.com.readinglist.ListItems.Cover;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import goncalves.com.readinglist.Entities.Abstract.GoogleCoverObject;
import goncalves.com.readinglist.R;

/**
 * Created by rafagonc on 1/17/16.
 */
public class CoverGridItem {

    //region UI
    private ImageView imageView;
    private Bitmap bitmap;
    //endregion

    public void setCover(GoogleCoverObject googleCoverObject, Context context) {
        Picasso.with(context).load(googleCoverObject.getUrl()).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                getImageView().setImageBitmap(bitmap);
                setBitmap(bitmap);
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



    //region Getters and Setters
    public ImageView getImageView() {
        return imageView;
    }
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
    public Bitmap getBitmap() {
        return bitmap;
    }
    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
    //endregion

}
