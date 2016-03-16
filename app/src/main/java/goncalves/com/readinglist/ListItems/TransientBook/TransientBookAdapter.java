package goncalves.com.readinglist.ListItems.TransientBook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import goncalves.com.readinglist.Entities.Abstract.TransientBook;
import goncalves.com.readinglist.R;

/**
 * Created by rafagonc on 3/12/16.
 */
public class TransientBookAdapter extends BaseAdapter {

    private List<TransientBook> transientBooks;
    private LayoutInflater layoutInflater;
    private Context context;

    public TransientBookAdapter( Context context) {
        this.context = context;
        transientBooks = new ArrayList<>();
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return transientBooks.size();
    }

    @Override
    public Object getItem(int position) {
        return transientBooks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TransientBookItem item;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.book_list_item, null);
            item = new TransientBookItem();
            item.setImageView((ImageView) convertView.findViewById(R.id.bookCoverImageView));
            item.setBookNameTextView((TextView) convertView.findViewById(R.id.bookNameListItemTextView));
            convertView.setTag(item);
        } else {
            item = (TransientBookItem) convertView.getTag();
        }

        item.setBook(transientBooks.get(position), context);
        return convertView;
    }

    public List<TransientBook> getTransientBooks() {
        return transientBooks;
    }

    public void setTransientBooks(List<TransientBook> transientBooks) {
        this.transientBooks = transientBooks;
    }
}
