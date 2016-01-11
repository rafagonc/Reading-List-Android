package goncalves.com.readinglist.Factories.Concrete;

import java.util.HashMap;

import goncalves.com.readinglist.Factories.Abstract.ServiceCallFactory;
import goncalves.com.readinglist.Server.Calls.Concrete.CoverImageCall;
import goncalves.com.readinglist.Server.Calls.Concrete.RecommendedBooksCall;
import goncalves.com.readinglist.Server.Requests.Abstract.ServiceRequest;
import goncalves.com.readinglist.Server.Requests.Concrete.CoverImageRequest;
import goncalves.com.readinglist.Server.Requests.Concrete.RecommendedBooksRequest;

/**
 * Created by rafagonc on 1/11/16.
 */
public class ServiceCallFactoryImpl implements ServiceCallFactory {

    public static HashMap serviceMap() {
        HashMap<Class, Class> serviceMap = new HashMap<>();
        serviceMap.put(CoverImageRequest.class, CoverImageCall.class);
        serviceMap.put(RecommendedBooksRequest.class, RecommendedBooksCall.class);
        return serviceMap;
    }


    @Override
    public Class callForRequest(ServiceRequest request) {
        Class callClass = (Class)serviceMap().get(request.getClass());
        return callClass;
    }
}
