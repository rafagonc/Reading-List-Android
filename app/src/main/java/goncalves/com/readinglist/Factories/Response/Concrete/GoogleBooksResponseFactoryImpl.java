package goncalves.com.readinglist.Factories.Response.Concrete;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import goncalves.com.readinglist.Entities.Abstract.TransientBook;
import goncalves.com.readinglist.Entities.Concrete.TransientBookImpl;
import goncalves.com.readinglist.Factories.Response.Abstract.GoogleBooksResponseFactory;

/**
 * Created by rafagonc on 3/12/16.
 */
public class GoogleBooksResponseFactoryImpl implements GoogleBooksResponseFactory {

    @Override
    public List<TransientBook> parse(JSONArray books) throws JSONException {
        List<TransientBook> transientBooks = new ArrayList<>();
        for (int i = 0; i < books.length(); i++) {
            TransientBookImpl transientBook = new TransientBookImpl();
            JSONObject object = books.getJSONObject(i);
            JSONObject book = object.getJSONObject("volumeInfo");
            transientBook.setName(book.getString("title"));
            String author = (String)book.getJSONArray("authors").get(0);
            if (author == null) {
                author = "Unknown Author";
            }
            transientBook.setAuthorString(author);
            if (book.has("imageLinks")) {
                transientBook.setImageURL(book.getJSONObject("imageLinks").getString("thumbnail"));
            }
            if (book.has("description")) {
                transientBook.setSnippet(book.getString("description"));
            }
            transientBooks.add(transientBook);
        }

        return transientBooks;
    }
}
