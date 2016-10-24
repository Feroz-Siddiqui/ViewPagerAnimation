package com.example.feroz.androidcms;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Feroz on 21-10-2016.
 */

public class FirstFragment  extends Fragment {
    public static final String EXTRA_POSITION = "EXTRA_POSITION";
    public static final String TITLE = "TITLE";
    public static final String SUBTITLE = "SUBTITLE";
    private TextView title;
    private TextView subtitle,subtitle1,subtitle2;
    private RelativeLayout relativeLayout;
    private float oldTouchValue;
    private ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final int position = getArguments().getInt(EXTRA_POSITION);
        View view = inflater.inflate(R.layout.first_fragment,container,false);
        title = (TextView) view.findViewById(R.id.title);
        subtitle = (TextView) view.findViewById(R.id.subtitle);
        subtitle1 = (TextView) view.findViewById(R.id.subtitle1);
        subtitle2 = (TextView) view.findViewById(R.id.subtitle2);
        imageView = (ImageView) view.findViewById(R.id.image);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.ggg);
        subtitle.setVisibility(View.GONE);
        subtitle1.setVisibility(View.GONE);
        subtitle2.setVisibility(View.GONE);
        imageView.setVisibility(View.GONE);
        if(getArguments().getString(TITLE) != null){
            title.setText(getArguments().getString(TITLE));
        }
        relativeLayout.setOnTouchListener(new OnSwipeTouchListener(getContext()) {
            public void onSwipeTop() {
                System.out.println("top");
            }
            public void onSwipeRight() {

                if(subtitle2.getVisibility() == View.VISIBLE) {
                    Animation slide_down = AnimationUtils.loadAnimation(getContext(),
                            R.anim.exit_to_left);
                    slide_down.setDuration(1000);
                    subtitle2.startAnimation(slide_down);
                    subtitle2.setVisibility(View.GONE);

                }else if(subtitle1.getVisibility() == View.VISIBLE) {
                    Animation slide_down = AnimationUtils.loadAnimation(getContext(),
                            R.anim.exit_to_left);
                    slide_down.setDuration(1000);
                    slide_down.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            subtitle1.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                    subtitle1.startAnimation(slide_down);
                }else if (imageView.getVisibility() == View.VISIBLE) {

                    Animation slide_down = AnimationUtils.loadAnimation(getContext(),
                            R.anim.slide_down);
                    slide_down.setDuration(1000);
                    slide_down.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            imageView.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                    imageView.startAnimation(slide_down);
                }
                else if (subtitle.getVisibility() == View.VISIBLE) {
                    Animation slide_down = AnimationUtils.loadAnimation(getContext(),
                            R.anim.slide_down);
                    slide_down.setDuration(1000);
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
                    subtitle.startAnimation(slide_down);                }
                System.out.println("right");
            }
            public void onSwipeLeft() {
                System.out.println("left");

                if(subtitle.getVisibility() == View.GONE) {
                    subtitle.setVisibility(View.VISIBLE);
                    if (getArguments().getString(SUBTITLE) != null) {

                        subtitle.setText(getArguments().getString(SUBTITLE));
                        Animation slide_down = AnimationUtils.loadAnimation(getContext(),
                                R.anim.slide_up);
                        slide_down.setDuration(1000);
                        subtitle.startAnimation(slide_down);
                    }
                }else if(imageView.getVisibility() == View.GONE){

                    Animation slide_down = AnimationUtils.loadAnimation(getContext(),
                            R.anim.enter_from_left);
                    slide_down.setDuration(1000);
                    imageView.setVisibility(View.VISIBLE);
                    imageView.startAnimation(slide_down);

                }
                else if(subtitle1.getVisibility() == View.GONE){
                    subtitle1.setVisibility(View.VISIBLE);
                    subtitle1.setText("this is subtitle 1");
                    Animation slide_down = AnimationUtils.loadAnimation(getContext(),
                            R.anim.enter_from_left);
                    slide_down.setDuration(1000);
                    subtitle1.startAnimation(slide_down);

                }else if(subtitle2.getVisibility() == View.GONE){
                    subtitle2.setVisibility(View.VISIBLE);
                    subtitle2.setText("this is subtitle 2");
                    Animation slide_down = AnimationUtils.loadAnimation(getContext(),
                            R.anim.slide_right_in);
                    slide_down.setDuration(1000);
                    subtitle2.startAnimation(slide_down);
                }else{
                    MainActivity.unlockViewPager();

                }

            }
            public void onSwipeBottom() {
                System.out.println("bottom");
            }

            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });


        System.out.println("FirstFragment ");
        return  view;
    }
}
