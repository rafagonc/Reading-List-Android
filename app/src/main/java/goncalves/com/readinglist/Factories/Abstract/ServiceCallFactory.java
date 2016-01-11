package goncalves.com.readinglist.Factories.Abstract;

import goncalves.com.readinglist.Server.Requests.Abstract.ServiceRequest;

/**
 * Created by rafagonc on 1/11/16.
 */
public interface ServiceCallFactory {

    public Class callForRequest(ServiceRequest request);

}
