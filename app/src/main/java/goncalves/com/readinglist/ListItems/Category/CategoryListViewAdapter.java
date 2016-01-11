package goncalves.com.readinglist.ListItems.Category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import goncalves.com.readinglist.Entities.Abstract.Category;
import goncalves.com.readinglist.R;

/**
 * Created by rafagonc on 1/9/16.
 */
public class CategoryListViewAdapter extends BaseAdapter {

    //region Properties
    private List<Category> categories;
    private LayoutInflater layoutInflater;
    //endregion

    //region Constructor
    public CategoryListViewAdapter(List<Category> categories, Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        this.categories = categories;
    }
    //endregion

    //region Base Adapter
    @Override
    public int getCount() {
        return this.categories.size();
    }

    @Override
    public Object getItem(int position) {
        return this.categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CategoryListItem categoryListItem;
        if (convertView == null) {
            convertView = this.layoutInflater.inflate(R.layout.category_list_item, null);
            categoryListItem = new CategoryListItem();
            categoryListItem.setCategoryNameTextView((TextView)convertView.findViewById(R.id.categoryNameTextView));
            convertView.setTag(categoryListItem);
        } else {
            categoryListItem = (CategoryListItem)convertView.getTag();
        }

        categoryListItem.getCategoryNameTextView().setText(categories.get(position).getName());

        return convertView;

    }
    //endregion

    //region Getters and Setters
    public List<Category> getCategories() {
        return categories;
    }
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    //endregion

}