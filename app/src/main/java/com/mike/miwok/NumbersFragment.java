package com.mike.miwok;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersFragment extends Fragment {
    private AudioHandler audioHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words_list, container, false);
        audioHandler = AudioHandler.getAudioHandlerInstance(getActivity());

        final ArrayList<Word> numbers = new ArrayList<>(Arrays.asList(
                new Word("one", "lutti", R.drawable.number_one, R.raw.number_one),
                new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two),
                new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three),
                new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four),
                new Word("five", "massokka", R.drawable.number_five, R.raw.number_five),
                new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six),
                new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven),
                new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight),
                new Word("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine),
                new Word("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten)));

        WordAdapter wordAdapter = new WordAdapter(getActivity(), numbers, R.color.category_numbers);

        ListView listView = rootView.findViewById(R.id.wordsList);
        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                audioHandler.play(getActivity(), numbers.get(position).getSoundResourceId());
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
