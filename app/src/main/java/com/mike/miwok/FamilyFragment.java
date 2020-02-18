package com.mike.miwok;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;

public class FamilyFragment extends Fragment {
    private AudioHandler audioHandler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words_list, container, false);
        audioHandler = AudioHandler.getAudioHandlerInstance(getActivity());

        final ArrayList<Word> family = new ArrayList<>(Arrays.asList(
                new Word("father", "әpә", R.drawable.family_father, R.raw.family_father),
                new Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother),
                new Word("son", "angsi", R.drawable.family_son, R.raw.family_son),
                new Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter),
                new Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother),
                new Word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother),
                new Word("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister),
                new Word("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister),
                new Word("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother),
                new Word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather)));

        WordAdapter wordAdapter = new WordAdapter(getActivity(), family, R.color.category_family);

        ListView listView = rootView.findViewById(R.id.wordsList);
        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                audioHandler.play(getActivity(), family.get(position).getSoundResourceId());
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        audioHandler.releaseMediaPlayer();
    }
}
