package goncalves.com.readinglist.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.inject.Inject;

import java.util.List;

import goncalves.com.readinglist.Activities.BookAddActivity;
import goncalves.com.readinglist.Entities.Abstract.TransientBook;
import goncalves.com.readinglist.GeneralClasses.NotificationPreseter.Abstract.NotificationPresenter;
import goncalves.com.readinglist.R;
import goncalves.com.readinglist.Server.Proxy.Abstract.ServiceProxy;
import goncalves.com.readinglist.Server.Requests.Concrete.SearchBooksRequest;
import goncalves.com.readinglist.Server.Response.ServiceResponse;
import goncalves.com.readinglist.ViewAdapters.Concrete.TransientBookListView;
import goncalves.com.readinglist.ViewAdapters.Delegates.TransientBookListViewDelegate;
import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

public class RecommendedBooksFragment extends RoboFragment implements TransientBookListViewDelegate {

    //region UI
    @InjectView(R.id.searchTextField) EditText searchEditText;
    @InjectView(R.id.searchBookListView) TransientBookListView searchBookListView;
    //endregion

    //region Properties
    @Inject ServiceProxy serviceProxy;
    @Inject NotificationPresenter notificationPresenter;
    //endregion

    //region Lifecycle
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SearchBooksRequest request = new SearchBooksRequest();
        request.setQuery("cleancode");
        serviceProxy.callServiceWithRequest(request, new ServiceResponse() {
            public void onSuccess(Object data) {
                List<TransientBook> transientBookList = (List<TransientBook>)data;
                searchBookListView.setBooks(transientBookList);
            }
            public void onFailure(String errorMessage) {
                notificationPresenter.showError(errorMessage, getActivity().getApplicationContext(), getActivity());
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recommended_books, container, false);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onResume() {
        super.onResume();
        searchBookListView.setDelegate(this);
    }

//endregion

    //region Delegates

    @Override
    public void transientListViewWantsToAddTransientBook(TransientBook transientBook) {
        Intent intent = new Intent(getActivity(), BookAddActivity.class);
        intent.putExtra(BookAddActivity.TRANSIENT_BOOK_ADD_ID, transientBook);
        getActivity().startActivity(intent);
    }
    //endregion

}
