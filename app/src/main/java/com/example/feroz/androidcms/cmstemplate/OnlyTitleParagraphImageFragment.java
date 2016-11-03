package com.example.feroz.androidcms.cmstemplate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
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
import com.example.feroz.androidcms.animation.ExitAnimationUtility;
import com.example.feroz.androidcms.cmsslide.CMSSlide;
import com.example.feroz.androidcms.mediautility.ImageSaver;
import com.example.feroz.androidcms.viewPagerutility.OnSwipeTouchListener;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Feroz on 02-11-2016.
 */

public class OnlyTitleParagraphImageFragment extends Fragment {

    private TextView title, paragraph;
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

        View view = inflater.inflate(R.layout.only_title_paragraph_image, container, false);

        title = (TextView) view.findViewById(R.id.title);
        image = (ImageView) view.findViewById(R.id.image);
        main_layout = (LinearLayout) view.findViewById(R.id.main_layout);
        paragraph = (TextView) view.findViewById(R.id.paragraph);
        mPicasso = Picasso.with(getContext()); //Single instance
        title.setVisibility(View.GONE);
        if(!flag) {
            paragraph.setVisibility(View.GONE);

        }
        if (getArguments() != null) {
            if (getArguments().getSerializable("CMSSLIDE") != null) {
                cmsSlide = (CMSSlide) getArguments().getSerializable("CMSSLIDE");

            }
        }

        if (cmsSlide != null && cmsSlide.getTitle() != null) {
            title.setText(cmsSlide.getTitle());
        }


        if(flag) {
            title.setVisibility(View.VISIBLE);
        }
        imageUtility(cmsSlide, getContext(), image, mPicasso);



        if (cmsSlide != null && cmsSlide.getParagraph() != null) {
            paragraph.setText(cmsSlide.getParagraph());
        }

        main_layout.setOnTouchListener(new OnSwipeTouchListener(getContext()) {
            public void onSwipeTop() {
                System.out.println("top");
            }

            public void onSwipeRight() {
                System.out.println("right");
                if (paragraph.getVisibility() == View.VISIBLE) {
                    final Animation enter_from_right = AnimationUtils.loadAnimation(getContext(),
                            R.anim.exit_to_right);
                    enter_from_right.setDuration(700);
                    enter_from_right.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            paragraph.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    paragraph.startAnimation(enter_from_right);

                }
                 else if (title.getVisibility() == View.VISIBLE) {

                    title.startAnimation(new ExitAnimationUtility().getAnimation(500,0,getContext()));
                    title.setVisibility(View.GONE);
                } else {
                    MainActivity.previousViewpager();
                }
            }

            public void onSwipeLeft() {
                System.out.println("left");

                if (title.getVisibility() == View.GONE) {
                    title.setVisibility(View.VISIBLE);
                    title.startAnimation(new AnimateLayoutUtility().getAnimation(700,10,getContext()));

                }  else if (paragraph.getVisibility() == View.GONE) {
                    paragraph.setVisibility(View.VISIBLE);
                    final Animation enter_from_right = AnimationUtils.loadAnimation(getContext(),
                            R.anim.enter_from_right);
                    enter_from_right.setDuration(700);
                    paragraph.startAnimation(enter_from_right);

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

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                image.setAnimation(null);
            }
        }, 6000);

        return view;
    }

    void imageUtility(CMSSlide cmsSlide, Context context, ImageView image, Picasso mPicasso) {
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

            Animation anim =new AnimateLayoutUtility().getAnimation(6000,12,getContext());

            anim.setRepeatCount(Animation.INFINITE);




            image.startAnimation(anim);
            /*
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
                bitmap = null;
            }*/
        }
    }
}
