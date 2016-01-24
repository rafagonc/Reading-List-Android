package goncalves.com.readinglist.ListItems.Book;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.inject.Inject;

import java.util.List;

import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.GeneralClasses.ImageSaver.Abstract.ImageSaver;
import goncalves.com.readinglist.R;
import roboguice.RoboGuice;

/**
 * Created by rafagonc on 1/6/16.
 */
public class BookListViewAdapter extends BaseAdapter {

    //region Properties
    private LayoutInflater layoutInflater;
    private List<Book> itens;
    private Context context;
    @Inject ImageSaver imageSaver;
    //endregion

    //region Constructor
    public BookListViewAdapter(List<Book> itens, Context context) {
        this.itens = itens;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        RoboGuice.getInjector(context).injectMembers(this);
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
        bookListItem.getProgressTextView().setText(book.getPercentage() + " completed");
        bookListItem.getCoverImageView().setImageDrawable(new BitmapDrawable(imageSaver.getImageWithFilename(book.getFilename(), context)));

        return convertView;
    }
    //endregion
}
