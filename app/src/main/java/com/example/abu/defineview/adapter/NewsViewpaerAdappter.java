package com.example.abu.defineview.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abu on 2017/10/16.
 */

public class NewsViewpaerAdappter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList = new ArrayList<>();

    private List<String> mTabNameList = new ArrayList<>();

    public NewsViewpaerAdappter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public NewsViewpaerAdappter(FragmentManager fm, List<String> tabNameList) {
        super(fm);
        mTabNameList = tabNameList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabNameList.get(position);
    }

    public void addFragment(Fragment fragment) {
        mFragmentList.add(fragment);
    }
}
