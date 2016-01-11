package goncalves.com.readinglist.Entities.Abstract;
import java.util.List;

/**
 * Created by rafagonc on 1/5/16.
 */
public interface Category {

    //region Properties
    public String getName();
    public Long getId();
    //endregion

    //region Relationships
    public List<? extends Book> getBooks();
    //endregion

}
