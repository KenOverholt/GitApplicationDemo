package com.kroverholt.gitapplicationdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    /**
     * Stores value of whether or not the message TextView should be visible on the screen
     * and sets its initial value
     */
    boolean tvVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //create screen elements
        setContentView(R.layout.activity_main);
        final TextView mainMessage = findViewById(R.id.tvMainMessage);
        Button myButton = findViewById(R.id.btnToggle);

        //log initial Visiblity state
        if (mainMessage.getVisibility() == View.VISIBLE)
            Log.i(TAG, "onCreate: VISIBILITY is true");
        else if (mainMessage.getVisibility() == View.INVISIBLE)
            Log.i(TAG, "onCreate: VISIBILITY is false");
        else Log.i(TAG, "onCreate: unable to get VISIBILITY status");

        //if this not the first time through this activity, restore value of tvVisible
        if (savedInstanceState != null) {
            tvVisible = savedInstanceState.getBoolean("mainMessageKey");
        }

        //Set initial visibility of the text message
        if (tvVisible) {
            mainMessage.setVisibility(View.VISIBLE);
        } else {
            mainMessage.setVisibility(View.INVISIBLE);
        }

        /**
         * Create actions to be taken by the button
         */
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainMessage.getVisibility() == View.INVISIBLE) {
                    mainMessage.setVisibility(View.VISIBLE);
                    tvVisible = true;
                } else if (mainMessage.getVisibility() == View.VISIBLE) {
                    mainMessage.setVisibility(View.INVISIBLE);
                    tvVisible = false;
                } else
                    Log.i(TAG, "onClick: Unable to set visibility");
            }
        });
    }

    /**
     * Store the message visibility state
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("mainMessageKey", tvVisible);
        Log.i(TAG, "onSaveInstanceState: saved tvVisible: " + tvVisible);
    }

}
