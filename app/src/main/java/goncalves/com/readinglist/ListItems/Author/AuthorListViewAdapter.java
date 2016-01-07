package goncalves.com.readinglist.ListItems.Author;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import goncalves.com.readinglist.Entities.Abstract.Author;
import goncalves.com.readinglist.R;

/**
 * Created by rafagonc on 1/7/16.
 */
public class AuthorListViewAdapter extends BaseAdapter {


    //region Properties
    private List<Author> authors;
    private LayoutInflater layoutInflater;
    //endregion

    //region Constructor
    public AuthorListViewAdapter(List<Author> authors, Context context) {
        this.authors = authors;
        this.layoutInflater = LayoutInflater.from(context);
    }
    //endregion

    //region Base Adapter Methods
    @Override
    public int getCount() {
        return this.authors.size();
    }

    @Override
    public Object getItem(int position) {
        return this.authors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       AuthorListItem authorListItem;
       if (convertView == null) {
           convertView = this.layoutInflater.inflate(R.layout.author_list_item, null);
           authorListItem = new AuthorListItem();
           authorListItem.setAuthorNameTextView((TextView)convertView.findViewById(R.id.authorNameTextView));
           convertView.setTag(authorListItem);
       } else {
           authorListItem = (AuthorListItem)convertView.getTag();
       }

       authorListItem.getAuthorNameTextView().setText(authors.get(position).getName());

       return convertView;
    }
    //endregion

    //region Getters And Setters
    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
    //endregion
}
