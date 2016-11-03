package com.example.feroz.androidcms.cmstemplate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.feroz.androidcms.MainActivity;
import com.example.feroz.androidcms.R;
import com.example.feroz.androidcms.cmsslide.CMSSlide;
import com.example.feroz.androidcms.viewpagerutility.OnSwipeTouchListener;
import com.squareup.picasso.Picasso;

/**
 * Created by Feroz on 02-11-2016.
 */

public class TwoTitleFragment extends Fragment {

    private TextView title,subtitle;
    private Picasso mPicasso;
    private CMSSlide cmsSlide;
    private RelativeLayout main_layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.two_title, container, false);
        title = (TextView) view.findViewById(R.id.title);
        subtitle = (TextView) view.findViewById(R.id.sub_title);
        main_layout = (RelativeLayout) view.findViewById(R.id.main_layout);
        subtitle.setVisibility(View.GONE);
        mPicasso = Picasso.with(getContext()); //Single instance
        if (getArguments() != null) {
            if (getArguments().getSerializable("CMSSLIDE") != null) {
                cmsSlide = (CMSSlide) getArguments().getSerializable("CMSSLIDE");
            }
        }

        if(cmsSlide != null && cmsSlide.getTitle() != null ){
            title.setText(cmsSlide.getTitle());
        }

        if(cmsSlide != null && cmsSlide.getTitle2() != null ){
            subtitle.setText(cmsSlide.getTitle2());
        }
        main_layout.setOnTouchListener(new OnSwipeTouchListener(getContext()) {
            public void onSwipeTop() {
                System.out.println("top");
            }

            public void onSwipeRight() {
                System.out.println("right");
                if(subtitle.getVisibility() == View.VISIBLE) {
                    final Animation slide_down = AnimationUtils.loadAnimation(getContext(),
                            R.anim.exit_to_left);
                    slide_down.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            subtitle.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    slide_down.setDuration(300);
                    subtitle.startAnimation(slide_down);
                }else {
                    MainActivity.previousViewpager();
                }
            }

            public void onSwipeLeft() {
                System.out.println("left");

                if(subtitle.getVisibility() == View.GONE){
                    subtitle.setVisibility(View.VISIBLE);
                    final Animation slide_down = AnimationUtils.loadAnimation(getContext(),
                            R.anim.enter_from_left);
                    slide_down.setDuration(700);
                    subtitle.startAnimation(slide_down);

                }else {

                    MainActivity.nextViewpager();
                }

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
