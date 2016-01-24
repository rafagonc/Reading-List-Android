package goncalves.com.readinglist.Factories.Response.Abstract;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

import goncalves.com.readinglist.Entities.Abstract.GoogleCoverObject;

/**
 * Created by rafagonc on 1/17/16.
 */
public interface GoogleCoverResponseFactory {

    public List<GoogleCoverObject> parse(JSONArray covers) throws JSONException;

}
