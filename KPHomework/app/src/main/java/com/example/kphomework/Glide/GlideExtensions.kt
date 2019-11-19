package com.example.kphomework.Glide

import android.app.Activity
import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder

fun Activity.loadImage(url: String): RequestBuilder<Drawable> {
    return Glide
        .with(this)
        .load(url)
}