package goncalves.com.readinglist.ViewAdapters.Concrete;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import goncalves.com.readinglist.Entities.Abstract.GoogleCoverObject;
import goncalves.com.readinglist.ListItems.Cover.CoverGridAdapter;
import goncalves.com.readinglist.ListItems.Cover.CoverGridItem;
import goncalves.com.readinglist.ViewAdapters.Delegates.CoverGridViewDelegate;

/**
 * Created by rafagonc on 1/17/16.
 */
public class CoverGridView extends GridView {

    //region Properties
    private List<GoogleCoverObject> items;
    private CoverGridAdapter coverGridAdapter;
    private CoverGridViewDelegate delegate;
    //endregion

    //region Constructor
    public CoverGridView(Context context) {
        super(context);
        onConstruct();;
    }

    public CoverGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        onConstruct();;
    }

    public CoverGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onConstruct();;
    }
    public void onConstruct() {
        coverGridAdapter = new CoverGridAdapter(getContext());
        setItems(new ArrayList<GoogleCoverObject>());
        setAdapter(this.coverGridAdapter);
        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CoverGridItem item = (CoverGridItem)view.getTag();
                if (item.getImageView().getDrawable() != null) {
                    if (delegate != null) delegate.coverGridViewSelectedImage(item.getBitmap());
                }
            }
        });
    }
    //endregion

    //region Getters and Setters
    public List<GoogleCoverObject> getItems() {
        return items;
    }
    public void setItems(List<GoogleCoverObject> items) {
        this.items = items;
        coverGridAdapter.setCovers(items);
        invalidateViews();
    }
    public CoverGridAdapter getCoverGridAdapter() {
        return coverGridAdapter;
    }
    public void setCoverGridAdapter(CoverGridAdapter coverGridAdapter) {
        this.coverGridAdapter = coverGridAdapter;
    }
    public CoverGridViewDelegate getDelegate() {
        return delegate;
    }
    public void setDelegate(CoverGridViewDelegate delegate) {
        this.delegate = delegate;
    }
    //endregion

}
