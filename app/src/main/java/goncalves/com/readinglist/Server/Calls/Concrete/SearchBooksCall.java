package goncalves.com.readinglist.Server.Calls.Concrete;

import com.google.inject.Inject;

import org.json.JSONObject;

import java.util.List;

import goncalves.com.readinglist.Entities.Abstract.TransientBook;
import goncalves.com.readinglist.Factories.Response.Abstract.GoogleBooksResponseFactory;
import goncalves.com.readinglist.Server.Calls.Abstract.ServiceCall;
import roboguice.RoboGuice;

/**
 * Created by rafagonc on 3/12/16.
 */
public class SearchBooksCall extends ServiceCall {

    @Inject GoogleBooksResponseFactory googleBooksResponseFactory;

    public SearchBooksCall() {
        RoboGuice.getInjector(getContext()).injectMembers(this);
    }

    @Override
    public void onResponse(Object response) {
        try {
            JSONObject responseData = (JSONObject)response;
            List<TransientBook> transientBooks = googleBooksResponseFactory.parse(responseData.getJSONArray("items"));
            serviceResponse.onSuccess(transientBooks);
        } catch (Exception e) {
            serviceResponse.onFailure(e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void onError(Exception e) {
        serviceResponse.onFailure(e.getMessage());
    }
}
