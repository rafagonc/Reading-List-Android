package goncalves.com.readinglist.Factories.Server.Concrete;

import goncalves.com.readinglist.Factories.Server.Abstract.ServiceCallFactory;
import goncalves.com.readinglist.Server.Calls.Abstract.ServiceCall;
import goncalves.com.readinglist.Server.Calls.Concrete.CoverImageCall;
import goncalves.com.readinglist.Server.Calls.Concrete.SearchBooksCall;
import goncalves.com.readinglist.Server.Requests.Abstract.ServiceRequest;
import goncalves.com.readinglist.Server.Requests.Concrete.CoverImageRequest;
import goncalves.com.readinglist.Server.Requests.Concrete.SearchBooksRequest;

/**
 * Created by rafagonc on 1/11/16.
 */
public class ServiceCallFactoryImpl implements ServiceCallFactory {

    @Override
    public ServiceCall callForRequest(ServiceRequest request) {
        if (request instanceof CoverImageRequest) {
            return new CoverImageCall();
        } else if (request instanceof SearchBooksRequest) {
            return new SearchBooksCall();
        }
        return null;
    }
}
