package com.vitorsousa.moviescatalog.viewBinder

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.vitorsousa.moviescatalog.utils.ImageUtils
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle


@BindingAdapter("srcUrl")
fun ImageView.loadScrUrl(url: String){
    Glide
        .with(this)
        .load("${ImageUtils.baseImageUrl}$url")
        .centerInside()
        .into(this)
}

@BindingAdapter("dateToFormat")
fun TextView.formatToLocalDate(date: String?) {
    val dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
    this.text = dateTimeFormatter.format(LocalDate.parse(date))
}

@BindingAdapter("imageList")
fun ImageCarousel.imageList(imageList: List<CarouselItem>?) {
    imageList?.let {
        this.setData(it)
    }
}