package goncalves.com.readinglist.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import goncalves.com.readinglist.R;
import roboguice.fragment.RoboFragment;

public class UserFragment extends RoboFragment {

    //region UI
    private UserInfoFragment userInfoFragment;
    private LogListViewFragment logListViewFragment;
    //endregion

    //region Lifecycle
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.userInfoFragment = new UserInfoFragment();
        this.logListViewFragment = new LogListViewFragment();
        attachFragmentToLayout(this.userInfoFragment, R.id.userInfoFragmentContainer);
        attachFragmentToLayout(this.logListViewFragment, R.id.logListFragmentContainer);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user, container, false);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
    //endregion

    //region Methods
    private void attachFragmentToLayout(Fragment fragment, Integer id) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(id, fragment);
        ft.commit();
    }
    //endregion

}
