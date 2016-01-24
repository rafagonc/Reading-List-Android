package goncalves.com.readinglist.Factories.Server.Abstract;

import goncalves.com.readinglist.Server.Calls.Abstract.ServiceCall;
import goncalves.com.readinglist.Server.Requests.Abstract.ServiceRequest;

/**
 * Created by rafagonc on 1/11/16.
 */
public interface ServiceCallFactory {

    public ServiceCall callForRequest(ServiceRequest request);

}
