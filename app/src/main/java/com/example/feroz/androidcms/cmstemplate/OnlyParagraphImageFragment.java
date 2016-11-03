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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.feroz.androidcms.MainActivity;
import com.example.feroz.androidcms.R;
import com.example.feroz.androidcms.animation.AnimateLayoutUtility;
import com.example.feroz.androidcms.cmsslide.CMSSlide;
import com.example.feroz.androidcms.mediaUtility.ImageSaver;
import com.example.feroz.androidcms.viewPagerUtility.OnSwipeTouchListener;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Feroz on 02-11-2016.
 */

public class OnlyParagraphImageFragment  extends Fragment {

    private TextView title;
    private ImageView image;
    private Picasso mPicasso;
    private CMSSlide cmsSlide;
    private LinearLayout main_layout;
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

        View view = inflater.inflate(R.layout.only_paragraph_image, container, false);
        title = (TextView) view.findViewById(R.id.title);
        image = (ImageView) view.findViewById(R.id.image);
        main_layout = (LinearLayout) view.findViewById(R.id.main_layout);
        mPicasso = Picasso.with(getContext()); //Single instance

        if (getArguments() != null) {
            if (getArguments().getSerializable("CMSSLIDE") != null) {
                cmsSlide = (CMSSlide) getArguments().getSerializable("CMSSLIDE");

            }
        }

        if(cmsSlide !=null && cmsSlide.getParagraph() != null){
            title.setText(cmsSlide.getParagraph());
        }

        imageUtility(cmsSlide, getContext(), image, mPicasso);

        if(flag){
            image.setVisibility(View.VISIBLE);
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
                    image.startAnimation(new AnimateLayoutUtility().getAnimation(700,15,getContext()));

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

    void imageUtility(CMSSlide cmsSlide, Context context, ImageView image, Picasso mPicasso) {
        image.setVisibility(View.GONE);
        Bitmap bitmap;
        if (cmsSlide != null && cmsSlide.getImage() != null && cmsSlide.getImage().getUrl() != null) {
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
                image.setImageBitmap(bitmap);
            } else {
                mPicasso.load("http://api.talentify.in" + cmsSlide.getImage().getUrl()).into(image);

                StrictMode.ThreadPolicy policy =
                        new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                bitmap = null;

                try {
                    URL url = new URL("http://api.talentify.in" + cmsSlide.getImage().getUrl());
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
           /* if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
                bitmap = null;
            }*/

        }
    }
}
