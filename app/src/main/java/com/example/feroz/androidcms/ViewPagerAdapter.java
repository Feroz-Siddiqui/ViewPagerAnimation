package com.example.feroz.androidcms;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Feroz on 21-10-2016.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Pojo> pojoArrayList;
    public ViewPagerAdapter(android.support.v4.app.FragmentManager fm,ArrayList<Pojo> pojoArrayList) {
        super(fm);
        this.pojoArrayList = pojoArrayList;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        final Bundle bundle = new Bundle();


        bundle.putInt(FirstFragment.EXTRA_POSITION, position );

        if(pojoArrayList.get(position).getName().equalsIgnoreCase("First")){
            fragment = new FirstFragment();
            bundle.putString(FirstFragment.TITLE, pojoArrayList.get(position).getTitle() );
            bundle.putString(FirstFragment.SUBTITLE, pojoArrayList.get(position).getSubtitle() );

        }

        if(pojoArrayList.get(position).getName().equalsIgnoreCase("Second")){
            fragment = new SecondFragment();
            bundle.putString(SecondFragment.TITLE, pojoArrayList.get(position).getTitle() );
            bundle.putString(SecondFragment.SUBTITLE, pojoArrayList.get(position).getSubtitle() );

        }

        if(pojoArrayList.get(position).getName().equalsIgnoreCase("Third")){
            fragment = new ThirdFragment();
            bundle.putString(ThirdFragment.TITLE, pojoArrayList.get(position).getTitle() );
            bundle.putString(ThirdFragment.SUBTITLE, pojoArrayList.get(position).getSubtitle() );

        }

        if(pojoArrayList.get(position).getName().equalsIgnoreCase("Forth")){
            fragment = new ForthFragment();
            bundle.putString(ForthFragment.TITLE, pojoArrayList.get(position).getTitle() );
            bundle.putString(ForthFragment.SUBTITLE, pojoArrayList.get(position).getSubtitle() );

        }

        if(pojoArrayList.get(position).getName().equalsIgnoreCase("Fifth")){
            fragment = new FifthFragment();
            bundle.putString(FifthFragment.TITLE, pojoArrayList.get(position).getTitle() );
            bundle.putString(FifthFragment.SUBTITLE, pojoArrayList.get(position).getSubtitle() );

        }

        if(pojoArrayList.get(position).getName().equalsIgnoreCase("Sixth")){
            fragment = new SixthFragment();
            bundle.putString(SixthFragment.TITLE, pojoArrayList.get(position).getTitle() );
            bundle.putString(SixthFragment.SUBTITLE, pojoArrayList.get(position).getSubtitle() );

        }

        if(pojoArrayList.get(position).getName().equalsIgnoreCase("Seventh")){
            fragment = new SeventhFragment();
            bundle.putString(SeventhFragment.TITLE, pojoArrayList.get(position).getTitle() );
            bundle.putString(SeventhFragment.SUBTITLE, pojoArrayList.get(position).getSubtitle() );

        }

        if(pojoArrayList.get(position).getName().equalsIgnoreCase("Eighth")){
            fragment = new EighthFragment();
            bundle.putString(EighthFragment.TITLE, pojoArrayList.get(position).getTitle() );
            bundle.putString(EighthFragment.SUBTITLE, pojoArrayList.get(position).getSubtitle() );

        }

        if(pojoArrayList.get(position).getName().equalsIgnoreCase("Ninth")){
            fragment = new NinthFragment();
            bundle.putString(NinthFragment.TITLE, pojoArrayList.get(position).getTitle() );
            bundle.putString(NinthFragment.SUBTITLE, pojoArrayList.get(position).getSubtitle() );

        }

        if(pojoArrayList.get(position).getName().equalsIgnoreCase("Tenth")){
            fragment = new TenthFragment();
            bundle.putString(TenthFragment.TITLE, pojoArrayList.get(position).getTitle() );
            bundle.putString(TenthFragment.SUBTITLE, pojoArrayList.get(position).getSubtitle() );

        }

        if(pojoArrayList.get(position).getName().equalsIgnoreCase("Eleventh")){
            fragment = new EleventhFragment();
            bundle.putString(EleventhFragment.TITLE, pojoArrayList.get(position).getTitle() );
            bundle.putString(EleventhFragment.SUBTITLE, pojoArrayList.get(position).getSubtitle() );

        }
        if(pojoArrayList.get(position).getName().equalsIgnoreCase("Twelth")){
            fragment = new TwelthFragment();
            bundle.putString(TwelthFragment.TITLE, pojoArrayList.get(position).getTitle() );
            bundle.putString(TwelthFragment.SUBTITLE, pojoArrayList.get(position).getSubtitle() );

        }
        if(pojoArrayList.get(position).getName().equalsIgnoreCase("Thirteenth")){
            fragment = new ThirteenthFragment();
            bundle.putString(ThirteenthFragment.TITLE, pojoArrayList.get(position).getTitle() );
            bundle.putString(ThirteenthFragment.SUBTITLE, pojoArrayList.get(position).getSubtitle() );

        }

        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return pojoArrayList.size();
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

}
