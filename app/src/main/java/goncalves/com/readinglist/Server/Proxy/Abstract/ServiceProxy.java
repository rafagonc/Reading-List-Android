package goncalves.com.readinglist.Server.Proxy.Abstract;

import goncalves.com.readinglist.Server.Response.ServiceResponse;
import goncalves.com.readinglist.Server.Requests.Abstract.ServiceRequest;

/**
 * Created by rafagonc on 1/11/16.
 */
public interface ServiceProxy {

    public void callServiceWithRequest(ServiceRequest request, ServiceResponse response);

}
