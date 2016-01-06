package goncalves.com.readinglist.Activities;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import goncalves.com.readinglist.Customizers.ActionBarCustomizer;
import goncalves.com.readinglist.R;


public class BookListActivity extends ActionBarActivity {

    //region UI Properties
    private ListView bookListView;
    private EditText bookAddEditTextView;
    //endregion

    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        this.bookListView = (ListView)findViewById(R.id.bookListView);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_book_list, menu);
        ActionBarCustomizer.customizeActionBar(getSupportActionBar());
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actions_add) {
            Intent addBookIntent = new Intent(this, BookAddActivity.class);
            startActivity(addBookIntent);
        }
        return super.onOptionsItemSelected(item);
    }
    //endregion

}
