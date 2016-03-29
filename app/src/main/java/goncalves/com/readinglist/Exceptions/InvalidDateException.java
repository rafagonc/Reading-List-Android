package goncalves.com.readinglist.Exceptions;

/**
 * Created by rafagonc on 3/26/16.
 */
public class InvalidDateException extends Exception {

    @Override
    public String getMessage() {
        return "You need to choose a date!";
    }
}
