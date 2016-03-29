package goncalves.com.readinglist.ViewAdapters.Delegates;

import java.util.Date;

import goncalves.com.readinglist.Fragment.DatePickerFragment;

/**
 * Created by rafagonc on 3/26/16.
 */
public interface DatePickerFragmentDelegate {

    public void datePickerJustPickedDate(DatePickerFragment fragment, Date date);

}
