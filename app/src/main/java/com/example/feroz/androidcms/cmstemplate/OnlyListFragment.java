package com.example.feroz.androidcms.cmstemplate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.BulletSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.feroz.androidcms.MainActivity;
import com.example.feroz.androidcms.R;
import com.example.feroz.androidcms.animation.EntryAnimationUtility;
import com.example.feroz.androidcms.animation.ExitAnimationUtility;
import com.example.feroz.androidcms.cmsslide.CMSSlide;
import com.example.feroz.androidcms.cmsslide.CMSTextItem;
import com.example.feroz.androidcms.viewPagerutility.OnSwipeTouchListener;
import com.squareup.picasso.Picasso;

/**
 * Created by Feroz on 02-11-2016.
 */

public class OnlyListFragment extends Fragment {
    private Picasso mPicasso;
    private CMSSlide cmsSlide;
    private ImageView imageView;
    private CustomLayout main_layout;
    private TextView list_item_text_1,list_item_text_2,list_item_text_3,list_item_text_4,list_item_text_5,list_item_text_6;
    int i=0;

    private boolean flag;
    @Override
    public   void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            flag =true;
        }else{
            flag = false;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.only_list, container, false);
        i=0;
        imageView = (ImageView) view.findViewById(R.id.image);
        main_layout = (CustomLayout) view.findViewById(R.id.main_layout);
        mPicasso = Picasso.with(getContext()); //Single instance
        list_item_text_1 = (TextView) view.findViewById(R.id.list_item_text_1);
        list_item_text_2 = (TextView) view.findViewById(R.id.list_item_text_2);
        list_item_text_3 = (TextView) view.findViewById(R.id.list_item_text_3);
        list_item_text_4 = (TextView) view.findViewById(R.id.list_item_text_4);
        list_item_text_5 = (TextView) view.findViewById(R.id.list_item_text_5);
        list_item_text_6 = (TextView) view.findViewById(R.id.list_item_text_6);

        list_item_text_1.setVisibility(View.GONE);
        list_item_text_2.setVisibility(View.GONE);
        list_item_text_3.setVisibility(View.GONE);
        list_item_text_4.setVisibility(View.GONE);
        list_item_text_5.setVisibility(View.GONE);
        list_item_text_6.setVisibility(View.GONE);

        if (getArguments() != null) {
            if (getArguments().getSerializable("CMSSLIDE") != null) {
                cmsSlide = (CMSSlide) getArguments().getSerializable("CMSSLIDE");

            }
        }


        if(cmsSlide != null && cmsSlide.getList() != null && cmsSlide.getList().getItems() != null  ) {
            for(CMSTextItem cmsTextItem:cmsSlide.getList().getItems()){
                if(cmsTextItem.getText() != null){
                    i++;

                    fillData(cmsTextItem.getText(),i);
                }
            }
            System.out.println("count is is "+i);
                if(flag){
                    list_item_text_1.setVisibility(View.VISIBLE);
                    list_item_text_2.setVisibility(View.VISIBLE);
                    list_item_text_3.setVisibility(View.VISIBLE);
                    list_item_text_4.setVisibility(View.VISIBLE);
                    list_item_text_5.setVisibility(View.VISIBLE);
                    list_item_text_6.setVisibility(View.VISIBLE);

                }

        }else{


        }

        main_layout.setOnTouchListener(new OnSwipeTouchListener(getContext()) {
            public void onSwipeTop() {
                System.out.println("top");
            }

            public void onSwipeRight() {
                System.out.println("right");

                if(i !=0){
                    checkRightSwipingListItem(i);
                }else {
                    MainActivity.previousViewpager();
                }
            }

            public void onSwipeLeft() {
                System.out.println("left");
                if(i !=0){
                    checkLeftSwipingListItem(i);


                }else{
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



    private void fillData(String text, int i) {

        SpannableString spannable = new SpannableString(text);
        spannable.setSpan(new BulletSpan(16), 0, text.length(), 0);

        if(i ==1){
            list_item_text_1.setText(spannable);
        }else if(i==2){
            list_item_text_2.setText(spannable);

        }else if(i==3){
            list_item_text_3.setText(spannable);

        }else if(i==4){
            list_item_text_4.setText(spannable);

        }else if(i==5){
            list_item_text_5.setText(spannable);

        }else {
            list_item_text_6.setText(spannable);

        }
    }


    private void checkLeftSwipingListItem(int i) {
        if (i == 1) {
            if (list_item_text_1.getVisibility() == View.GONE) {
                fadeIn(list_item_text_1);
            } else {
                MainActivity.nextViewpager();
            }
        } else if (i == 2) {
            if (list_item_text_1.getVisibility() == View.GONE) {
                fadeIn(list_item_text_1);
            } else if (list_item_text_2.getVisibility() == View.GONE) {
                fadeIn(list_item_text_2);
            } else {
                MainActivity.nextViewpager();
            }
        } else if (i == 3) {
            if (list_item_text_1.getVisibility() == View.GONE) {
                fadeIn(list_item_text_1);
            } else if (list_item_text_2.getVisibility() == View.GONE) {
                fadeIn(list_item_text_2);
            } else if (list_item_text_3.getVisibility() == View.GONE) {
                fadeIn(list_item_text_3);
            } else {
                MainActivity.nextViewpager();
            }
        } else if (i == 4) {
            if (list_item_text_1.getVisibility() == View.GONE) {
                fadeIn(list_item_text_1);
            } else if (list_item_text_2.getVisibility() == View.GONE) {
                fadeIn(list_item_text_2);
            } else if (list_item_text_3.getVisibility() == View.GONE) {
                fadeIn(list_item_text_3);
            } else if (list_item_text_4.getVisibility() == View.GONE) {
                fadeIn(list_item_text_4);
            } else {
                MainActivity.nextViewpager();
            }
        } else if (i == 5) {
            if (list_item_text_1.getVisibility() == View.GONE) {
                fadeIn(list_item_text_1);
            } else if (list_item_text_2.getVisibility() == View.GONE) {
                fadeIn(list_item_text_2);
            } else if (list_item_text_3.getVisibility() == View.GONE) {
                fadeIn(list_item_text_3);
            } else if (list_item_text_4.getVisibility() == View.GONE) {
                fadeIn(list_item_text_4);
            } else if (list_item_text_5.getVisibility() == View.GONE) {
                fadeIn(list_item_text_5);
            } else {
                MainActivity.nextViewpager();
            }
        } else {
            if (list_item_text_1.getVisibility() == View.GONE) {
                fadeIn(list_item_text_1);
            } else if (list_item_text_2.getVisibility() == View.GONE) {
                fadeIn(list_item_text_2);
            } else if (list_item_text_3.getVisibility() == View.GONE) {
                fadeIn(list_item_text_3);
            } else if (list_item_text_4.getVisibility() == View.GONE) {
                fadeIn(list_item_text_4);
            } else if (list_item_text_5.getVisibility() == View.GONE) {
                fadeIn(list_item_text_5);
            } else if (list_item_text_6.getVisibility() == View.GONE) {
                fadeIn(list_item_text_6);
            } else {
                MainActivity.nextViewpager();
            }
        }


    }


    private void checkRightSwipingListItem(int i) {
        if (i == 1) {
            if (list_item_text_1.getVisibility() == View.VISIBLE) {
                fadeOut(list_item_text_1);
            } else {
                MainActivity.previousViewpager();
            }
        } else if (i == 2) {
            if (list_item_text_2.getVisibility() == View.VISIBLE) {
                fadeOut(list_item_text_2);
            } else if (list_item_text_1.getVisibility() == View.VISIBLE) {
                fadeOut(list_item_text_1);
            } else {
                MainActivity.previousViewpager();
            }
        } else if (i == 3) {
            if (list_item_text_3.getVisibility() == View.VISIBLE) {
                fadeOut(list_item_text_3);
            } else if (list_item_text_2.getVisibility() == View.VISIBLE) {
                fadeOut(list_item_text_2);
            } else if (list_item_text_1.getVisibility() == View.VISIBLE) {
                fadeOut(list_item_text_1);
            } else {
                MainActivity.previousViewpager();
            }
        } else if (i == 4) {
            if (list_item_text_4.getVisibility() == View.VISIBLE) {
                fadeOut(list_item_text_4);
            } else if (list_item_text_3.getVisibility() == View.VISIBLE) {
                fadeOut(list_item_text_3);
            } else if (list_item_text_2.getVisibility() == View.VISIBLE) {
                fadeOut(list_item_text_2);
            } else if (list_item_text_1.getVisibility() == View.VISIBLE) {
                fadeOut(list_item_text_1);
            } else {
                MainActivity.previousViewpager();
            }
        } else if (i == 5) {
            if (list_item_text_5.getVisibility() == View.VISIBLE) {
                fadeOut(list_item_text_5);
            } else if (list_item_text_4.getVisibility() == View.VISIBLE) {
                fadeOut(list_item_text_4);
            } else if (list_item_text_3.getVisibility() == View.VISIBLE) {
                fadeOut(list_item_text_3);
            } else if (list_item_text_2.getVisibility() == View.VISIBLE) {
                fadeOut(list_item_text_2);
            } else if (list_item_text_1.getVisibility() == View.VISIBLE) {
                fadeOut(list_item_text_1);
            } else {
                MainActivity.previousViewpager();
            }
        } else {
            if (list_item_text_6.getVisibility() == View.VISIBLE) {
                fadeOut(list_item_text_6);

            } else if (list_item_text_5.getVisibility() == View.VISIBLE) {
                fadeOut(list_item_text_5);
            } else if (list_item_text_4.getVisibility() == View.VISIBLE) {
                fadeOut(list_item_text_4);
            } else if (list_item_text_3.getVisibility() == View.VISIBLE) {
                fadeOut(list_item_text_3);
            } else if (list_item_text_2.getVisibility() == View.VISIBLE) {
                fadeOut(list_item_text_2);
            } else if (list_item_text_1.getVisibility() == View.VISIBLE) {
                fadeOut(list_item_text_1);
            } else {
                MainActivity.previousViewpager();
            }
        }


    }




    public void fadeOut(final TextView tx) {
        Animation fadeout = new ExitAnimationUtility().getAnimation(500, 0, getContext());
        fadeout.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                tx.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        tx.startAnimation(fadeout);

    }

    public void fadeIn(final TextView tx) {
        tx.setVisibility(View.VISIBLE);
        Animation fadeout = new EntryAnimationUtility().getAnimation(500, 0, getContext());
        fadeout.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        tx.startAnimation(fadeout);
    }

}

