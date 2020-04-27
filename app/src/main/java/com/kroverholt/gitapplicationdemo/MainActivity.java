package com.kroverholt.gitapplicationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView mainMessage = findViewById(R.id.tvMainMessage);
        Button myButton = findViewById(R.id.btnToggle);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainMessage.getVisibility() == View.INVISIBLE)
                    mainMessage.setVisibility(View.VISIBLE);
                else if (mainMessage.getVisibility() == View.VISIBLE)
                    mainMessage.setVisibility(View.INVISIBLE);
                else
                    Log.i(TAG, "onClick: Unable to set visibility");
            }
        });
    }

}
