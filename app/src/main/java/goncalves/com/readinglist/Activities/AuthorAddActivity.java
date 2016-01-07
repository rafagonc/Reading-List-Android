package goncalves.com.readinglist.Activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import javax.inject.Inject;

import goncalves.com.readinglist.Customizers.ActionBarCustomizer;
import goncalves.com.readinglist.Entities.Abstract.Author;
import goncalves.com.readinglist.Factories.Abstract.AuthorFactory;
import goncalves.com.readinglist.GeneralClasses.NotificationShower;
import goncalves.com.readinglist.R;
import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.InjectView;

public class AuthorAddActivity extends RoboActionBarActivity {

    //region UI Properties
    @InjectView(R.id.authorNameEditText) EditText authorEditText;
    @Inject AuthorFactory authorFactory;
    //endregion

    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_add);
        setTitle("Add Author");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_author_add, menu);
        ActionBarCustomizer.customizeActionBar(getSupportActionBar());
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
    //endregion

    //region Actions
    public void onSaveClick(View view) {
        String name = authorEditText.getText().toString();
        if (name.length() == 0 ) {
            NotificationShower.showError("You need to set the author's name", getApplicationContext(), this);
        } else {
            Author newAuthor = authorFactory.newAuthor(name);
            newAuthor.saveAuthor();
            setResult(RESULT_OK, getIntent());
            finish();
    }
    }
    //endregion

}
