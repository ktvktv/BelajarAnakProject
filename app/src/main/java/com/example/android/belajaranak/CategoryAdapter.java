package com.example.android.belajaranak;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by User on 3/24/2018.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new AnimalFragment();
        }
        else if(position == 1){
            return new ColorFragment();
        }
        else if(position == 2){
            return new PlantFragment();
        }
        else {
            return new FamilyFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return mContext.getString(R.string.Animals);
        }
        else if(position == 1){
            return mContext.getString(R.string.Colors);
        }
        else if(position == 2){
            return mContext.getString(R.string.Plants);
        }
        else {
            return mContext.getString(R.string.Families);
        }
    }
}
