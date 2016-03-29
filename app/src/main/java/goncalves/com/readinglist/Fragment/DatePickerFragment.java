package goncalves.com.readinglist.Fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

import goncalves.com.readinglist.ViewAdapters.Delegates.DatePickerFragmentDelegate;

/**
 * Created by rafagonc on 3/26/16.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    //region Properties
    private DatePickerFragmentDelegate delegate;
    //endregion

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    //
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        if (this.delegate != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, monthOfYear);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            Date date = calendar.getTime();
            this.delegate.datePickerJustPickedDate(this, date);
        }
    }

    //region Getters and Setters
    public DatePickerFragmentDelegate getDelegate() {
        return delegate;
    }

    public void setDelegate(DatePickerFragmentDelegate delegate) {
        this.delegate = delegate;
    }
    //endregion
}
