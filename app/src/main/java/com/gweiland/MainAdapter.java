package com.gweiland;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fragments;


    int[] imageList = {R.drawable.filter_icon, R.drawable.notification, R.drawable.settings};


    // Create constructor

    public MainAdapter(FragmentManager fm) {
        super(fm);
        this.fragments = new ArrayList<Fragment>();
        fragments.add(new Crypto_Fragment());
        fragments.add(new NFT_Fragment());
    }


    @Override
    public androidx.fragment.app.Fragment getItem(int position) {
        // return fragment position
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return "Crypto";
        } else {
            return "NFt";
        }
    }
}
