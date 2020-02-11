
package com.mike.miwok;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainClickListener mainClickListener = new MainClickListener();

        findViewById(R.id.numbers).setOnClickListener(mainClickListener);
        findViewById(R.id.colors).setOnClickListener(mainClickListener);
        findViewById(R.id.family).setOnClickListener(mainClickListener);
        findViewById(R.id.phrases).setOnClickListener(mainClickListener);
    }
}
