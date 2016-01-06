package goncalves.com.readinglist.Customizers;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;

/**
 * Created by rafagonc on 1/5/16.
 */
public class ActionBarCustomizer {

    public static void customizeActionBar(ActionBar actionBar) {
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
    }
}
