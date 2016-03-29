package goncalves.com.readinglist.ViewAdapters.Concrete;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import goncalves.com.readinglist.Entities.Abstract.Log;
import goncalves.com.readinglist.ListItems.Log.LogListViewAdapter;

/**
 * Created by rafagonc on 3/26/16.
 */
public class LogListView extends ListView {

    //region Properties
    private LogListViewAdapter logListViewAdapter;
    private List<Log> logs;
    //endregion

    //region Constructor
    public LogListView(Context context) {
        super(context);
        onConstruct();
    }
    public LogListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        onConstruct();
    }
    public LogListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onConstruct();
    }
    private void onConstruct() {
        this.logs = new ArrayList<>();
        this.logListViewAdapter = new LogListViewAdapter(getContext());
    }
    //endregion

    //region Getters and Setters
    public LogListViewAdapter getLogListViewAdapter() {
        return logListViewAdapter;
    }
    public void setLogListViewAdapter(LogListViewAdapter logListViewAdapter) {
        this.logListViewAdapter = logListViewAdapter;
    }
    public List<Log> getLogs() {
        return logs;
    }
    public void setLogs(List<Log> logs) {
        this.logs = logs;
        this.logListViewAdapter.setLogs(logs);
        this.logListViewAdapter.notifyDataSetChanged();
    }
    //endregion
}
