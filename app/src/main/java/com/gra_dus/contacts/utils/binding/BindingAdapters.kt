package com.gra_dus.contacts.utils.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.gra_dus.contacts.R
import com.gra_dus.contacts.utils.adapters.CommonAdapter

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgView.load(imgUrl)
}

@BindingAdapter("setAdapter")
fun bindAdapter(recyclerView: RecyclerView, adapter: CommonAdapter) {
    if (recyclerView.adapter == null) {
        recyclerView.adapter = adapter
    }
}