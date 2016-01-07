package goncalves.com.readinglist.DAOs.Abstract;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by rafagonc on 1/6/16.
 */
public interface DataAccessObject {

    public SugarRecord insert();
    public void delete(SugarRecord record);
    public List findAll();
    public SugarRecord findById(Long id);

}
