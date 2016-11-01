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

import com.example.feroz.androidcms.cmsslide.CMSSlide;
import com.example.feroz.androidcms.cmstemplate.OnSwipeTouchListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Created by Feroz on 21-10-2016.
 */

public class FirstFragment extends Fragment {
    public static final String EXTRA_POSITION = "EXTRA_POSITION";
    public static final String TITLE = "TITLE";
    public static final String SUBTITLE = "SUBTITLE";
    private TextView title;
    private TextView subtitle, subtitle1, subtitle2;
    private RelativeLayout relativeLayout;
    private float oldTouchValue;
    private ImageView imageView;
    private CMSSlide cmsSlide;
    private Picasso mPicasso;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final int position = getArguments().getInt(EXTRA_POSITION);
        View view = inflater.inflate(R.layout.first_fragment, container, false);
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
        mPicasso = Picasso.with(getContext()); //Single instance

        if (getArguments() != null) {
            if (getArguments().getSerializable("CMSSLIDE") != null) {
                cmsSlide = (CMSSlide) getArguments().getSerializable("CMSSLIDE");

            }
        }
        relativeLayout.setOnTouchListener(new OnSwipeTouchListener(getContext()) {
            public void onSwipeTop() {
                System.out.println("top");
            }

            public void onSwipeRight() {

                if (subtitle2.getVisibility() == View.VISIBLE) {
                    Animation slide_down = AnimationUtils.loadAnimation(getContext(),
                            R.anim.exit_to_left);
                    slide_down.setDuration(400);
                    subtitle2.startAnimation(slide_down);
                    subtitle2.setVisibility(View.GONE);

                } else if (subtitle1.getVisibility() == View.VISIBLE) {
                    Animation slide_down = AnimationUtils.loadAnimation(getContext(),
                            R.anim.exit_to_left);
                    slide_down.setDuration(400);
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
                } else if (imageView.getVisibility() == View.VISIBLE) {

                    Animation slide_down = AnimationUtils.loadAnimation(getContext(),
                            R.anim.slide_down);
                    slide_down.setDuration(400);
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
                } else if (subtitle.getVisibility() == View.VISIBLE) {
                    Animation slide_down = AnimationUtils.loadAnimation(getContext(),
                            R.anim.slide_down);
                    slide_down.setDuration(400);
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
                    subtitle.startAnimation(slide_down);
                } else {
                    MainActivity.previousViewpager();

                }
                System.out.println("right");
            }

            public void onSwipeLeft() {
                System.out.println("left");

                if (subtitle.getVisibility() == View.GONE) {
                    subtitle.setVisibility(View.VISIBLE);


                    if (cmsSlide != null && cmsSlide.getTemplateName() != null) {

                        subtitle.setText(cmsSlide.getTemplateName());
                        Animation slide_down = AnimationUtils.loadAnimation(getContext(),
                                R.anim.slide_up);
                        slide_down.setDuration(400);
                        subtitle.startAnimation(slide_down);
                    }

                } else if (imageView.getVisibility() == View.GONE) {

                    imageView.setVisibility(View.VISIBLE);


                    if (cmsSlide != null && cmsSlide.getImage().getUrl() != null) {

                        mPicasso.load("http://api.talentify.in/" + cmsSlide.getImage().getUrl())
                                .resize(200, 200).centerInside()
                                .error(getContext().getResources().getDrawable(R.mipmap.ic_business_black_48dp))
                                .placeholder(getContext().getResources().getDrawable(R.mipmap.ic_business_black_48dp)).into(imageView, new Callback() {
                            @Override
                            public void onSuccess() {
                                Animation slide_down = AnimationUtils.loadAnimation(getContext(),
                                        R.anim.enter_from_left);
                                slide_down.setDuration(400);
                                imageView.startAnimation(slide_down);
                            }

                            @Override
                            public void onError() {

                            }
                        });


                    }


                } else if (subtitle1.getVisibility() == View.GONE) {
                    subtitle1.setVisibility(View.VISIBLE);

                    if (cmsSlide != null && cmsSlide.getTitle() != null) {

                        subtitle1.setText(cmsSlide.getTitle());
                        Animation slide_down = AnimationUtils.loadAnimation(getContext(),
                                R.anim.enter_from_left);
                        slide_down.setDuration(400);
                        subtitle1.startAnimation(slide_down);
                    }

                } else if (subtitle2.getVisibility() == View.GONE) {
                    subtitle2.setVisibility(View.VISIBLE);

                    if (cmsSlide != null && cmsSlide.getTitle2() != null) {

                        subtitle2.setText(cmsSlide.getTitle2());
                        Animation slide_down = AnimationUtils.loadAnimation(getContext(),
                                R.anim.slide_right_in);
                        slide_down.setDuration(400);
                        subtitle2.startAnimation(slide_down);
                    }
                } else {
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


        System.out.println("FirstFragment ");
        return view;
    }
}
