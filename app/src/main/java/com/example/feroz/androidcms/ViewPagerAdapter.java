package com.example.feroz.androidcms;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.example.feroz.androidcms.cmsslide.CMSSlide;
import com.example.feroz.androidcms.cmstemplate.NoContentFragment;
import com.example.feroz.androidcms.cmstemplate.OnlyListFragment;
import com.example.feroz.androidcms.cmstemplate.OnlyParagraphImageFragment;
import com.example.feroz.androidcms.cmstemplate.OnlyTitleFragment;
import com.example.feroz.androidcms.cmstemplate.OnlyTitleImageFragment;
import com.example.feroz.androidcms.cmstemplate.OnlyTitleListFragment;
import com.example.feroz.androidcms.cmstemplate.OnlyTitleParagraphImageFragment;
import com.example.feroz.androidcms.cmstemplate.TwoTitleFragment;

import java.util.ArrayList;

/**
 * Created by Feroz on 21-10-2016.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<CMSSlide> cmsSlides;
    public ViewPagerAdapter(android.support.v4.app.FragmentManager fm,ArrayList<CMSSlide> cmsSlides) {
        super(fm);
        this.cmsSlides = cmsSlides;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        final Bundle bundle = new Bundle();


        bundle.putInt(FirstFragment.EXTRA_POSITION, position );
        bundle.putSerializable("CMSSLIDE",cmsSlides.get(position));

        if(cmsSlides.get(position).getTemplateName() != null){
            System.out.println("Templates name "+cmsSlides.get(position).getTemplateName());
            if(cmsSlides.get(position).getTemplateName().equalsIgnoreCase("ONLY_TITLE")){
                fragment = new OnlyTitleFragment();
            }else if(cmsSlides.get(position).getTemplateName().equalsIgnoreCase("NO_CONTENT")){
                fragment = new NoContentFragment();
            }else if(cmsSlides.get(position).getTemplateName().equalsIgnoreCase("ONLY_TITLE_LIST")){
                fragment = new OnlyTitleListFragment();
            }else if(cmsSlides.get(position).getTemplateName().equalsIgnoreCase("ONLY_LIST")){
                fragment = new OnlyListFragment();
            }else if(cmsSlides.get(position).getTemplateName().equalsIgnoreCase("ONLY_TITLE_IMAGE")){
                fragment = new OnlyTitleImageFragment();
            }else if(cmsSlides.get(position).getTemplateName().equalsIgnoreCase("ONLY_TITLE_PARAGRAPH_IMAGE")){
                fragment = new OnlyTitleParagraphImageFragment();
            }else if(cmsSlides.get(position).getTemplateName().equalsIgnoreCase("ONLY_PARAGRAPH_IMAGE")){
                fragment = new OnlyParagraphImageFragment();
            }else if(cmsSlides.get(position).getTemplateName().equalsIgnoreCase("ONLY_2TITLE")){
                fragment = new TwoTitleFragment();
            }
            else {
                fragment = new FirstFragment();
            }
        }else{
        fragment=new FirstFragment();
        }

        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return cmsSlides.size();
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
    }
}
