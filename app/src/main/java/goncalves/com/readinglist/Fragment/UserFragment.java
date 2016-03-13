package goncalves.com.readinglist.Fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import goncalves.com.readinglist.R;
import roboguice.fragment.RoboFragment;

public class UserFragment extends RoboFragment {

    //region Lifecycle
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

}
