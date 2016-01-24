package goncalves.com.readinglist.Server.Requests.Concrete;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import goncalves.com.readinglist.Server.Metadata.ServiceMethod;
import goncalves.com.readinglist.Server.Requests.Abstract.ServiceRequest;

/**
 * Created by rafagonc on 1/11/16.
 */
public class CoverImageRequest implements ServiceRequest {

    private String query;

    public CoverImageRequest(String query) {
        this.query = query;
    }

    @Override
    public String getURL() {
        String encodedQuery = URLEncoder.encode(this.query);
        return "https://www.googleapis.com/customsearch/v1?" +
                "key=AIzaSyAt4RNvJlgXsp-T2sGc8AHoejaMhN5r8IM&" +
                "cx=005126926308198905537:wtspnjgitvi&" +
                "searchType=image&" +
                "alt=json&" +
                "q="+encodedQuery + "&" +
                "rsz=8";
    }

    @Override
    public Map getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        return parameters;
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
}

