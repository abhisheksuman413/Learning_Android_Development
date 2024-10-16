package com.fps69.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


//@BindingAdapter("imageFromurl")
//fun  ImageView.imageFromUrl(url:String)
//{
//    Glide.with(this.context).load(url).into(this)
//}


// Upper wale ko ase likhe hai
@BindingAdapter("imageFromurl")
fun urlToImage(view:ImageView, url :String){
    Glide.with(view).load(url).into(view)
}

