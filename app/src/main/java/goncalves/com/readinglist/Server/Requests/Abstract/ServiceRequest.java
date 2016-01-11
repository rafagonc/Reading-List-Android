package goncalves.com.readinglist.Server.Requests.Abstract;

import java.util.HashMap;

import goncalves.com.readinglist.Server.Metadata.ServiceMethod;

/**
 * Created by rafagonc on 1/11/16.
 */
public interface ServiceRequest {

    public String getURL();
    public HashMap getParameters();
    public HashMap getAdditionalHeaders();
    public ServiceMethod getMethod();
    public Boolean canCacheResult();

}
