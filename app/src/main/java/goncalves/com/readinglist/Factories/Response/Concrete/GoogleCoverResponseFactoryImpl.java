package goncalves.com.readinglist.Factories.Response.Concrete;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import goncalves.com.readinglist.Entities.Abstract.GoogleCoverObject;
import goncalves.com.readinglist.Entities.Concrete.GoogleCoverObjectImpl;
import goncalves.com.readinglist.Factories.Response.Abstract.GoogleCoverResponseFactory;

/**
 * Created by rafagonc on 1/17/16.
 */
public class GoogleCoverResponseFactoryImpl implements GoogleCoverResponseFactory {


    @Override
    public List<GoogleCoverObject> parse(JSONArray covers) throws JSONException {
        List<GoogleCoverObject> result = new ArrayList<>();
        for (int i = 0; i < covers.length(); i++) {
            JSONObject cover = (JSONObject)covers.get(i);
            GoogleCoverObjectImpl newCover = new GoogleCoverObjectImpl();
            newCover.setTitle(cover.getString("title"));
            newCover.setUrl(cover.getString("link"));
            result.add(newCover);
        }
        return result;
    }
}
