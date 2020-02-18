
package com.mike.miwok;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.viewpager);
        mViewPager.setAdapter(new CustomFragmentAdapter(getSupportFragmentManager()));
    }
}
