package com.mike.miwok;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Word> colors = new ArrayList<>(Arrays.asList(
                new Word("red", "weṭeṭṭi"),
                new Word("green", "chokokki"),
                new Word("brown", "ṭakaakki"),
                new Word("gray", "ṭopoppi"),
                new Word("black", "kululli"),
                new Word("white", "kelelli"),
                new Word("dusty yellow", "ṭopiisә"),
                new Word("mustard yellow", "chiwiiṭә")));

        WordAdapter wordAdapter = new WordAdapter(this, colors);

        ListView listView = findViewById(R.id.wordsList);
        listView.setAdapter(wordAdapter);
    }
}
