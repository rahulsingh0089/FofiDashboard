package com.fofidashboard.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.fofidashboard.fragment.AppsFragment;
import com.fofidashboard.fragment.EducationFragment;
import com.fofidashboard.fragment.FavouritesFragment;
import com.fofidashboard.fragment.GamesFragment;
import com.fofidashboard.fragment.HomeFragment;
import com.fofidashboard.fragment.MusicFragment;
import com.fofidashboard.fragment.NewsFragment;
import com.fofidashboard.fragment.RecordingsFragment;
import com.fofidashboard.fragment.TvFragment;
import com.fofidashboard.fragment.VodFragment;

/**
 * Created by prabhavathi on 3/11/17.
 */

public class PagerAdapter  extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;

            case 1:
                TvFragment tvFragment = new TvFragment();
                return tvFragment;
            case 2:
                VodFragment vodFragment = new VodFragment();
                return vodFragment;
            case 3:
                FavouritesFragment favouritesFragment = new FavouritesFragment();
                return favouritesFragment;
            case 4:
                MusicFragment musicFragment = new MusicFragment();
                return musicFragment;
            case 5:
                GamesFragment gamesFragment = new GamesFragment();
                return gamesFragment;
            case 6:
                NewsFragment newsFragment = new NewsFragment();
                return newsFragment;
            case 7:
                AppsFragment appsFragment = new AppsFragment();
                return appsFragment;
            case 8:
                EducationFragment educationFragment= new EducationFragment();
                return educationFragment;
            case 9:
                RecordingsFragment recordingsFragment = new RecordingsFragment();
                return recordingsFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}