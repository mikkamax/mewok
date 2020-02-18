
package com.mike.miwok;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.Stack;


public class MainActivity extends AppCompatActivity {
    protected Stack<Integer> mFragmentBackStack = new Stack<>();
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    protected boolean isBackButtonPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.viewpager);
        mViewPager.setAdapter(new CustomFragmentAdapter(getSupportFragmentManager()));

        mTabLayout = findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);

        // creating backstack-a-like for the fragments via viewpager
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (!isBackButtonPressed) {
                    mFragmentBackStack.push(tab.getPosition());
                }
                else {
                    isBackButtonPressed = false;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    @Override
    public void onBackPressed() {
        isBackButtonPressed = true;
        if (!mFragmentBackStack.empty()) {
            mViewPager.setCurrentItem(mFragmentBackStack.pop());
        }
        else {
            super.onBackPressed();
        }
    }
}
