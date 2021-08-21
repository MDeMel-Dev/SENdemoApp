package com.mdemel.sendemoapp.util

import android.R
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.Animatable2
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import java.security.AccessController.getContext


class Util {

    // REFRESH BUTTON ANIMATION
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

    // FOR FUTURE REFERENCE INCASE OF THE NEED OF A CALL BACK
    private fun Animatable2.registerAnimationCallback() {
        //ticketsViewModel.refreshData()
    }

    private fun Animatable2Compat.registerAnimationCallback() {
        //ticketsViewModel.refreshData()
    }

    //ZOOM FUNCTION FOR QR CODE ON CLICK
    @SuppressLint("ClickableViewAccessibility")
    fun setZoomListener(v: View) {
            var uri: Uri? = null
            val builder = Dialog(v.context)
            builder.requestWindowFeature(Window.FEATURE_NO_TITLE)
            builder.getWindow()?.setBackgroundDrawable(
                ColorDrawable(Color.TRANSPARENT)
            )
            builder.setOnDismissListener(DialogInterface.OnDismissListener {
                //nothing;
            })

            uri = Uri.parse("android.resource://" + v.context.getPackageName() + "/drawable/senqr");
        val imageView = ImageView(v.context)
            imageView.setImageURI(uri) //set the image in dialog popup
            //below code fullfil the requirement of xml layout file for dialoge popup
            builder.addContentView(
                imageView, RelativeLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            )
            builder.show()
        }


    }