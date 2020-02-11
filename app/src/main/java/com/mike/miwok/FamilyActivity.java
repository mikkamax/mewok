package com.mike.miwok;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Word> family = new ArrayList<>(Arrays.asList(
                new Word("father", "әpә"),
                new Word("mother", "әṭa"),
                new Word("son", "angsi"),
                new Word("daughter", "tune"),
                new Word("older brother", "taachi"),
                new Word("younger brother", "chalitti"),
                new Word("older sister", "teṭe"),
                new Word("younger sister", "kolliti"),
                new Word("grandmother", "ama"),
                new Word("grandfather", "paapa")));

        WordAdapter wordAdapter = new WordAdapter(this, family);

        ListView listView = findViewById(R.id.wordsList);
        listView.setAdapter(wordAdapter);
    }
}
