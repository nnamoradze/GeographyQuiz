package com.example.basketquiz.Extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.basketquiz.R

fun ImageView.setImage(url: String?) {
    if(!url.isNullOrEmpty()) {
        Glide.with(context).load(url).placeholder(R.drawable.userfoto).error(R.drawable.userfoto).into(this)
    } else {
        setImageResource(R.drawable.userfoto)
    }
}