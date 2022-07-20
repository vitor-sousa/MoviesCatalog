package com.vitorsousa.moviescatalog.viewBinder

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("srcUrl")
fun ImageView.loadScrUrl(url: String){
    Glide
        .with(this)
        .load("https://image.tmdb.org/t/p/w300/$url")
        .centerInside()
        .into(this)
}