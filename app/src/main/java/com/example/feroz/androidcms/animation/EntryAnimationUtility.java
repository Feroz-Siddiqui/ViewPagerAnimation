package com.example.feroz.androidcms.animation;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.feroz.androidcms.R;

import java.util.Random;

/**
 * Created by Feroz on 03-11-2016.
 */

public class EntryAnimationUtility {

    public EntryAnimationUtility(){

    }

    public Animation getAnimation(Integer duration, Integer specificAnimationNumber, Context context) {

        Integer res;

        if (specificAnimationNumber == 0) {
            res = createRandomAnimationResource(getRandomNumber());
        }else{
            res = createRandomAnimationResource(specificAnimationNumber);
        }

        final Animation animation = AnimationUtils.loadAnimation(context, res);
        animation.setDuration(duration);
        return animation;
    }

    public int getRandomNumber(){
        Random r = new Random();
        int Low = 1;
        int High = 16;
        int result = r.nextInt(High-Low) + Low;
        //System.out.println("------------------> result "+result);
        return result;
    }
    private Integer createRandomAnimationResource(Integer specificAnimationNumber) {

        switch (specificAnimationNumber) {
            case 1:
                return R.anim.enter_from_right;
            case 2:
                return R.anim.enter_from_left;
            case 3:
                return R.anim.floating_button_slide_up;
            case 4:
                return R.anim.slide_right_in;
            case 5:
                return R.anim.slide_up;
            case 6:
                return R.anim.fade_in;
            case 7:
                return R.anim.blink;
            case 8:
                return R.anim.zoom_in;
            case 9:
                return R.anim.rotate;
            case 10:
                return R.anim.bounce;
            case 11:
                return R.anim.rotate_center;
            case 12:
                return R.anim.rotate_corner;
            case 13:
                return R.anim.hyperspace_in;
            case 14:
                return R.anim.push_left_in;
            case 15:
                return R.anim.push_up_in;
            case 16:
                return R.anim.bounce_up;
        }
        return R.anim.enter_from_left;
    }
}
