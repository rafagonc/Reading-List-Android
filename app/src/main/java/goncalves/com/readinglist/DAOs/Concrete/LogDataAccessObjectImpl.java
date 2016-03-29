package goncalves.com.readinglist.DAOs.Concrete;

import com.orm.SugarRecord;

import java.util.List;

import goncalves.com.readinglist.DAOs.Abstract.LogDataAccessObject;
import goncalves.com.readinglist.Entities.Concrete.LogImpl;

/**
 * Created by rafagonc on 3/25/16.
 */
public class LogDataAccessObjectImpl implements LogDataAccessObject {

    @Override
    public SugarRecord insert() {
        return new LogImpl();
    }

    @Override
    public void delete(SugarRecord record) {
        record.delete();
    }

    @Override
    public List findAll() {
        return LogImpl.find(LogImpl.class, "");
    }

    @Override
    public SugarRecord findById(Long id) {
       return LogImpl.findById(LogImpl.class, id);
    }
}
