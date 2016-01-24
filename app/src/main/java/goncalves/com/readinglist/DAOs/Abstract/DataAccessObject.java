package goncalves.com.readinglist.DAOs.Abstract;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by rafagonc on 1/6/16.
 */
public interface DataAccessObject<T> {

    public SugarRecord insert();
    public void delete(SugarRecord record);
    public List<T> findAll();
    public SugarRecord findById(Long id);

}
