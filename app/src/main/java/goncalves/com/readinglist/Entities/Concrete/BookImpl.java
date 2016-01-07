package goncalves.com.readinglist.Entities.Concrete;

import android.graphics.drawable.Drawable;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.io.Serializable;

import goncalves.com.readinglist.Entities.Abstract.Author;
import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.Entities.Abstract.Category;

/**
 * Created by rafagonc on 1/4/16.
 */

@Table
public class BookImpl extends SugarRecord implements Book, Serializable {

    //region Properties
    private Long id;
    private String name;
    private Integer pages;
    private Integer pagesRead;
    private AuthorImpl author;
    private CategoryImpl category;
    private Drawable drawable;
    //endregion

    //region Constructors
    public BookImpl() {

    }
    //endregion

    //region Getters And Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPages() {
        return pages;
    }
    public void setPages(Integer pages) {
        this.pages = pages;
    }
    public Integer getPagesRead() {
        return pagesRead;
    }
    public void setPagesRead(Integer pagesRead) {
        this.pagesRead = pagesRead;
    }
    public AuthorImpl getAuthor() {
        return author;
    }
    public CategoryImpl getCategory() {
        return category;
    }
    public void setAuthor(Author author) {
        this.author = (AuthorImpl)author;
    }
    public void setCategory(Category category) {
        this.category = (CategoryImpl)category;
    }
    public Drawable getCoverImage() {
        return drawable;
    }
    public void setCoverImage(Drawable drawable) {
        this.drawable = drawable;
    }
    //endregion

    //region Methods
       public void saveBook() {
        if (this.author != null) this.author.save();
        if (this.category != null) this.category.save();
        this.save();
        super.save();
    }
    //endregion
}
