package goncalves.com.readinglist.Factories.Entities.Concrete;

import com.google.inject.Inject;

import goncalves.com.readinglist.DAOs.Abstract.CategoryDataAccessObject;
import goncalves.com.readinglist.Entities.Abstract.Category;
import goncalves.com.readinglist.Entities.Concrete.CategoryImpl;
import goncalves.com.readinglist.Factories.Entities.Abstract.CategoryFactory;

/**
 * Created by rafagonc on 1/5/16.
 */
public class CategoryFactoryImpl implements CategoryFactory {

    @Inject CategoryDataAccessObject categoryDataAccessObject;

    @Override
    public Category createCategoryWithCategoryString(String name) {
        CategoryImpl category = (CategoryImpl)this.categoryDataAccessObject.insert();
        category.setName(name);
        return category;
    }
}
