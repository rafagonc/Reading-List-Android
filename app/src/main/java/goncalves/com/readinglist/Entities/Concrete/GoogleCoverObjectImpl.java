package goncalves.com.readinglist.Entities.Concrete;

import goncalves.com.readinglist.Entities.Abstract.GoogleCoverObject;

/**
 * Created by rafagonc on 1/17/16.
 */
public class GoogleCoverObjectImpl implements GoogleCoverObject {

    //region Properties
    private String url;
    private String title;
    //endregion

    //region Getters And Setters
    public String getUrl() {
        return url;
    }
    public String getTitle() {
        return title;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    //endregion
}
