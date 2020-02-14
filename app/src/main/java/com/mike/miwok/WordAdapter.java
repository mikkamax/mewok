package com.mike.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;

    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_layout, parent, false);
        }

        final Word currentWord = getItem(position);

        View textContainer = listItemView.findViewById(R.id.text_container);
        textContainer.setBackgroundColor(getContext().getResources().getColor(mColorResourceId));

        TextView miwok = listItemView.findViewById(R.id.item_miwok);
        miwok.setText(currentWord.getMiwokWord());

        TextView english = listItemView.findViewById(R.id.item_english);
        english.setText(currentWord.getEnglishWord());

        ImageView image = listItemView.findViewById(R.id.item_image);
        if (currentWord.hasImage()) {
            image.setImageResource(currentWord.getImageResourceId());
            image.setVisibility(View.VISIBLE);
        }
        else {
            image.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
