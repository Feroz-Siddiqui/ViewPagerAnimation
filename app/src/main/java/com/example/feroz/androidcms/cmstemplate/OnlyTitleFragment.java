package com.example.feroz.androidcms.cmstemplate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.feroz.androidcms.MainActivity;
import com.example.feroz.androidcms.R;
import com.example.feroz.androidcms.cmsslide.CMSSlide;
import com.squareup.picasso.Picasso;

/**
 * Created by Feroz on 31-10-2016.
 */

public class OnlyTitleFragment extends Fragment {
    private TextView title;
    private CMSSlide cmsSlide;
    private CustomLayout main_layout;
    private Picasso mPicasso;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.only_title, container, false);
        title = (TextView) view.findViewById(R.id.title);
        main_layout = (CustomLayout) view.findViewById(R.id.main_layout);
        mPicasso = Picasso.with(getContext()); //Single instance

        if (getArguments() != null) {
            if (getArguments().getSerializable("CMSSLIDE") != null) {
                cmsSlide = (CMSSlide) getArguments().getSerializable("CMSSLIDE");

            }
        }

        if(cmsSlide != null && cmsSlide.getImage().getUrl() != null){

            mPicasso.load(cmsSlide.getImage().getUrl()).into(main_layout);
        }


        if(cmsSlide != null && cmsSlide.getTitle() != null ){
            title.setText(cmsSlide.getTitle());
        }

        main_layout.setOnTouchListener(new OnSwipeTouchListener(getContext()) {
            public void onSwipeTop() {
                System.out.println("top");
            }

            public void onSwipeRight() {
                System.out.println("right");
                MainActivity.previousViewpager();

            }

            public void onSwipeLeft() {
                System.out.println("left");
                MainActivity.nextViewpager();


            }

            public void onSwipeBottom() {
                System.out.println("bottom");
            }

            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });


        return view;
    }
}
