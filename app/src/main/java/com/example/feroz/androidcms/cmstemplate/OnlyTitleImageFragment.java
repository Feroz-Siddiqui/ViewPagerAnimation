package com.example.feroz.androidcms.cmstemplate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.feroz.androidcms.MainActivity;
import com.example.feroz.androidcms.R;
import com.example.feroz.androidcms.cmsslide.CMSSlide;
import com.squareup.picasso.Picasso;

/**
 * Created by Feroz on 02-11-2016.
 */

public class OnlyTitleImageFragment extends Fragment {

    private TextView title;
    private ImageView image;
    private Picasso mPicasso;
    private CMSSlide cmsSlide;
    private LinearLayout main_layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.only_title_image, container, false);
        title = (TextView) view.findViewById(R.id.title);
        image = (ImageView) view.findViewById(R.id.image);
        main_layout = (LinearLayout) view.findViewById(R.id.main_layout);
        mPicasso = Picasso.with(getContext()); //Single instance

        if (getArguments() != null) {
            if (getArguments().getSerializable("CMSSLIDE") != null) {
                cmsSlide = (CMSSlide) getArguments().getSerializable("CMSSLIDE");

            }
        }

        if(cmsSlide != null && cmsSlide.getTitle() != null ){
            title.setText(cmsSlide.getTitle());
        }
        if(cmsSlide != null && cmsSlide.getImage().getUrl() != null){

            mPicasso.load("http://api.talentify.in"+cmsSlide.getImage().getUrl()).into(image, new com.squareup.picasso.Callback() {
                @Override
                public void onSuccess() {
                image.setVisibility(View.GONE);
                }

                @Override
                public void onError() {

                }
            });
        }


        main_layout.setOnTouchListener(new OnSwipeTouchListener(getContext()) {
            public void onSwipeTop() {
                System.out.println("top");
            }

            public void onSwipeRight() {
                System.out.println("right");
                if(image.getVisibility() == View.VISIBLE) {
                    final Animation slide_down = AnimationUtils.loadAnimation(getContext(),
                            R.anim.exit_to_left);
                    slide_down.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                        image.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    slide_down.setDuration(300);
                    image.startAnimation(slide_down);
                }else {
                    MainActivity.previousViewpager();
                }
            }

            public void onSwipeLeft() {
                System.out.println("left");

                if(image.getVisibility() == View.GONE){
                 image.setVisibility(View.VISIBLE);
                    final Animation slide_down = AnimationUtils.loadAnimation(getContext(),
                            R.anim.enter_from_left);
                    slide_down.setDuration(700);
                    image.startAnimation(slide_down);

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
