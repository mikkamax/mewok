package com.mike.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Word> numbers = new ArrayList<>(Arrays.asList(
                new Word("one", "lutti"),
                new Word("two", "otiiko"),
                new Word("three", "tolookosu"),
                new Word("four", "oyyisa"),
                new Word("five", "massokka"),
                new Word("six", "temmokka"),
                new Word("seven", "kenekaku"),
                new Word("eight", "kawinta"),
                new Word("nine", "wo’e"),
                new Word("ten", "na’aacha")));

        WordAdapter wordAdapter = new WordAdapter(this, numbers);

        ListView listView = findViewById(R.id.wordsList);
        listView.setAdapter(wordAdapter);
    }
}
