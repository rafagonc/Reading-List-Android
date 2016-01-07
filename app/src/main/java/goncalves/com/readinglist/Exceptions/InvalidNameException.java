package goncalves.com.readinglist.Exceptions;

/**
 * Created by rafagonc on 1/6/16.
 */
public class InvalidNameException extends Exception {

    @Override
    public String getMessage() {
        return "You need to set a book name!";
    }

}
