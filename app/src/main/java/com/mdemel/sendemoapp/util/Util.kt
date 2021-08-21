package com.mdemel.sendemoapp.util

import android.graphics.drawable.Animatable2
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import android.widget.ImageView
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat

class Util {

    public fun animate(v: Drawable) {
        val d: Drawable = v
        if (Build.VERSION.SDK_INT >= 21 && d is AnimatedVectorDrawable) {
            var avd = d as AnimatedVectorDrawable
            avd.start()
            avd.registerAnimationCallback()
        } else if (d is AnimatedVectorDrawableCompat) {
            var avd = d as AnimatedVectorDrawableCompat
            avd.start()
            avd.registerAnimationCallback()
        }
    }

    private fun Animatable2.registerAnimationCallback() {
        //ticketsViewModel.refreshData()
    }

    private fun Animatable2Compat.registerAnimationCallback() {
        //ticketsViewModel.refreshData()
    }

}