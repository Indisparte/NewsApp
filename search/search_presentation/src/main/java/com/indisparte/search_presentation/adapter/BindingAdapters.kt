package com.indisparte.search_presentation.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide

@BindingAdapter("loadImage")
fun loadImage(imageView: AppCompatImageView, url: String) {

    val circularProgressDrawable = CircularProgressDrawable(imageView.context)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.start()
    Glide.with(imageView.context).load(url).placeholder(circularProgressDrawable)
        .error(com.google.android.material.R.drawable.mtrl_ic_error).into(imageView)
}