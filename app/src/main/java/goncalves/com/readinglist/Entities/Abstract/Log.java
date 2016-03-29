package goncalves.com.readinglist.Entities.Abstract;

import java.util.Date;

/**
 * Created by rafagonc on 3/25/16.
 */
public interface Log {

    public Book getBook() throws IllegalStateException;
    public void setBookName(String bookName);
    public Integer getPages();
    public void setPages(Integer pages);
    public Date getDate();
    public void setDate(Date date);
    public Long getId();
    public void setId(Long id);

}
