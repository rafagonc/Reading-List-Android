package goncalves.com.readinglist.Activities;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.inject.Inject;

import java.util.List;

import goncalves.com.readinglist.Customizers.ActionBarCustomizer;
import goncalves.com.readinglist.DAOs.Abstract.CategoryDataAccessObject;
import goncalves.com.readinglist.Entities.Abstract.Category;
import goncalves.com.readinglist.R;
import goncalves.com.readinglist.ViewAdapters.Concrete.CategoryListView;
import goncalves.com.readinglist.ViewAdapters.Delegates.CategoryListViewDelegate;
import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.InjectView;

public class CategoryChooseActivity extends RoboActionBarActivity implements CategoryListViewDelegate {

    public static final String CATEGORY_DATA_ID = "CATEGORY_DATA_ID";
    public static final Integer CATEGORY_RESULT = 5;

    //region UI Properties
    @InjectView (R.id.categoryListView) CategoryListView categoryListView;
    //endregion

    //region Properties
    @Inject CategoryDataAccessObject categoryDataAccessObject;
    //endregion

    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_choose);
        setTitle("Choose Category");
        Log.i("dasdas", categoryDataAccessObject.findAll().toString());
        categoryListView.setCategories((List<Category>) categoryDataAccessObject.findAll());
        categoryListView.setDelegate(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_category_choose, menu);
        ActionBarCustomizer.customizeActionBar(getSupportActionBar());
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
    //endregion

    //region Delegate
    @Override
    public void wantsToChooseCategory(Category category) {
        getIntent().putExtra(CATEGORY_DATA_ID, category.getId());
        setResult(CATEGORY_RESULT, getIntent());
        finish();
    }
    //endregion
}
