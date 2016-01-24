package goncalves.com.readinglist.DAOs.Concrete;

import com.orm.SugarRecord;
import java.util.List;
import goncalves.com.readinglist.DAOs.Abstract.BookDataAccessObject;
import goncalves.com.readinglist.Entities.Concrete.BookImpl;

/**
 * Created by rafagonc on 1/5/16.
 */


public class BookDataAccessObjectImpl implements BookDataAccessObject {

    @Override
    public SugarRecord insert() {
        BookImpl b = new BookImpl();
        b.setName("Rafael");
        return b;
    }

    @Override
    public void delete(SugarRecord record) {
        record.delete();
    }

    @Override
    public List findAll() {
        return BookImpl.find(BookImpl.class, "");
    }

    @Override
    public SugarRecord findById(Long id) {
        return BookImpl.findById(BookImpl.class ,id);
    }

}
