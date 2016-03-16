package goncalves.com.readinglist.Server.Requests.Concrete;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import goncalves.com.readinglist.Server.Metadata.ServiceMethod;
import goncalves.com.readinglist.Server.Requests.Abstract.ServiceRequest;

/**
 * Created by rafagonc on 3/12/16.
 */
public class SearchBooksRequest implements ServiceRequest {

    private String query;

    //region Request
    @Override
    public String getURL() {
        return "https://www.googleapis.com/books/v1/volumes?key=AIzaSyCB9siucRVNmW3r8PLDcZu2DnZiofC68U8&q=" + URLEncoder.encode(query);
    }

    @Override
    public Map getParameters() {
        return new HashMap();
    }

    @Override
    public Map getAdditionalHeaders() {
        return new HashMap();
    }

    @Override
    public ServiceMethod getMethod() {
        return ServiceMethod.GET;
    }

    @Override
    public Boolean canCacheResult() {
        return true;
    }
    //endregion

    //region Getters and Setters
    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query;
    }
    //endregion
}
