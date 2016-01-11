package goncalves.com.readinglist.Server.Response;

/**
 * Created by rafagonc on 1/11/16.
 */
public interface ServiceResponse {

    public void onSuccess(Object data);
    public void onFailure(String errorMessage);

}
