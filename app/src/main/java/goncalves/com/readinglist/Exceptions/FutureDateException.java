package goncalves.com.readinglist.Exceptions;

/**
 * Created by rafagonc on 3/26/16.
 */
public class FutureDateException extends Exception {

    @Override
    public String getMessage() {
        return "You need to read and then log!";
    }
}
