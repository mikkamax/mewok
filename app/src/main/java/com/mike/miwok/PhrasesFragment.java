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

public class PhrasesFragment extends Fragment {
    private AudioHandler audioHandler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words_list, container, false);
        audioHandler = AudioHandler.getAudioHandlerInstance(getActivity());

        final ArrayList<Word> phrases = new ArrayList<>(Arrays.asList(
                new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going),
                new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name),
                new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is),
                new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling),
                new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good),
                new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming),
                new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming),
                new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming),
                new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go),
                new Word("Come here.", "әnni'nem", R.raw.phrase_come_here)));

        WordAdapter wordAdapter = new WordAdapter(getActivity(), phrases, R.color.category_phrases);

        ListView listView = rootView.findViewById(R.id.wordsList);
        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                audioHandler.play(getActivity(), phrases.get(position).getSoundResourceId());
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
