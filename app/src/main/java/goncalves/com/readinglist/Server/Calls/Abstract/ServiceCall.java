package goncalves.com.readinglist.Server.Calls.Abstract;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import goncalves.com.readinglist.Server.Metadata.ServiceMethod;
import goncalves.com.readinglist.Server.Proxy.Abstract.ServiceProxy;
import goncalves.com.readinglist.Server.Requests.Abstract.ServiceRequest;
import goncalves.com.readinglist.Server.Response.ServiceResponse;

/**
 * Created by rafagonc on 1/11/16.
 */
public abstract class ServiceCall implements ServiceProxy, Response.Listener, Response.ErrorListener {

    protected ServiceRequest serviceRequest;
    protected ServiceResponse serviceResponse;

    @Override
    public void callServiceWithRequest(ServiceRequest request, final ServiceResponse response) {
        this.serviceRequest = request;
        this.serviceResponse = response;
        JsonRequest jsonRequest = new JsonObjectRequest(convertMethod(request.getMethod()), request.getURL(), this, this);
        Volley.newRequestQueue()

    }

    public abstract void onResponse(Object response);
    public abstract void onErrorResponse(VolleyError error);

    private Integer convertMethod(ServiceMethod method) {
        if (method == ServiceMethod.DELETE) {
            return Request.Method.DELETE;
        } else  if (method == ServiceMethod.GET) {
            return Request.Method.GET;
        } else if (method == ServiceMethod.POST) {
            return Request.Method.POST;
        } else if (method == ServiceMethod.PUT) {
            return Request.Method.PUT;
        } else if (method == ServiceMethod.HEAD) {
            return Request.Method.HEAD;
        } else {
            return null;
        }
    }
}
