package com.daivp.hope;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class AnimUtil {

    public static AnimatorSet getAA(View view) {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.3f, 1f);
        animatorX.setDuration(2000);
        animatorX.setInterpolator(new DecelerateInterpolator());
        animatorX.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.3f, 1f);
        animatorY.setDuration(2000);
        animatorY.setInterpolator(new DecelerateInterpolator());
        animatorY.setRepeatCount(ValueAnimator.INFINITE);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(animatorX).with(animatorY);
        return animSet;
    }
}
