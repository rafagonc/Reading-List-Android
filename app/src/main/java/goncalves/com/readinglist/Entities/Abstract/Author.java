package goncalves.com.readinglist.Entities.Abstract;
import java.util.List;

/**
 * Created by rafagonc on 1/5/16.
 */
public interface Author {

    //region Properties
    public String getName();
    public void setName(String name);
    public Long getId();
    //endregion

    //region ORM
    public void saveAuthor();
    //endregion

    //region Relationships
    public List<? extends Book> getBooks();
    //endregion

}
