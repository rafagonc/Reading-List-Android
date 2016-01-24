package goncalves.com.readinglist.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.inject.Inject;

import java.util.List;

import goncalves.com.readinglist.Customizers.ActionBarCustomizer;
import goncalves.com.readinglist.DAOs.Abstract.AuthorDataAccessObject;
import goncalves.com.readinglist.Entities.Abstract.Author;
import goncalves.com.readinglist.R;
import goncalves.com.readinglist.ViewAdapters.Concrete.AuthorListView;
import goncalves.com.readinglist.ViewAdapters.Delegates.AuthorListViewDelegate;
import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.InjectView;

public class AuthorChooseActivity extends RoboActionBarActivity implements AuthorListViewDelegate {

    //region Constants
    public static final String AUTHOR_DATA_ID = "AUTHOR_DATA_ID";
    public static final Integer AUTHOR_RESULT = 1;
    //endregion

    //region UI Properties
    @InjectView(R.id.authorListView) AuthorListView authorListView;
    @Inject AuthorDataAccessObject authorDataAccessObject;
    //endregion

    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_choose);
        setTitle("Choose Author");
        authorListView.setAuthors((List<Author>)authorDataAccessObject.findAll());
        authorListView.setDelegate(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_author_choose, menu);
        ActionBarCustomizer.customizeActionBar(getSupportActionBar());
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.actions_add) {
            wantsToCreateNewAuthor();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        authorListView.setAuthors((List<Author>)authorDataAccessObject.findAll());

    }
    //endregion

    //region Methods
    public void wantsToCreateNewAuthor() {
        Intent addAuthorIntent = new Intent(this, AuthorAddActivity.class);
        startActivityForResult(addAuthorIntent, AuthorAddActivity.AUTHOR_ADD_RESULT);
    }
    //endregion

    //region Delegates
    @Override
    public void wantsToSelectAuthor(Author author) {
        getIntent().putExtra(AUTHOR_DATA_ID, author.getId());
        setResult(AUTHOR_RESULT, getIntent());
        finish();

    }
    //endregion

}
