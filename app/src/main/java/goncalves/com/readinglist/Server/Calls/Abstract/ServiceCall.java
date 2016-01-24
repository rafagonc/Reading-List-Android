package goncalves.com.readinglist.Server.Calls.Abstract;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

import goncalves.com.readinglist.Application.ReadingList;
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
    public void callServiceWithRequest(final ServiceRequest request, final ServiceResponse response) {
        this.serviceRequest = request;
        this.serviceResponse = response;
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(convertMethod(request.getMethod()), request.getURL(), this, this) {
            @Override
            protected Map<String, String> getParams() {
                Log.i("Params", "He got it " + request.getParameters());
                return request.getParameters();
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (request.getAdditionalHeaders() != null && request.getAdditionalHeaders().size() > 0) return request.getAdditionalHeaders();
                return super.getHeaders();
            }

        };
        Volley.newRequestQueue(ReadingList.context).add(jsonObjReq) ;

    }

    //region Abstract Methods
    public abstract void onResponse(Object response);
    public void onErrorResponse(VolleyError error) {
        onError(error);
    }
    public abstract void onError(Exception e);
    //endregion

    //region Helpers
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
    protected Context getContext() {
        return ReadingList.context;
    }
    //endregion
}
