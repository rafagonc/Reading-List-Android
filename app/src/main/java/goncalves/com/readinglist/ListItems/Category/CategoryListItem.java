package goncalves.com.readinglist.ListItems.Category;

import android.widget.TextView;

/**
 * Created by rafagonc on 1/9/16.
 */
public class CategoryListItem {

    //region UI Properties
    private TextView categoryNameTextView;
    //endregion

    //region Getters And Setters
    public TextView getCategoryNameTextView() {
        return categoryNameTextView;
    }

    public void setCategoryNameTextView(TextView categoryNameTextView) {
        this.categoryNameTextView = categoryNameTextView;
    }
    //endregion

}

