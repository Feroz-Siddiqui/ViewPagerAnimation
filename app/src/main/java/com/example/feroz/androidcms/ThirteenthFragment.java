package com.example.feroz.androidcms;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Feroz on 21-10-2016.
 */

public class ThirteenthFragment extends Fragment {
    public static final String EXTRA_POSITION = "EXTRA_POSITION";
    public static final String TITLE = "TITLE";
    public static final String SUBTITLE = "SUBTITLE";
    private TextView title;
    private TextView subtitle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final int position = getArguments().getInt(EXTRA_POSITION);
        View view = inflater.inflate(R.layout.thirteenth_fragment,container,false);
        title = (TextView) view.findViewById(R.id.title);
        subtitle = (TextView) view.findViewById(R.id.subtitle);


        if(getArguments().getString(TITLE) != null){
            title.setText(getArguments().getString(TITLE));
        }

        if(getArguments().getString(SUBTITLE) != null){
            subtitle.setText(getArguments().getString(SUBTITLE));
        }

        System.out.println("FirstFragment ");
        return  view;
    }
}
