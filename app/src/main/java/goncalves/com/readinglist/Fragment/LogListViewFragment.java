package goncalves.com.readinglist.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.inject.Inject;

import java.util.List;

import goncalves.com.readinglist.DAOs.Abstract.LogDataAccessObject;
import goncalves.com.readinglist.Entities.Abstract.Log;
import goncalves.com.readinglist.R;
import goncalves.com.readinglist.ViewAdapters.Concrete.LogListView;
import roboguice.RoboGuice;
import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

public class LogListViewFragment extends RoboFragment {

    //region UI
    @InjectView(R.id.logListView) LogListView logListView;
    //endregion

    //region Properties
    @Inject LogDataAccessObject logDataAccessObject;
    //endregion

    //region Lifecycle
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        RoboGuice.getInjector(getActivity().getApplicationContext()).injectMembers(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        logListView.setLogs((List<Log>)logDataAccessObject.findAll());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_log_list_view, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    //endregion

}