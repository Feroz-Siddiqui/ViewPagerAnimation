package com.example.feroz.androidcms;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.feroz.androidcms.viewPagerutility.OnSwipeTouchListener;

/**
 * Created by Feroz on 21-10-2016.
 */

public class SecondFragment  extends Fragment {
    public static final String EXTRA_POSITION = "EXTRA_POSITION";
    public static final String TITLE = "TITLE";
    public static final String SUBTITLE = "SUBTITLE";
    private TextView title;
    private TextView subtitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final int position = getArguments().getInt(EXTRA_POSITION);
        View view = inflater.inflate(R.layout.second_fragment,container,false);
        title = (TextView) view.findViewById(R.id.title);
        subtitle = (TextView) view.findViewById(R.id.subtitle);


        if(getArguments().getString(TITLE) != null){
            title.setText(getArguments().getString(TITLE));
        }

        if(getArguments().getString(SUBTITLE) != null){
            subtitle.setText(getArguments().getString(SUBTITLE));
        }

       final RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.ggg);


        relativeLayout.setOnTouchListener(new OnSwipeTouchListener(getContext()) {
            public void onSwipeTop() {
                System.out.println("top");
            }
            public void onSwipeRight() {
                MainActivity.previousViewpager();
                System.out.println("right");
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


        System.out.println("SecondFragment ");
        return  view;
    }
}