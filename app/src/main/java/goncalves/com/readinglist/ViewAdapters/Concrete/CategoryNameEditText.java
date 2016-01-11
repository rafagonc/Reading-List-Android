package goncalves.com.readinglist.ViewAdapters.Concrete;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.Entities.Abstract.Category;
import goncalves.com.readinglist.Exceptions.InvalidCategoryException;
import goncalves.com.readinglist.Interfaces.BookAddChainOfResponsibility;
import goncalves.com.readinglist.ViewAdapters.Delegates.CategoryNameEditTextDelegate;

/**
 * Created by rafagonc on 1/6/16.
 */
public class CategoryNameEditText extends EditText implements BookAddChainOfResponsibility {

    private CategoryNameEditTextDelegate delegate;
    private Category category;

    //region Constructors
    public CategoryNameEditText(Context context) {
        super(context);
        setCallback();
    }

    public CategoryNameEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCallback();
    }

    public CategoryNameEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCallback();
    }
    //endregion

    //region Chain Of Responsibility
    @Override
    public void processBook(Book book) throws Exception {
        if (this.category == null) {
            throw new InvalidCategoryException();
        }
        book.setCategory(category);
    }
    //endregion

    //region Getters And Setters
    public void setCallback() {
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (delegate != null) {
                    delegate.categoryEditTextWantsToOpenCategoryActivity();
                }
            }
        });
    }
    public CategoryNameEditTextDelegate getDelegate() {
        return delegate;
    }

    public void setDelegate(CategoryNameEditTextDelegate delegate) {
        this.delegate = delegate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
        setText(category.getName());
    }
    //endregion

}
