package goncalves.com.readinglist.ViewAdapters.Concrete;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import goncalves.com.readinglist.Entities.Abstract.Category;
import goncalves.com.readinglist.ListItems.Category.CategoryListViewAdapter;
import goncalves.com.readinglist.ViewAdapters.Delegates.CategoryListViewDelegate;

/**
 * Created by rafagonc on 1/9/16.
 */
public class CategoryListView extends ListView {

    //region Properties
    private CategoryListViewAdapter categoryListViewAdapter;
    private List<Category> categories;
    private CategoryListViewDelegate delegate;
    //endregion

    //region Constructors
    public CategoryListView(Context context) {
        super(context);
        onConstruct();
    }
    public CategoryListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        onConstruct();
    }
    public CategoryListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onConstruct();
    }
    public void onConstruct() {
        this.categories = new ArrayList<>();
        this.categoryListViewAdapter = new CategoryListViewAdapter(this.categories, getContext());
        setAdapter(categoryListViewAdapter);
        this.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getDelegate().wantsToChooseCategory(getCategories().get(position));
            }
        });
    }
    //endregion

    //region Getters and Setters
    public CategoryListViewAdapter getCategoryListViewAdapter() {
        return categoryListViewAdapter;
    }
    public void setCategoryListViewAdapter(CategoryListViewAdapter categoryListViewAdapter) {
        this.categoryListViewAdapter = categoryListViewAdapter;
    }
    public List<Category> getCategories() {
        return categories;
    }
    public void setCategories(List<Category> categories) {
        this.categories = categories;
        this.categoryListViewAdapter.setCategories(categories);
        this.categoryListViewAdapter.notifyDataSetChanged();
    }
    public CategoryListViewDelegate getDelegate() {
        return delegate;
    }
    public void setDelegate(CategoryListViewDelegate delegate) {
        this.delegate = delegate;
    }
    //endregion

}
