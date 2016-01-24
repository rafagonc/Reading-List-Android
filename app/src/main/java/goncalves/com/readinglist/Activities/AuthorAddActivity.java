package goncalves.com.readinglist.Activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.inject.Inject;

import goncalves.com.readinglist.Customizers.ActionBarCustomizer;
import goncalves.com.readinglist.Entities.Abstract.Author;
import goncalves.com.readinglist.Factories.Entities.Abstract.AuthorFactory;
import goncalves.com.readinglist.GeneralClasses.NotificationPreseter.Abstract.NotificationPresenter;
import goncalves.com.readinglist.R;
import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.InjectView;

public class AuthorAddActivity extends RoboActionBarActivity {

    public static final Integer AUTHOR_ADD_RESULT = 195;

    //region UI Properties
    @InjectView(R.id.authorNameEditText) EditText authorEditText;
    @Inject AuthorFactory authorFactory;
    @Inject NotificationPresenter notificationPresenter;
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
            notificationPresenter.showError("You need to set the author's name", getApplicationContext(), this);
        } else {
            Author newAuthor = authorFactory.newAuthor(name);
            newAuthor.saveAuthor();
            setResult(AUTHOR_ADD_RESULT, getIntent());
            finish();
    }
    }
    //endregion

}
