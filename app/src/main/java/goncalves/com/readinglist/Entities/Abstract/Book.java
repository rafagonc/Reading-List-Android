package goncalves.com.readinglist.Entities.Abstract;

import android.graphics.drawable.Drawable;

/**
 * Created by rafagonc on 1/5/16.
 */
public interface Book {

    //region Getters and
    public Drawable getCoverImage();
    public void setCoverImage(Drawable drawable);
    public String getName();
    public Author getAuthor();
    public Category getCategory();
    public Integer getPages();
    public Integer getPagesRead();
    public void setName(String name);
    public void setAuthor(Author author);
    public void setCategory(Category category);
    public void setPages(Integer pages);
    public void setPagesRead(Integer pagesRead);
    //endregion

    //region ORM
    public void saveBook();
    //endregion
}
