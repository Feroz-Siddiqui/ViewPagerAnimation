package com.example.feroz.androidcms.cmstemplate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.feroz.androidcms.MainActivity;
import com.example.feroz.androidcms.R;
import com.example.feroz.androidcms.cmsslide.CMSSlide;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Feroz on 31-10-2016.
 */

public class NoContentFragment extends Fragment{
    private ImageView image;
    private Picasso mPicasso;
    private CMSSlide cmsSlide;
    private LinearLayout main_layout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.no_title, container, false);
        image = (ImageView) view.findViewById(R.id.image);
        main_layout = (LinearLayout) view.findViewById(R.id.main_layout);
        mPicasso = Picasso.with(getContext()); //Single instance



        if (getArguments() != null) {
            if (getArguments().getSerializable("CMSSLIDE") != null) {
                cmsSlide = (CMSSlide) getArguments().getSerializable("CMSSLIDE");

            }
        }
        /*if(cmsSlide != null && cmsSlide.getImage_BG() != null) {

           final  Animation slide_down = AnimationUtils.loadAnimation(getContext(),
                    R.anim.slide_up);
            slide_down.setDuration(700);
            mPicasso.load("http://api.talentify.in"+cmsSlide.getImage_BG()).into(image, new com.squareup.picasso.Callback() {
                @Override
                public void onSuccess() {
                    image.startAnimation(slide_down);

                }

                @Override
                public void onError() {

                }
            });

        }*/

        imageUtility(cmsSlide, getContext(), image, mPicasso);


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

    void imageUtility(CMSSlide cmsSlide, Context context, ImageView image, Picasso mPicasso) {

        if (cmsSlide != null && cmsSlide.getImage_BG() != null) {
            int index = cmsSlide.getImage_BG().lastIndexOf("/");
            String bg_image_name = cmsSlide.getImage_BG().substring(index, cmsSlide.getImage_BG().length()).replace("/", "");
            System.out.println("bg_image_name bg_image_name bg_image_name:::: " + bg_image_name);

            //file readable to external or not
            Boolean externalReadable = new ImageSaver(context).isExternalStorageReadable();
            Boolean externalWritable = new ImageSaver(context).isExternalStorageWritable();

            //file already exist or not
            Boolean file_exist = new ImageSaver(context).
                    setFileName(bg_image_name).
                    setExternal(externalReadable).
                    checkFile();
            System.out.println("External storage : "+externalReadable+"\nfile_exist :" + file_exist);

            if (file_exist) {
                Bitmap bitmap = new ImageSaver(context).
                        setFileName(bg_image_name).
                        setExternal(externalReadable).
                        load();
                image.setImageBitmap(bitmap);
            } else {
                mPicasso.load("http://api.talentify.in"+cmsSlide.getImage_BG()).into(image);

                StrictMode.ThreadPolicy policy =
                        new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                Bitmap bitmap = null;

                try {
                    URL url = new URL("http://api.talentify.in"+cmsSlide.getImage_BG());
                    bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                } catch (IOException e) {
                    System.out.println(e);
                }

                if (bitmap != null) {
                    new ImageSaver(context).
                            setFileName(bg_image_name).
                            setExternal(externalWritable).
                            save(bitmap);
                }
            }

        }
    }

}
