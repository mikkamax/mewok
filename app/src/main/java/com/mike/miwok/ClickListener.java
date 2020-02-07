package com.mike.miwok;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ClickListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        Context context = view.getContext();
        String message = "";
        Class rightClass = null;

        switch (view.getId()) {
            case R.id.numbers :
                message = "Number list clicked";
                rightClass = NumbersActivity.class;
                break;
            case R.id.colors :
                message = "Colors list clicked";
                rightClass = ColorsActivity.class;
                break;
            case R.id.family :
                message = "Family list clicked";
                rightClass = FamilyActivity.class;
                break;
            case R.id.phrases :
                message = "Phrases list clicked";
                rightClass = PhrasesActivity.class;
        }
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        context.startActivity(new Intent(context, rightClass));
    }
}
