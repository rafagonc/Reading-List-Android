package goncalves.com.readinglist.Models.Abstract;

/**
 * Created by rafagonc on 1/5/16.
 */
public interface Book {

    //region Properties
    public String getName();
    public Author getAuthor();
    public Category getCategory();
    public Integer getPages();
    public Integer getPagesRead();
    //endregion

}
