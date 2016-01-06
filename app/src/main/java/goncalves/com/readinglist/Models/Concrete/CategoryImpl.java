package goncalves.com.readinglist.Models.Concrete;

import com.orm.SugarRecord;
import com.orm.dsl.Table;
import java.util.List;
import goncalves.com.readinglist.Models.Abstract.Book;
import goncalves.com.readinglist.Models.Abstract.Category;

/**
 * Created by rafagonc on 1/4/16.
 */

@Table
public class CategoryImpl extends SugarRecord implements Category {

    //region Properties
    private String name;
    //endregion

    //region Getters And Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //endregion

    //region Relationships
    public List<BookImpl> getBooks() {
        return BookImpl.find(BookImpl.class, "category = ?", this.getId().toString());
    }
    //endregion

}
