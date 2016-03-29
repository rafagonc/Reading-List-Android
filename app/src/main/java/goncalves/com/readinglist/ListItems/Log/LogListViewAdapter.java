package goncalves.com.readinglist.ListItems.Log;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import goncalves.com.readinglist.Entities.Abstract.Log;
import goncalves.com.readinglist.GeneralClasses.ImageSaver.Abstract.ImageSaver;
import goncalves.com.readinglist.R;
import roboguice.RoboGuice;

/**
 * Created by rafagonc on 3/26/16.
 */
public class LogListViewAdapter extends BaseAdapter {

    //region Properties
    private List<Log> logs;
    private LayoutInflater layoutInflater;
    private Context context;
    @Inject ImageSaver imageSaver;
    //endregion

    //region Constructor
    public LogListViewAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        this.logs = new ArrayList<>();
        this.context = context;
        RoboGuice.getInjector(context).injectMembers(this);
    }
    //endregion

    //region Adapter
    @Override
    public int getCount() {
        return logs.size();
    }

    @Override
    public Object getItem(int position) {
        return logs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LogListItem logListItem;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.log_list_item, null);
            logListItem = new LogListItem();
            logListItem.setImageView((ImageView) convertView.findViewById(R.id.logImageView));
            logListItem.setTextView((TextView) convertView.findViewById(R.id.logTextView));
            convertView.setTag(logListItem);
        } else {
            logListItem = (LogListItem) convertView.getTag();
        }

        Log log = this.logs.get(position);
        logListItem.getImageView().setImageDrawable(new BitmapDrawable(imageSaver.getImageWithFilename(log.getBook().getFilename(), context)));
        logListItem.getTextView().setText(log.getBook().getName());
        return convertView;
    }
    //endregion

    //region Getters and Setters
    public List<Log> getLogs() {
        return logs;
    }
    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }
    //endregion
}
