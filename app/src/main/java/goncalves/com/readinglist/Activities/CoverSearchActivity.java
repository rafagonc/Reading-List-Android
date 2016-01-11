package goncalves.com.readinglist.Activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import goncalves.com.readinglist.Customizers.ActionBarCustomizer;
import goncalves.com.readinglist.R;
import roboguice.activity.RoboActionBarActivity;

public class CoverSearchActivity extends RoboActionBarActivity {



    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover_search);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cover_search, menu);
        ActionBarCustomizer.customizeActionBar(getSupportActionBar());
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
    //endregion
}
