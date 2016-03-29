package goncalves.com.readinglist.Entities.Concrete;

import com.google.inject.Inject;
import com.orm.SugarRecord;

import java.util.Date;

import goncalves.com.readinglist.DAOs.Abstract.BookDataAccessObject;
import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.Entities.Abstract.Log;

/**
 * Created by rafagonc on 3/25/16.
 */
public class LogImpl extends SugarRecord implements Log {

    @Inject BookDataAccessObject bookDataAccessObject;

    //region Properties
    private String bookName;
    private Long id;
    private Integer pages;
    private Date date;
    //endregion

    //region Constructor
    public LogImpl() {
        
    }
    //endregion

    //region Getters And Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public Integer getPages() {
        return pages;
    }
    public void setPages(Integer pages) {
        this.pages = pages;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public Book getBook() throws IllegalStateException {
        return bookDataAccessObject.findByName(this.bookName);
    }
    //endregion

}
