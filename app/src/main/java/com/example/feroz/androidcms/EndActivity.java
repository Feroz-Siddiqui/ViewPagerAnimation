package com.example.feroz.androidcms;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.feroz.androidcms.cmsslide.CMSSlide;
import com.example.feroz.androidcms.cmsslide.Presentation;
import com.example.feroz.androidcms.viewpagerutility.LockableViewPager;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class EndActivity extends AppCompatActivity {
    private Button submit;
    private  LockableViewPager viewPager;
    private ArrayList<CMSSlide> cmsSlides;
    private ViewPagerAdapter viewPagerAdapter;
    static private int currentPage =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        submit = (Button) findViewById(R.id.submit);
        viewPager = (LockableViewPager) findViewById(R.id.viewPager1);
        try {
            Serializer serializer = new Persister();

            Presentation s =serializer.read(Presentation.class,  getAssets().open("root.xml"));
            cmsSlides = s.getCmslide();

        }catch(Exception e){
            e.printStackTrace();

        }
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),cmsSlides);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setSwipeLocked(true);
        final Handler handler = new Handler();

        final Runnable update = new Runnable() {
            public void run() {
                if (viewPager.getCurrentItem() == (viewPager.getAdapter().getCount()-1)) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };


        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 100, 900);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(EndActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
