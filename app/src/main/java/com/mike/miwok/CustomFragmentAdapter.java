package com.mike.miwok;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CustomFragmentAdapter extends FragmentPagerAdapter {
    private Fragment[] fragments;

    public CustomFragmentAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        fragments = new Fragment[]{
                new NumbersFragment(),
                new FamilyFragment(),
                new ColorsFragment(),
                new PhrasesFragment()};
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = getItem(position).getClass().getSimpleName();
        return title.subSequence(0, title.indexOf("Fragment"));
    }
}
