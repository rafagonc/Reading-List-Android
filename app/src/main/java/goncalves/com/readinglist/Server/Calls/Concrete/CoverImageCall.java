package goncalves.com.readinglist.Server.Calls.Concrete;

import com.google.inject.Inject;

import org.json.JSONArray;
import org.json.JSONObject;

import goncalves.com.readinglist.Factories.Response.Abstract.GoogleCoverResponseFactory;
import goncalves.com.readinglist.Server.Calls.Abstract.ServiceCall;
import roboguice.RoboGuice;

/**
 * Created by rafagonc on 1/11/16.
 */
public class CoverImageCall extends ServiceCall {

    @Inject GoogleCoverResponseFactory googleCoverResponseFactory;

    public CoverImageCall() {
        RoboGuice.getInjector(getContext()).injectMembers(this);
    }

    @Override
    public void onResponse(Object response) {
        try {
            JSONObject json = (JSONObject)response;
            JSONArray items = json.getJSONArray("items");
            serviceResponse.onSuccess(googleCoverResponseFactory.parse(items));
        } catch (Exception e) {
            onError(e);
        }
    }

    @Override
    public void onError(Exception error) {
        serviceResponse.onFailure(error.getMessage());
    }

}
