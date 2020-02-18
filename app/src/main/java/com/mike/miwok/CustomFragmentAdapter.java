package com.mike.miwok;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CustomFragmentAdapter extends FragmentPagerAdapter {
    public CustomFragmentAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 :
                return new NumbersFragment();
            case 1 :
                return new FamilyFragment();
            case 2 :
                return new ColorsFragment();
            default :
                return new PhrasesFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
