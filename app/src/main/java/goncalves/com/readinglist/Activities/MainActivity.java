package goncalves.com.readinglist.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.google.inject.Inject;

import goncalves.com.readinglist.Customizers.ActionBarCustomizer;
import goncalves.com.readinglist.Customizers.TabWidgetCustomizer;
import goncalves.com.readinglist.Factories.Fragment.Abstract.MainPagerFragmentFactory;
import goncalves.com.readinglist.GeneralClasses.MainPageAdapter;
import goncalves.com.readinglist.R;
import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.InjectView;

public class MainActivity extends RoboActionBarActivity implements android.support.v7.app.ActionBar.TabListener {

    //region Properties
    @Inject MainPagerFragmentFactory fragmentFactory;
    //endregion

    //region UI
    @InjectView(R.id.tabHost) TabHost tabHost;
    @InjectView(R.id.tabWidget) TabWidget tab;
    @InjectView(R.id.pager) private ViewPager viewPager;
    //endregion

    //region Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            MainPageAdapter adapter = new MainPageAdapter(getSupportFragmentManager());
            adapter.setFragments(fragmentFactory.fragmentsForMainActivityPager());
            viewPager.setAdapter(adapter);
            TabWidgetCustomizer.customizeTab(this.tab);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_book_list, menu);
        ActionBarCustomizer.customizeActionBar(getSupportActionBar());
        handleTabSelection(getSupportActionBar());
        return true;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //this.bookListView.setBooks(bookDataAccessObject.findAll());
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actions_add) {
            Intent addBookIntent = new Intent(this, BookAddActivity.class);
            startActivityForResult(addBookIntent, BookAddActivity.BOOK_RESULT);
        }
        return super.onOptionsItemSelected(item);
    }
    //endregion

    //region Tab
    @Override
    public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition(), true);
    }
    @Override
    public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction ft) {

    }
    @Override
    public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction ft) {

    }
    //endregion

    //region Methods
    private void handleTabSelection(android.support.v7.app.ActionBar actionBar) {
        actionBar.setNavigationMode(android.support.v7.app.ActionBar.NAVIGATION_MODE_TABS);
        for (int i = 0; i < 3; i++) {
            android.support.v7.app.ActionBar.Tab tab = actionBar.newTab().setText("Tab " + (i + 1));
            tab.setTabListener(this);
            actionBar.addTab(tab);
        }
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                getSupportActionBar().setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    //endregion

}
