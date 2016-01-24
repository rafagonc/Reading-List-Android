package goncalves.com.readinglist.ListItems.Cover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

import goncalves.com.readinglist.Entities.Abstract.GoogleCoverObject;
import goncalves.com.readinglist.R;

/**
 * Created by rafagonc on 1/17/16.
 */
public class CoverGridAdapter extends BaseAdapter {

    //region Properties
    private List<GoogleCoverObject> covers;
    private LayoutInflater layoutInflater;
    private Context context;
    //endregion

    //region Constructor
    public CoverGridAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }
    //endregion

    //region Adapter Methods
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CoverGridItem item;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.cover_grid_item, null);
            item = new CoverGridItem();
            item.setImageView((ImageView)convertView.findViewById(R.id.coverGridItemImageView));
            convertView.setTag(item);
        } else {
            item = (CoverGridItem)convertView.getTag();
        }
        GoogleCoverObject cover = this.covers.get(position);
        item.setCover(cover, context);
        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return covers.get(position);
    }

    @Override
    public int getCount() {
        return covers.size();
    }
    //endregion

    //region Getters and Setters
    public List<GoogleCoverObject> getCovers() {
        return covers;
    }
    public void setCovers(List<GoogleCoverObject> covers) {
        this.covers = covers;
        notifyDataSetChanged();
    }
    //endregion
}
