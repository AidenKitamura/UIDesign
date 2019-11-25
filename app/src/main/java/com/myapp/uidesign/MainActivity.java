package com.myapp.uidesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;
import android.widget.Button;

// This is a simply example. Thus, you should not use this file as your final main activity.
// ClockView is just a very simple clock which will give you nothing. If you just wanna use the clock, go ahead and use ClockView. Otherwise you should only use TimerView, which is a combination of Clock and Timer
// Before you use these files, please note:
/*
       Add to strings.xml:
       <string name="UNTIL"><u>UNTIL</u></string>
       <string name="NEXTBREAK">NEXT BREAK</string>
       <string name="NEXTSTUDYPERIOD"><u>NEXT STUDY PERIOD</u></string>
 */
public class MainActivity extends AppCompatActivity {

    // To set background automatically

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // **IMPORTANT** DO ADD the FOLLOWING STATEMENT in order to get rid of the status bar (Your battery, current time, etc.)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // You know what does this mean :)
        setContentView(R.layout.activity_main);

        // Get layout
        // If you are using LinearLayout do not forget to change the parameters
        // Dun forget to set your layout's id manually in your xml file. simply add android:id=xxxxx.
        final ConstraintLayout root = findViewById(R.id.mainLayout);

        // Initialize Dynamic Background
        DynamicBackground.initialize();

        // Call this setBackground method to set background, using Dynamic.getBackground()
        root.setBackground(DynamicBackground.getBackground());

        // Timer task for background initiation
        CountDownTimer ct = new CountDownTimer(60000, 30) {
            @Override
            public void onTick(long l) {
                root.setBackground(DynamicBackground.getBackground((int)(l * 1200)));
            }

            @Override
            public void onFinish() {
                // Nothing happens
            }
        };

        // Don't forget to start
        ct.start();

        // Create and get the TimerView
        TimerView t = TimerView.getInstance(this);

        t.reset(900000, 120000);

        // **IMPORTANT** do not forget to set layout params before adding a layout to another
        // For TimerView, you need to set YourLayout.LayoutParams.MATCH_PARENT for both arguments in order for it to work properly
        t.setLayoutParams(new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT));

        // addView(a) then addView(b) -> b will be at the top
        root.addView(t);

        // Simple adding a non-configured button. Remember: You can add a simple view to a layout, but you cannot add a view group to a layout without setting its layout params
        // Setting layout params for any view is recommended
        root.addView(new Button(this));
    }
}
