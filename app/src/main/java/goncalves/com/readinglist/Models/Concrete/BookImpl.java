package goncalves.com.readinglist.Models.Concrete;

import com.orm.SugarRecord;
import com.orm.dsl.Table;
import goncalves.com.readinglist.Models.Abstract.Book;

/**
 * Created by rafagonc on 1/4/16.
 */

@Table
public class BookImpl extends SugarRecord implements Book {

    //region Properties
    private Long id;
    private String name;
    private Integer pages;
    private Integer pagesRead;
    private AuthorImpl author;
    private CategoryImpl category;
    //endregion

    //region Constructors
    public BookImpl() {

    }
    public BookImpl(String name) {
        this.name = name;
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
    public void setAuthor(AuthorImpl author) {
        this.author = author;
    }
    public CategoryImpl getCategory() {
        return category;
    }
    public void setCategory(CategoryImpl category) {
        this.category = category;
    }
    //endregion

    //region Methods
    public void saveBook() {
        if (this.author != null) this.author.save();
        this.save();
        super.save();
    }
    //endregion
}
