package goncalves.com.readinglist.Factories.Concrete;

import goncalves.com.readinglist.Entities.Abstract.Category;
import goncalves.com.readinglist.Entities.Concrete.CategoryImpl;
import goncalves.com.readinglist.Factories.Abstract.CategoryFactory;

/**
 * Created by rafagonc on 1/5/16.
 */
public class CategoryFactoryImpl implements CategoryFactory {

    @Override
    public Category createCategoryWithCategoryString(String name) {
        CategoryImpl category = new CategoryImpl();
        category.setName(name);
        return category;
    }
}
