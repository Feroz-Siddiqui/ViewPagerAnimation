package com.example.feroz.androidcms.cmstemplate;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.feroz.androidcms.R;

import java.util.Random;

/**
 * Created by Feroz on 02-11-2016.
 */

public class AnimateLayoutUtility {
    public Context context;
    public Boolean randomAnimation;

    public AnimateLayoutUtility() {
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
        int High = 26;
        int result = r.nextInt(High-Low) + Low;
        return result;
    }
    private Integer createRandomAnimationResource(Integer specificAnimationNumber) {

        switch (specificAnimationNumber) {
            case 1:
                return R.anim.enter_from_right;
            case 2:
                return R.anim.exit_to_right;
            case 3:
                return R.anim.floating_button_slide_up;
            case 4:
                return R.anim.slide_down;
            case 5:
                return R.anim.slide_right_in;
            case 6:
                return R.anim.slide_up;
            case 7:
                return R.anim.fade_in;
            case 8:
                return R.anim.fade_out;
            case 9:
                return R.anim.blink;
            case 10:
                return R.anim.zoom_in;
            case 11:
                return R.anim.zoom_out;
            case 12:
                return R.anim.rotate;
            case 13:
                return R.anim.bounce;
            case 14:
                return R.anim.rotate_center;
            case 15:
                return R.anim.rotate_corner;
            case 16:
                return R.anim.hyperspace_in;
            case 17:
                return R.anim.hyperspace_out;
            case 18:
                return R.anim.push_left_in;
            case 19:
                return R.anim.push_left_out;
            case 20:
                return R.anim.push_up_in;
            case 21:
                return R.anim.push_up_out;
            case 22:
                return R.anim.bounce_up;
            case 23:
                return R.anim.move;
            case 24:
                return R.anim.sequential;
            case 25:
                return R.anim.together;
            case 26:
                return R.anim.enter_from_left;

        }
        return R.anim.enter_from_left;
    }

}
