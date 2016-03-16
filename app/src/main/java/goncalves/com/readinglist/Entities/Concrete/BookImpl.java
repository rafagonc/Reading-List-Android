package goncalves.com.readinglist.Entities.Concrete;

import android.app.Activity;
import android.graphics.Bitmap;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import goncalves.com.readinglist.Entities.Abstract.Author;
import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.Entities.Abstract.Category;

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
    private String filename;
    private String snippet;
    private String imageURL;
    private String authorString;
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
    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPercentage() {
        if (getPagesRead() != null && getPages() != null ){
            double percentage = ((double)getPagesRead()/(double)getPages()) * 100;
            return String.format("%.2f", percentage) + "%";
        } else {
            return "0.0%";
        }
    }
    public String getSnippet() {
        return snippet;
    }
    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    public String getAuthorString() {
        return this.author.getName();
    }
    public void setAuthorString(String authorString) {
    }
    public void setBitmap(Bitmap bitmap) {

    }
    public Bitmap getBitmap() {
        return null;
    }

    @Override
    public String createFilenameForSavedCoverImage (Activity activity) throws IllegalStateException {
        return null;
    }
    //endregion

    //region Helpers
    public Boolean hasPages() {
        return getPages() != null;
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
