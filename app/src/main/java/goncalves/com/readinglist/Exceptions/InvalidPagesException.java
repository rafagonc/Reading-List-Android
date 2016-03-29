package goncalves.com.readinglist.Exceptions;

/**
 * Created by rafagonc on 3/26/16.
 */
public class InvalidPagesException extends Exception {

    @Override
    public String getMessage() {
        return "You need to set the pages you read!";
    }

}
