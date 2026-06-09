package com.littleapp.rickandmorty.Unit

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.littleapp.rickandmorty.R
import jp.wasabeef.glide.transformations.BlurTransformation

object VOID {

    fun Intent1(context: Context, c: Class<*>?) {
        val intent = Intent(context, c)
        context.startActivity(intent)
    }

    fun Glide(
        context: Context?, Url: String?, Image: ImageView, ImageBlur: ImageView, level: Int,
    ) {
        try {
            Glide.with(context!!).load(Url).into(Image)
            Glide.with(context).load(Url)
                .apply(RequestOptions.bitmapTransform(BlurTransformation(level))).into(ImageBlur)
        } catch (e: Exception) {
            Image.setImageResource(R.color.image_profile)
            ImageBlur.setImageResource(R.color.image_profile)
        }
    }
}