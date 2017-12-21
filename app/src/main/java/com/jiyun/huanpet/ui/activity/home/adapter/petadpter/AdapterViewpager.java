package com.jiyun.huanpet.ui.activity.home.adapter.petadpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2017/12/18.
 */

public class AdapterViewpager extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
    private ArrayList<String> mTilte;
    public AdapterViewpager(FragmentManager fm,ArrayList<Fragment> fragments,ArrayList<String> mTilte) {
        super(fm);
        this.fragments=fragments;
        this.mTilte=mTilte;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTilte.get(position);
    }
}
