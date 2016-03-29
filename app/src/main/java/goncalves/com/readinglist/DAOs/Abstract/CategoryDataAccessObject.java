package goncalves.com.readinglist.DAOs.Abstract;

import goncalves.com.readinglist.Entities.Abstract.Category;

/**
 * Created by rafagonc on 1/5/16.
 */
public interface CategoryDataAccessObject extends DataAccessObject {

    public Boolean hasCreatedCategories();
    public Category mostUsedCatgory();

}
