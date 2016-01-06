package goncalves.com.readinglist.Models.Concrete;

import com.orm.SugarRecord;
import com.orm.dsl.Table;
import java.util.List;
import goncalves.com.readinglist.Models.Abstract.Author;
import goncalves.com.readinglist.Models.Abstract.Book;

/**
 * Created by rafagonc on 1/4/16.
 */

@Table
public class AuthorImpl extends SugarRecord implements Author {

    //region Properies
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
        List<BookImpl> books = BookImpl.find(BookImpl.class, "author = ?", this.getId().toString());
        return books;
    }
    //endregion
}
