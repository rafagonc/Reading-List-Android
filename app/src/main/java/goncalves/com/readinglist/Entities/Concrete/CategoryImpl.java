package goncalves.com.readinglist.Entities.Concrete;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.io.Serializable;
import java.util.List;

import goncalves.com.readinglist.Entities.Abstract.Category;

/**
 * Created by rafagonc on 1/4/16.
 */

@Table
public class CategoryImpl extends SugarRecord implements Category, Serializable {

    //region Properties
    private Long id;
    private String name;
    //endregion

    //region Constructor
    public CategoryImpl() {
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

    //region Relationships
    public List<BookImpl> getBooks() {
        return BookImpl.find(BookImpl.class, "category = ?", this.getId().toString());
    }
    //endregion

}
