package com.example.feroz.androidcms;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
    private TextView subtitle;
    private RelativeLayout relativeLayout;
    private float oldTouchValue;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final int position = getArguments().getInt(EXTRA_POSITION);
        View view = inflater.inflate(R.layout.first_fragment,container,false);
        title = (TextView) view.findViewById(R.id.title);
        subtitle = (TextView) view.findViewById(R.id.subtitle);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.ggg);


        if(getArguments().getString(TITLE) != null){
            title.setText(getArguments().getString(TITLE));
        }
        relativeLayout.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction())

                {
                    case MotionEvent.ACTION_DOWN: {
                        oldTouchValue = event.getX();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        float currentX = event.getX();
                        if (oldTouchValue < currentX) {
                            // swiped left
                            subtitle.setVisibility(View.GONE);


                        }
                        if (oldTouchValue > currentX) {
                            if(getArguments().getString(SUBTITLE) != null){
                                subtitle.setVisibility(View.VISIBLE);
                                subtitle.setText(getArguments().getString(SUBTITLE));
                            }
                            // swiped right
                        }
                        break;
                    }
                }
                System.out.println("TOuch ");
                return false;
            }
        });


        System.out.println("FirstFragment ");
        return  view;
    }
}
