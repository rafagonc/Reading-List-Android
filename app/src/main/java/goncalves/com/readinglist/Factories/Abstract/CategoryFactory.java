package goncalves.com.readinglist.Factories.Abstract;

import goncalves.com.readinglist.Entities.Abstract.Category;

/**
 * Created by rafagonc on 1/5/16.
 */
public interface CategoryFactory {

    public Category createCategoryWithCategoryString(String name);

}
