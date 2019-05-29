package org.github.kotlinissues.ui.isssuedetails

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import java.text.ParseException
import java.text.SimpleDateFormat


@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}

@BindingAdapter("bindDate")
fun bindDate(tv: TextView, dateString:String?){
    if(dateString != null) {
        try{
            val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            val date = format.parse(dateString)
            val localFormat = SimpleDateFormat.getDateInstance()
            tv.text = localFormat.format(date)
        } catch (e:ParseException){
            Log.e("Binding", " Unparseable date:$dateString")
        }

    }

}