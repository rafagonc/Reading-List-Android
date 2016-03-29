package goncalves.com.readinglist.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.google.inject.Inject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import goncalves.com.readinglist.DAOs.Abstract.BookDataAccessObject;
import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.Entities.Abstract.Log;
import goncalves.com.readinglist.Factories.Entities.Abstract.LogFactory;
import goncalves.com.readinglist.GeneralClasses.NotificationPreseter.Abstract.NotificationPresenter;
import goncalves.com.readinglist.Interfaces.LogAddChainOfResponsibility;
import goncalves.com.readinglist.R;
import goncalves.com.readinglist.ViewAdapters.Concrete.CoverButton;
import goncalves.com.readinglist.ViewAdapters.Concrete.DateEditText;
import goncalves.com.readinglist.ViewAdapters.Concrete.PagesEditText;
import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.InjectView;

public class LogAddActivity extends RoboActionBarActivity implements View.OnClickListener {

    //region Constants
    public static final Integer LOG_RESULT = 2137;
    public static final String LOG_CHOOSE_ID = "LOG_CHOOSE_ID";
    private Book choseBook;
    //endregion

    //region Properties
    @Inject BookDataAccessObject bookDataAccessObject;
    @Inject LogFactory logFactory;
    @Inject NotificationPresenter notificationPresenter;
    //endregion

    //region UI
    @InjectView(R.id.coverImageView) CoverButton coverButton;
    @InjectView(R.id.dateEditText) DateEditText dateEditText;
    @InjectView(R.id.pagesEditText) PagesEditText pagesEditText;
    @InjectView(R.id.bookEditText) EditText bookEditText;
    //endregion

    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_add);
        dateEditText.setActivityWeakReference(new WeakReference<Activity>(this));
        bookEditText.setOnClickListener(this);
        coverButton.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_log_add, menu);
        return true;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        choseBook = (Book)bookDataAccessObject.findById(data.getExtras().getLong(BookChooseActivity.BOOK_CHOOSE_ID));
        coverButton.setFilename(choseBook.getFilename());
        bookEditText.setText(choseBook.getName());
    }
    //endregion

    //region
    public void onSaveClick(View view)  {
        if (this.choseBook == null) {
            notificationPresenter.showError("You need to choose a book!", getApplicationContext(), this);
            return;
        }
        List<LogAddChainOfResponsibility> logAddChainOfResponsibilityList = new ArrayList<>();
        logAddChainOfResponsibilityList.add(this.pagesEditText);
        logAddChainOfResponsibilityList.add(this.dateEditText);
        Log log = logFactory.log(this.choseBook);
        try {
            for (LogAddChainOfResponsibility chain : logAddChainOfResponsibilityList) {
                chain.processLog(log);
            }
            getIntent().putExtra(LOG_CHOOSE_ID ,log.getId());
            setResult(LOG_RESULT, getIntent());
            finish();
        } catch (Exception e) {
            notificationPresenter.showError(e.getMessage(), getApplicationContext(), this);
        }
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, BookChooseActivity.class);
        startActivityForResult(intent, BookChooseActivity.BOOK_CHOOSE_RESULT);
    }
    //endregion
}
