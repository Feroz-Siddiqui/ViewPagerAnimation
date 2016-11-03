package com.example.feroz.androidcms.animation;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.feroz.androidcms.R;

import java.util.Random;

/**
 * Created by Feroz on 02-11-2016.
 */

public class ExitAnimationUtility {
    public Context context;

    public ExitAnimationUtility() {
    }


    public Animation getAnimation(Integer duration, Integer specificAnimationNumber,Context context) {

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
        int High = 8;
        int result = r.nextInt(High-Low) + Low;
        //System.out.println("------------------> result "+result);
        return result;
    }
    private Integer createRandomAnimationResource(Integer specificAnimationNumber) {

        switch (specificAnimationNumber) {
            case 1:
                return R.anim.exit_to_right;
            case 2:
                return R.anim.slide_down;
            case 3:
                return R.anim.fade_out;
            case 4:
                return R.anim.zoom_out;
            case 5:
                return R.anim.hyperspace_out;
            case 6:
                return R.anim.push_left_out;
            case 7:
                return R.anim.push_up_out;
            case 8:
                return R.anim.move;
        }
        return R.anim.exit_to_right;
    }
}
