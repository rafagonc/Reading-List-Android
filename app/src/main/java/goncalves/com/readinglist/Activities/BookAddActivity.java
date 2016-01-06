package goncalves.com.readinglist.Activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import goncalves.com.readinglist.Customizers.ActionBarCustomizer;
import goncalves.com.readinglist.R;

public class BookAddActivity extends ActionBarActivity {

    //region Lifestyle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_add);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_book_add, menu);
        ActionBarCustomizer.customizeActionBar(getSupportActionBar());
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
    //endregion

}
