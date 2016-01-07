package goncalves.com.readinglist.Exceptions;

import goncalves.com.readinglist.R;
import roboguice.inject.InjectResource;

/**
 * Created by rafagonc on 1/6/16.
 */
public class InvalidCategoryException extends Exception {

    @Override
    public String getMessage() {
        return "You need to choose a category!";
    }
}
