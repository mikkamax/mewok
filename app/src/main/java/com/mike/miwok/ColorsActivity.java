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
                new Word("red", "weṭeṭṭi", R.drawable.color_red),
                new Word("green", "chokokki", R.drawable.color_green),
                new Word("brown", "ṭakaakki", R.drawable.color_brown),
                new Word("gray", "ṭopoppi", R.drawable.color_gray),
                new Word("black", "kululli", R.drawable.color_black),
                new Word("white", "kelelli", R.drawable.color_white),
                new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow),
                new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow)));

        WordAdapter wordAdapter = new WordAdapter(this, colors);

        ListView listView = findViewById(R.id.wordsList);
        listView.setAdapter(wordAdapter);
    }
}
