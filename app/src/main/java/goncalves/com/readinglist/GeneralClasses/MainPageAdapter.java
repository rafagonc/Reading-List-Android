package goncalves.com.readinglist.GeneralClasses;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by rafagonc on 3/12/16.
 */
public class MainPageAdapter extends FragmentStatePagerAdapter {

    //region Properties
    private List<? extends Fragment> fragments;
    //endregion

    //region Constructor
    public MainPageAdapter(FragmentManager manager) {
        super(manager);
    }
    //endregion

    //region Adapter
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }
    @Override
    public int getCount() {
        return fragments.size();
    }
    //endregion

    //region Setters
    public void setFragments(List<? extends Fragment> fragments) {
        this.fragments = fragments;
        notifyDataSetChanged();
    }
    //endregion

}
