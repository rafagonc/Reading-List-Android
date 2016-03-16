package goncalves.com.readinglist.Factories.Response.Abstract;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

import goncalves.com.readinglist.Entities.Abstract.TransientBook;

/**
 * Created by rafagonc on 3/12/16.
 */
public interface GoogleBooksResponseFactory {

    public List<TransientBook> parse(JSONArray books) throws JSONException;

}
