package com.mike.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Context context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_layout, parent, false);
        }

        Word currentWord = getItem(position);
        TextView miwok = listItemView.findViewById(R.id.item_miwok);
        TextView english = listItemView.findViewById(R.id.item_english);

        miwok.setText(currentWord.getMiwokWord());
        english.setText(currentWord.getDefaultWord());

        return listItemView;
    }
}
