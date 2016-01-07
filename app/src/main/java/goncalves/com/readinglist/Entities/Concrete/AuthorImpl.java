package goncalves.com.readinglist.Entities.Concrete;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.io.Serializable;
import java.util.List;
import goncalves.com.readinglist.Entities.Abstract.Author;

/**
 * Created by rafagonc on 1/4/16.
 */

@Table
public class AuthorImpl extends SugarRecord implements Author, Serializable {

    //region Properies
    private Long id;
    private String name;
    //endregion

    //region Constructor
    public AuthorImpl() {
    }
    //endregion

    //region Getters And Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //endregion

    //region ORM
    @Override
    public void saveAuthor() {
        super.save();
    }
    //endregion

    //region Relationships
    public List<BookImpl> getBooks() {
        List<BookImpl> books = BookImpl.find(BookImpl.class, "author = ?", this.getId().toString());
        return books;
    }
    //endregion
}
