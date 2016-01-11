package goncalves.com.readinglist.Server.Proxy.Concrete;

import com.google.inject.Inject;

import java.util.HashMap;
import java.util.HashSet;

import goncalves.com.readinglist.Factories.Abstract.ServiceCallFactory;
import goncalves.com.readinglist.Server.Calls.Abstract.ServiceCall;
import goncalves.com.readinglist.Server.Proxy.Abstract.ServiceProxy;
import goncalves.com.readinglist.Server.Requests.Abstract.ServiceRequest;
import goncalves.com.readinglist.Server.Response.ServiceResponse;

/**
 * Created by rafagonc on 1/11/16.
 */
public class ServiceProxyImpl implements ServiceProxy {

    //region Properties
    @Inject ServiceCallFactory serviceCallFactory;
    private HashMap<ServiceRequest, HashSet<ServiceResponse>> loading;
    //endregion

    //region Registering
    private void registerServiceCall(ServiceRequest request, ServiceResponse response) {
        if (loading.containsKey(request)) {
            HashSet<ServiceResponse> responses = loading.get(request);
            responses.add(response);
        } else {
            HashSet<ServiceResponse> responses = new HashSet<>();
            responses.add(response);
            loading.put(request, responses);
        }
    }

    private void unregisterServiceCall(ServiceRequest request) {
        loading.remove(request);
    }
    //endregion

    //region Proxy
    @Override
    public void callServiceWithRequest(final ServiceRequest request, final ServiceResponse response) {
        try {
            registerServiceCall(request, response);
            if (loading.get(request) != null) return;
            Class callClass = serviceCallFactory.callForRequest(request);
            ServiceCall call = (ServiceCall)callClass.newInstance();
            call.callServiceWithRequest(request, new ServiceResponse() {
                public void onSuccess(Object data) {
                    for (ServiceResponse anonResponse : loading.get(request)) anonResponse.onSuccess(data);
                    unregisterServiceCall(request);
                }
                public void onFailure(String errorMessage) {
                    for (ServiceResponse anonResponse : loading.get(request)) anonResponse.onFailure(errorMessage);
                    unregisterServiceCall(request);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //endregion

}
