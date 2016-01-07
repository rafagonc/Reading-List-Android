package goncalves.com.readinglist.ListItems.Book;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.R;

/**
 * Created by rafagonc on 1/6/16.
 */
public class BookListViewAdapter extends BaseAdapter {

    //region Properties
    private LayoutInflater layoutInflater;
    private List<Book> itens;
    //endregion

    //region Constructor
    public BookListViewAdapter(List<Book> itens, Context context) {
        this.itens = itens;
        layoutInflater = LayoutInflater.from(context);
    }
    //endregion


    //region Getters And Setters
    public List<Book> getItens() {
        return itens;
    }

    public void setItens(List<Book> itens) {
        this.itens = itens;
    }
    //endregion

    //region Base Adapter
    @Override
    public int getCount() {
        return this.itens.size();
    }
    @Override
    public Object getItem(int position) {
        return this.itens.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BookListItem bookListItem;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.book_list_item, null);
            bookListItem = new BookListItem();
            bookListItem.setCoverImageView((ImageView) convertView.findViewById(R.id.bookCoverImageView));
            bookListItem.setBookTextView((TextView) convertView.findViewById(R.id.bookNameListItemTextView));
            bookListItem.setProgressTextView((TextView) convertView.findViewById(R.id.bookProgressListItemTextView));
            convertView.setTag(bookListItem);
        } else {
            bookListItem = (BookListItem) convertView.getTag();
        }

        Book book = this.itens.get(position);
        bookListItem.getBookTextView().setText(book.getName());
        //bookListItem.getCoverImageView().setImageDrawable((book.getCoverImage()));

        return convertView;
    }
    //endregion
}
