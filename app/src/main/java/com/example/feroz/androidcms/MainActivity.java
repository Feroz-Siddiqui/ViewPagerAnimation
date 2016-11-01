package com.example.feroz.androidcms;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;

import com.eftimoff.viewpagertransformers.BackgroundToForegroundTransformer;
import com.eftimoff.viewpagertransformers.DefaultTransformer;
import com.eftimoff.viewpagertransformers.DepthPageTransformer;
import com.eftimoff.viewpagertransformers.ForegroundToBackgroundTransformer;
import com.eftimoff.viewpagertransformers.RotateDownTransformer;
import com.eftimoff.viewpagertransformers.StackTransformer;
import com.eftimoff.viewpagertransformers.ZoomOutTranformer;
import com.example.feroz.androidcms.cmsslide.CMSSlide;
import com.example.feroz.androidcms.cmsslide.Presentation;
import com.example.feroz.androidcms.cmstemplate.FixedSpeedScroller;
import com.example.feroz.androidcms.cmstemplate.LockableViewPager;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static LockableViewPager viewPager;
    private ArrayList<CMSSlide> cmsSlides;
    private ViewPagerAdapter viewPagerAdapter;
    static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        int readexternalstoragepermission = ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.READ_EXTERNAL_STORAGE);
        if (readexternalstoragepermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        }
        context = this;

        getSupportActionBar().hide();
        int writeexternalstoragepermission = ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (writeexternalstoragepermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        }
        try {
            Serializer serializer = new Persister();

            Presentation s =serializer.read(Presentation.class,  getAssets().open("root.xml"));
            cmsSlides = s.getCmslide();

        }catch(Exception e){
            e.printStackTrace();

        }

        viewPager = (LockableViewPager) findViewById(R.id.viewPager1234);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),cmsSlides);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setViewPagerTransformation(getRandomNumber());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        try {
            Field mScroller;
            mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            Interpolator sInterpolator = new AccelerateInterpolator();

            FixedSpeedScroller scroller = new FixedSpeedScroller(viewPager.getContext(),  sInterpolator);
            // scroller.(5000);
            mScroller.set(viewPager, scroller);
        } catch (NoSuchFieldException e) {
        } catch (IllegalArgumentException e) {
        } catch (IllegalAccessException e) {
        }

        viewPager.setSwipeLocked(true);
       // viewPager.setOffscreenPageLimit(cmsSlides.size());


    }


   public static void nextViewpager() {
       if (viewPager.getCurrentItem() != (viewPager.getAdapter().getCount()-1)){
           viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);

       }
       else {
           if(context !=null) {
               Intent i = new Intent(context, EndActivity.class);
               context.startActivity(i);
           }
       }
   }

    public static void previousViewpager(){
        if(viewPager.getCurrentItem() !=0 )
            viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
    }


    public  void setViewPagerTransformation(int position){
        System.out.println("setViewPagerTransformation ... "+position);
        if(position ==1){
            //FlipHorizontalTransformer
            viewPager.setPageTransformer(true, new BackgroundToForegroundTransformer());


        }else if(position == 2){
            //ForegroundToBackgroundTransformer
            viewPager.setPageTransformer(true, new ForegroundToBackgroundTransformer());

        }else if(position == 3){
            viewPager.setPageTransformer(true, new ForegroundToBackgroundTransformer());

        }else if(position == 4){
            viewPager.setPageTransformer(true, new DefaultTransformer());

        }else if(position == 5){
            viewPager.setPageTransformer(true, new DepthPageTransformer());

        }else if(position == 6){
          //  viewPager.setPageTransformer(true, new DrawFromBackTransformer());
            viewPager.setPageTransformer(true, new StackTransformer());

        }else if(position == 7){
            //viewPager.setPageTransformer(true, new FlipHorizontalTransformer());
            viewPager.setPageTransformer(true, new ForegroundToBackgroundTransformer());

        }else if(position == 8){
           // viewPager.setPageTransformer(true, new FlipVerticalTransformer());
            viewPager.setPageTransformer(true, new DefaultTransformer());

        }
        else if(position == 9){
            viewPager.setPageTransformer(true, new RotateDownTransformer());

        }else if(position == 10){
            viewPager.setPageTransformer(true, new StackTransformer());

        }else if(position == 11){
            viewPager.setPageTransformer(true, new DefaultTransformer());

        }else if(position == 12){
            //viewPager.setPageTransformer(true, new ZoomInTransformer());
            viewPager.setPageTransformer(true, new ForegroundToBackgroundTransformer());

        }else{
            viewPager.setPageTransformer(true, new ZoomOutTranformer());

        }
    }

    public int getRandomNumber(){
        Random r = new Random();
        int Low = 1;
        int High = 13;
        int result = r.nextInt(High-Low) + Low;
        return result;
    }

}
