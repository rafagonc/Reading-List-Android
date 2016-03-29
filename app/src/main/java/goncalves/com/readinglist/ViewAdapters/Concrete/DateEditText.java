package goncalves.com.readinglist.ViewAdapters.Concrete;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import java.lang.ref.WeakReference;
import java.util.Date;

import goncalves.com.readinglist.Entities.Abstract.Log;
import goncalves.com.readinglist.Exceptions.FutureDateException;
import goncalves.com.readinglist.Exceptions.InvalidDateException;
import goncalves.com.readinglist.Fragment.DatePickerFragment;
import goncalves.com.readinglist.Interfaces.LogAddChainOfResponsibility;
import goncalves.com.readinglist.ViewAdapters.Delegates.DatePickerFragmentDelegate;

/**
 * Created by rafagonc on 3/25/16.
 */
public class DateEditText extends EditText implements View.OnClickListener, DatePickerFragmentDelegate, LogAddChainOfResponsibility {

    private WeakReference<Activity> activityWeakReference;
    private Integer pages;
    private Date choseDate;

    //region Constructors
    public DateEditText(Context context) {
        super(context);
        onConstruct();
    }

    public DateEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        onConstruct();
    }

    public DateEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onConstruct();
    }
    private void onConstruct() {
        setFocusableInTouchMode(false);
        setOnClickListener(this);
    }
    //endregion

    //region Actions
    @Override
    public void onClick(View v) {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setDelegate(this);
        fragment.show(getActivityWeakReference().get().getFragmentManager(), "DatePicker");
    }
    //endregion

    //region Chain of Responsibility
    @Override
    public void processLog(Log log) throws Exception {
        if (this.choseDate == null) {
            throw new InvalidDateException();
        } else if (this.choseDate.after(new Date())) {
            throw new FutureDateException();
        } else {
            log.setDate(this.choseDate);
        }
    }
    //endregion

    //region Delegate
    @Override
    public void datePickerJustPickedDate(DatePickerFragment fragment, Date date) {
        this.choseDate = date;
        setText(date.toString());
    }
    //endregion

    //region Getters and Setters
    public Integer getPages() {
        return pages;
    }
    public void setPages(Integer pages) {
        this.pages = pages;
    }
    public WeakReference<Activity> getActivityWeakReference() {
        return activityWeakReference;
    }
    public void setActivityWeakReference(WeakReference<Activity> activityWeakReference) {
        this.activityWeakReference = activityWeakReference;
    }
    //endregion
}
