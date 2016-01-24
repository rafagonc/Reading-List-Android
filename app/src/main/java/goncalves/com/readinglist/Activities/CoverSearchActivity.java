package goncalves.com.readinglist.Activities;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.inject.Inject;

import java.util.List;

import goncalves.com.readinglist.Customizers.ActionBarCustomizer;
import goncalves.com.readinglist.Entities.Abstract.GoogleCoverObject;
import goncalves.com.readinglist.GeneralClasses.ImageSaver.Abstract.ImageSaver;
import goncalves.com.readinglist.GeneralClasses.NotificationPreseter.Abstract.NotificationPresenter;
import goncalves.com.readinglist.GeneralClasses.ProgressPresenter.Abstract.ProgressPresenter;
import goncalves.com.readinglist.R;
import goncalves.com.readinglist.Server.Proxy.Abstract.ServiceProxy;
import goncalves.com.readinglist.Server.Requests.Concrete.CoverImageRequest;
import goncalves.com.readinglist.Server.Response.ServiceResponse;
import goncalves.com.readinglist.ViewAdapters.Concrete.CoverGridView;
import goncalves.com.readinglist.ViewAdapters.Delegates.CoverGridViewDelegate;
import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.InjectView;

public class CoverSearchActivity extends RoboActionBarActivity implements CoverGridViewDelegate {

    //region Constants
    public static final String COVER_QUERY_STRING = "COVER_QUERY_STRING";
    public static final Integer COVER_RESULT = 1233;
    public static final String  COVER_FILENAME_DATA_ID = "COVER_FILENAME_DATA_ID";
    //endregion

    //region UI
    @InjectView(R.id.coverGridView) CoverGridView gridView;
    //endregion

    //region Properties
    private String query;
    @Inject ServiceProxy serviceProxy;
    @Inject NotificationPresenter notificationPresenter;
    @Inject ProgressPresenter progressPresenter;
    @Inject ImageSaver imageSaver;
    //endregion

    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover_search);
        setQuery(getIntent().getExtras().getString(COVER_QUERY_STRING));
        gridView.setDelegate(this);
        setTitle("Cover Search");
        callCoverSearchRequest();
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
    //endregion`

    private void callCoverSearchRequest() {
        final Activity activity = this;
        progressPresenter.showProgress("Fetching Images", this);
        CoverImageRequest request = new CoverImageRequest(this.query);
        serviceProxy.callServiceWithRequest(request, new ServiceResponse() {
            @Override
            public void onSuccess(Object data) {
                gridView.setItems((List<GoogleCoverObject>)data);
                progressPresenter.stop();
            }

            @Override
            public void onFailure(String errorMessage) {
                notificationPresenter.showError(errorMessage, getApplicationContext(), activity);
                progressPresenter.stop();
            }
        });
    }

    //region Delegate
    @Override
    public void coverGridViewSelectedImage(Bitmap bitmap) {
        getIntent().putExtra(COVER_FILENAME_DATA_ID, imageSaver.fileNameForSavedDrawable(bitmap, this));
        setResult(COVER_RESULT, getIntent());
        finish();
    }
    //endregion

    //region Getters and Setters
    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query + " cover";
    }
    //endregion

}
