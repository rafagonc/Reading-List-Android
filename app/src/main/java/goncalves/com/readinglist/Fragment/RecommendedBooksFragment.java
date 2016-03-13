package goncalves.com.readinglist.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import goncalves.com.readinglist.R;
import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

public class RecommendedBooksFragment extends RoboFragment {

    //region UI
    @InjectView(R.id.searchTextField) EditText searchEditText;
    @InjectView(R.id.searchBookListView) ListView searchBookListView;
    //endregion

    //region Lifecycle
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recommended_books, container, false);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
    //endregion

}
