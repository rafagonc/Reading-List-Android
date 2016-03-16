package goncalves.com.readinglist.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import goncalves.com.readinglist.Activities.BookAddActivity;
import goncalves.com.readinglist.DAOs.Abstract.BookDataAccessObject;
import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.R;
import goncalves.com.readinglist.ViewAdapters.Concrete.BookListView;
import goncalves.com.readinglist.ViewAdapters.Delegates.BookListViewDelegate;
import roboguice.RoboGuice;
import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;


public class BookListFragment extends RoboFragment implements BookListViewDelegate {

    //region UI Properties
    @InjectView(R.id.bookListView) BookListView bookListView;
    //endregion

    //region Properties
    @Inject BookDataAccessObject bookDataAccessObject;;
    //endregion

    //region Lifecycle
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        RoboGuice.getInjector(getActivity().getApplicationContext()).injectMembers(this);
    }
    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_book_list, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.bookListView.setBooks(bookDataAccessObject.findAll());
        bookListView.setDelegate(this);
    }
    //endregion

    //region Delegates
    @Override
    public void wantsToOpenBookDetail(Book book) {
        Intent bookAddIntent = new Intent(getActivity(), BookAddActivity.class);
        Log.i("ID", book.getId().toString());
        bookAddIntent.putExtra(BookAddActivity.BOOK_DATA_EDIT_ID, book.getId());
        startActivityForResult(bookAddIntent, BookAddActivity.BOOK_RESULT);
    }
    //endregion

}
