package goncalves.com.readinglist.Entities.Abstract;

/**
 * Created by rafagonc on 1/5/16.
 */
public interface Book extends TransientBook {

    //region Getters and
    public Long getId();
    public String getFilename();
    public Category getCategory();
    public Integer getPages();
    public Integer getPagesRead();
    public Author getAuthor();
    public void setAuthor(Author author);
    public void setCategory(Category category);
    public void setPages(Integer pages);
    public void setPagesRead(Integer pagesRead);
    public void setFilename(String filename);
    public String getPercentage();

    //endregion

    //region Helpers
    public Boolean hasPages();
    //endregion

    //region ORM
    public void saveBook();
    //endregion
}
