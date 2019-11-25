package com.myapp.uidesign;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Layout;
import android.widget.TextClock;

import androidx.core.content.res.ResourcesCompat;

public class ClockView extends TextClock {

    // You can only create one clock view using getInstance

    private static ClockView clockview;
    private static int size = 70;

    // Use of Calibri Light font, see font folder

    private ClockView(Context context){
        super(context);
        this.setTextSize(size);
        this.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        this.setTypeface(ResourcesCompat.getFont(context, R.font.calibril));

    }

    // Need to pass context to get instance

    public static ClockView getInstance(Context context){
        if(clockview == null){
            clockview = new ClockView(context);
        }
        return clockview;
    }


}
