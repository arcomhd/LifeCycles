package com.example.lifecycles;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    int numTab;
    public PagerAdapter(@NonNull FragmentManager fm, int numTab) {
        super(fm);
        this.numTab=numTab;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TabFragment1();
            case 1:
                return new TabFragment2();
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return numTab;
    }
}
