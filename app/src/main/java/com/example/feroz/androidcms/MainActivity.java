package com.example.feroz.androidcms;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.eftimoff.viewpagertransformers.BackgroundToForegroundTransformer;
import com.eftimoff.viewpagertransformers.CubeInTransformer;
import com.eftimoff.viewpagertransformers.DefaultTransformer;
import com.eftimoff.viewpagertransformers.DepthPageTransformer;
import com.eftimoff.viewpagertransformers.DrawFromBackTransformer;
import com.eftimoff.viewpagertransformers.FlipHorizontalTransformer;
import com.eftimoff.viewpagertransformers.FlipVerticalTransformer;
import com.eftimoff.viewpagertransformers.ForegroundToBackgroundTransformer;
import com.eftimoff.viewpagertransformers.RotateDownTransformer;
import com.eftimoff.viewpagertransformers.StackTransformer;
import com.eftimoff.viewpagertransformers.TabletTransformer;
import com.eftimoff.viewpagertransformers.ZoomInTransformer;
import com.eftimoff.viewpagertransformers.ZoomOutTranformer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ArrayList<Pojo> pojoArrayList;
    private ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager1234);
        pojoArrayList = new ArrayList<>();
        for(int i =0; i<14; i++){
            if(i==0){
                pojoArrayList.add(new Pojo("First","First Title","kkkkkk"));
            }
            if(i==1){
                pojoArrayList.add(new Pojo("Second","Second Title","kkkkkk"));

            }
            if(i==2){
                pojoArrayList.add(new Pojo("First","Third Titie","kkkkkk"));
            }
            if(i==3){
                pojoArrayList.add(new Pojo("Third","Third Titie","kkkkkk"));
            }
            if(i==4){
                pojoArrayList.add(new Pojo("Forth","Forth Titie","kkkkkk"));
            }
            if(i==5){
                pojoArrayList.add(new Pojo("Fifth","Fifth Titie","kkkkkk"));
            }
            if(i==6){
                pojoArrayList.add(new Pojo("Sixth","Sixth Titie","kkkkkk"));
            }
            if(i==7){
                pojoArrayList.add(new Pojo("Seventh","Seventh Titie","kkkkkk"));
            }
            if(i==8){
                pojoArrayList.add(new Pojo("Eighth","Eighth Titie","kkkkkk"));
            }
            if(i==9){
                pojoArrayList.add(new Pojo("Ninth","Ninth Titie","kkkkkk"));
            }
            if(i==10){
                pojoArrayList.add(new Pojo("Tenth","Tenth Titie","njnn"));
            }
            if(i==11){
                pojoArrayList.add(new Pojo("Eleventh","Eleventh Titie","kkkkkk"));
            }
            if(i==12){
                pojoArrayList.add(new Pojo("Twelth","Twelth Titie","kkkkkk"));
            }
            if(i==13){
                pojoArrayList.add(new Pojo("Thirteenth","Thirteenth Titie","kkkkkk"));
            }

        }
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),pojoArrayList);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position ==1){
                    //FlipHorizontalTransformer
                    viewPager.setPageTransformer(true, new BackgroundToForegroundTransformer());


                }else if(position == 2){
                    //ForegroundToBackgroundTransformer
                    viewPager.setPageTransformer(true, new CubeInTransformer());

                }else if(position == 3){
                    viewPager.setPageTransformer(true, new ForegroundToBackgroundTransformer());

                }else if(position == 4){
                    viewPager.setPageTransformer(true, new DefaultTransformer());

                }else if(position == 5){
                    viewPager.setPageTransformer(true, new DepthPageTransformer());

                }else if(position == 6){
                    viewPager.setPageTransformer(true, new DrawFromBackTransformer());

                }else if(position == 7){
                    viewPager.setPageTransformer(true, new FlipHorizontalTransformer());

                }else if(position == 8){
                    viewPager.setPageTransformer(true, new FlipVerticalTransformer());

                }
                else if(position == 9){
                    viewPager.setPageTransformer(true, new RotateDownTransformer());

                }else if(position == 10){
                    viewPager.setPageTransformer(true, new StackTransformer());

                }else if(position == 11){
                    viewPager.setPageTransformer(true, new TabletTransformer());

                }else if(position == 12){
                    viewPager.setPageTransformer(true, new ZoomInTransformer());

                }else{
                    viewPager.setPageTransformer(true, new ZoomOutTranformer());

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
