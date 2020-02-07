
package com.mike.miwok;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView numbersView = findViewById(R.id.numbers);
        TextView colorsView = findViewById(R.id.colors);
        TextView familyView = findViewById(R.id.family);
        TextView phrasesView = findViewById(R.id.phrases);

        ClickListener clickListener = new ClickListener();

        numbersView.setOnClickListener(clickListener);
        colorsView.setOnClickListener(clickListener);
        familyView.setOnClickListener(clickListener);
        phrasesView.setOnClickListener(clickListener);
    }
}
