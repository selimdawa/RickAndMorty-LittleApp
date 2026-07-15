package com.littleapp.rickandmorty.utils

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.littleapp.rickandmorty.R
import jp.wasabeef.glide.transformations.BlurTransformation

import androidx.preference.PreferenceManager

fun Context.applyAppTheme() {
    val prefs = PreferenceManager.getDefaultSharedPreferences(applicationContext)
    if (prefs.getString("color_option", "BASIC") == "BASIC") {
        setTheme(R.style.Base_Theme_MainApp)
    }
}

fun Context.openActivity(activity: Class<*>) {
    startActivity(Intent(this, activity))
}

fun ImageView.loadImage(url: String?, blurUrl: String? = null, blurLevel: Int = 50, blurTarget: ImageView? = null) {
    try {
        Glide.with(context).load(url).into(this)
        blurTarget?.let {
            Glide.with(context).load(blurUrl ?: url)
                .apply(RequestOptions.bitmapTransform(BlurTransformation(blurLevel)))
                .into(it)
        }
    } catch (e: Exception) {
        setImageResource(R.color.image_profile)
        blurTarget?.setImageResource(R.color.image_profile)
    }
}