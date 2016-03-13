package goncalves.com.readinglist.Factories.Fragment.Concrete;

import java.util.ArrayList;
import java.util.List;

import goncalves.com.readinglist.Fragment.BookListFragment;
import goncalves.com.readinglist.Factories.Fragment.Abstract.MainPagerFragmentFactory;
import goncalves.com.readinglist.Fragment.RecommendedBooksFragment;
import goncalves.com.readinglist.Fragment.UserFragment;
import roboguice.fragment.RoboFragment;

/**
 * Created by rafagonc on 3/12/16.
 */
public class MainPagerFragmentFactoryImpl implements MainPagerFragmentFactory {

    @Override
    public List<? extends android.support.v4.app.Fragment> fragmentsForMainActivityPager() {
        List fragments = new ArrayList<RoboFragment>();
        fragments.add(new BookListFragment());
        fragments.add(new RecommendedBooksFragment());
        fragments.add(new UserFragment());
        return fragments;
    }
}
