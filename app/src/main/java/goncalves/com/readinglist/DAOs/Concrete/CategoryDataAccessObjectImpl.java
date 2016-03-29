package goncalves.com.readinglist.DAOs.Concrete;

import com.orm.SugarRecord;

import java.util.List;

import goncalves.com.readinglist.DAOs.Abstract.CategoryDataAccessObject;
import goncalves.com.readinglist.Entities.Abstract.Category;
import goncalves.com.readinglist.Entities.Concrete.CategoryImpl;

/**
 * Created by rafagonc on 1/5/16.
 */
public class CategoryDataAccessObjectImpl implements CategoryDataAccessObject {

    @Override
    public SugarRecord insert() {
        return new CategoryImpl();
    }

    @Override
    public void delete(SugarRecord record) {
        record.delete();
    }

    @Override
    public List findAll() {
        return CategoryImpl.find(CategoryImpl.class, "");
    }

    @Override
    public SugarRecord findById(Long id) {
        return CategoryImpl.findById(CategoryImpl.class ,id);
    }

    @Override
    public Boolean hasCreatedCategories() {
        return CategoryImpl.count(CategoryImpl.class) > 0;
    }

    @Override
    public Category mostUsedCatgory() {
        return null;
    }
}
