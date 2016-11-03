package com.example.feroz.androidcms.cmstemplate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.feroz.androidcms.MainActivity;
import com.example.feroz.androidcms.R;
import com.example.feroz.androidcms.cmsslide.CMSSlide;
import com.example.feroz.androidcms.mediautility.ImageSaver;
import com.example.feroz.androidcms.viewPagerutility.OnSwipeTouchListener;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.URL;

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

        imageUtility(cmsSlide, getContext(), main_layout, mPicasso);

        if (cmsSlide != null && cmsSlide.getTitle() != null) {
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

    void imageUtility(CMSSlide cmsSlide, Context context, CustomLayout main_layout, Picasso mPicasso) {
        Bitmap bitmap;
        if (cmsSlide != null && cmsSlide.getImage().getUrl() != null) {
            int index = cmsSlide.getImage().getUrl().lastIndexOf("/");
            String bg_image_name = cmsSlide.getImage().getUrl().substring(index, cmsSlide.getImage().getUrl().length()).replace("/", "");
            System.out.println("bg_image_name bg_image_name bg_image_name:::: " + bg_image_name);

            //file readable to external or not
            Boolean externalReadable = new ImageSaver(context).isExternalStorageReadable();
            Boolean externalWritable = new ImageSaver(context).isExternalStorageWritable();

            //file already exist or not
            Boolean file_exist = new ImageSaver(context).
                    setFileName(bg_image_name).
                    setExternal(externalReadable).
                    checkFile();
            System.out.println("External storage : " + externalReadable + "\nfile_exist :" + file_exist);

            if (file_exist) {
                bitmap = new ImageSaver(context).
                        setFileName(bg_image_name).
                        setExternal(externalReadable).
                        load();
                BitmapDrawable background = new BitmapDrawable(bitmap);
                main_layout.setBackgroundDrawable(background);
            } else {
                mPicasso.load(cmsSlide.getImage().getUrl()).into(main_layout);

                StrictMode.ThreadPolicy policy =
                        new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                bitmap = null;

                try {
                    URL url = new URL(this.cmsSlide.getImage().getUrl());
                    bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                } catch (IOException e) {
                    System.out.println(e);
                }

                if (bitmap != null) {
                    new ImageSaver(context).
                            setFileName(bg_image_name).
                            setExternal(externalWritable).
                            save(bitmap);
                    bitmap.recycle();
                }
            }

            /*if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
                bitmap = null;
            }*/
        }
    }

}
