package goncalves.com.readinglist.DAOs.Concrete;

import com.orm.SugarRecord;

import java.util.List;

import goncalves.com.readinglist.DAOs.Abstract.AuthorDataAccessObject;
import goncalves.com.readinglist.Entities.Abstract.Author;
import goncalves.com.readinglist.Entities.Concrete.AuthorImpl;

/**
 * Created by rafagonc on 1/5/16.
 */
public class AuthorDataAccessObjectImpl implements AuthorDataAccessObject {

    @Override
    public SugarRecord insert() {
        return new AuthorImpl();
    }

    @Override
    public void delete(SugarRecord record) {
        record.delete();
    }

    @Override
    public List findAll() {
        return AuthorImpl.find(AuthorImpl.class, "");
    }

    @Override
    public Author findByName(String name) {
        List auhtors = AuthorImpl.find(AuthorImpl.class, "name LIKE  '" + name +"'");
        Author author = auhtors.size() == 1 ? (Author) auhtors.get(0) : null;
        return author;
    }

    @Override
    public SugarRecord findById(Long id) {
        return AuthorImpl.findById(AuthorImpl.class ,id);
    }
}
